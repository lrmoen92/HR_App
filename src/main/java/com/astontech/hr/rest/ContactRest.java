package com.astontech.hr.rest;

import com.astontech.hr.domain.Contact;
import com.astontech.hr.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
public class ContactRest {

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Contact> getAllContacts(){
        return contactService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Contact getContact(@PathVariable int id){
        return contactService.findOne(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Contact saveContact(
//            @ModelAttribute("contact")
            @RequestBody
                    Contact contact){
        return contactService.save(contact);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean deleteContact(@PathVariable int id){
        Boolean result = false;
        try{
            contactService.delete(id);
            result = true;
        }catch(Exception ex){

        }
        return result;
    }
}
