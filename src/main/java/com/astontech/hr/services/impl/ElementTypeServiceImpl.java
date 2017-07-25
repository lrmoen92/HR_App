package com.astontech.hr.services.impl;

import com.astontech.hr.domain.ElementType;
import com.astontech.hr.repositories.ElementTypeRepository;
import com.astontech.hr.services.ElementTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Logan.Moen on 7/12/2017.
 */
@Service
public class ElementTypeServiceImpl implements ElementTypeService{

    @Autowired
    private ElementTypeRepository elementTypeRepository;

    @Override
    public ElementType getElementTypeById(Integer id) {
        return elementTypeRepository.findOne(id);
    }

    @Override
    public Iterable<ElementType> listAllElementTypes() {
        return elementTypeRepository.findAll();
    }

    @Override
    public ElementType saveElementType(ElementType elementType) {
        return elementTypeRepository.save(elementType);
    }

    @Override
    public Iterable<ElementType> saveElementTypeList(Iterable<ElementType> elementTypeIterable) {
        return elementTypeRepository.save(elementTypeIterable);
    }

    @Override
    public void deleteElementType(Integer id) {
        elementTypeRepository.delete(id);
    }

    @Override
    public List<ElementType> findTop3ByOrderByElementTypeNameDesc() {
        return elementTypeRepository.findTop3ByOrderByElementTypeNameDesc();
    }

    @Override
    public int countByElementTypeName(String elementTypeName) {
        return elementTypeRepository.countByElementTypeName(elementTypeName);
    }

    @Override
    public ElementType findTopByOrderByIdDesc() {
        return elementTypeRepository.findTopByOrderByIdDesc();
    }

    @Override
    public List<ElementType> findAll(){
        return elementTypeRepository.findAll();
    }
}
