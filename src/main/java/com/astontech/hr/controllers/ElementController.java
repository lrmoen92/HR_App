package com.astontech.hr.controllers;

import com.astontech.hr.domain.Element;
import com.astontech.hr.domain.ElementType;
import com.astontech.hr.domain.VO.ElementVO;
import com.astontech.hr.services.ElementTypeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Logan.Moen on 7/13/2017.
 */
@Controller
public class ElementController {

    @Autowired
    private ElementTypeService elementTypeService;

    private Logger log = Logger.getLogger(ElementController.class);

    @RequestMapping(value = "/admin/element/add", method = RequestMethod.GET)
    public String adminElementGet(Model model){
        model.addAttribute("elementVO", new ElementVO());
        model.addAttribute("warningAlert", "visible");
        return "admin/element/element_add";
    }

    @RequestMapping(value = "/admin/element/add", method = RequestMethod.POST)
    public String adminElementPost(ElementVO elementVO, Model model){
        elementVO.splitNewElementsIntoArray();
        logElementVO(elementVO);

        if(saveElementTypeAndElementsFromVO(elementVO))
            model.addAttribute("successAlert", "visible");
        else
            model.addAttribute("errorAlert", "visible");

        model.addAttribute("elementVO", new ElementVO());
        return "admin/element/element_add";
    }

    @RequestMapping(value = "/admin/element/list", method = RequestMethod.GET)
    public String adminElementList(Model model){
        model.addAttribute("elementTypeList", elementTypeService.listAllElementTypes());

        return "admin/element/element_list";
    }

    @RequestMapping(value = "/admin/element/edit/{id}", method = RequestMethod.GET)
    public String adminElementTypeEdit(@PathVariable int id, Model model){
        model.addAttribute("elementType", elementTypeService.getElementTypeById(id));
        model.addAttribute("elementList", elementTypeService.getElementTypeById(id).getElementList());

        return "admin/element/element_edit";
    }

    @RequestMapping(value = "/admin/element/delete/{id}", method = RequestMethod.GET)
    public String adminElementTypeDelete(@PathVariable int id){
        elementTypeService.deleteElementType(id);
        return "redirect:/admin/element/list";
    }

    @RequestMapping(value = "/admin/element/update", method = RequestMethod.POST)
    public String elementTypeUpdate(ElementType elementType, Model model, @RequestParam("inputNewElement") String newElement){
        // if newElement exists, add to list if not move on
        if(!newElement.equals("")){
            if(elementType.getElementList() == null){
                List<Element> elementList = new ArrayList<>();
                elementList.add(new Element(newElement));
                elementType.setElementList(elementList);
            } else {
                elementType.getElementList().add(new Element(newElement));
            }
        }
        //iterate through list of elements
        for(int i = 0; i < elementType.getElementList().size(); i++){
            //check if value is "", if so, remove
            if(elementType.getElementList().get(i).getElementName().equals("")){
                elementType.getElementList().remove(i);
            }
        }
        elementTypeService.saveElementType(elementType);

        return "redirect:/admin/element/edit/" + elementType.getId();
    }



    private boolean saveElementTypeAndElementsFromVO(ElementVO elementVO){
        List<Element> newElementList = new ArrayList<>();
        for(String str : elementVO.getNewElementArray()){
            newElementList.add(new Element(str));
        }
        ElementType newElementType = new ElementType(elementVO.getNewElementType());
        newElementType.setElementList(newElementList);
        int prevSize = elementTypeService.findAll().size();

        elementTypeService.saveElementType(newElementType);

        int curSize = elementTypeService.findAll().size();
        if(prevSize == curSize){
            return false;
        }
            else return true;

    }

    private void logElementVO(ElementVO elementVO){
        log.info("New Element Type: " + elementVO.getNewElementType());
        for(String str : elementVO.getNewElementArray()) {
            log.info("New Element: " + str);
        }
    }
}
