package com.astontech.hr.services.impl;

import com.astontech.hr.domain.Contact;
import com.astontech.hr.repositories.ContactRepository;
import com.astontech.hr.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact save(Contact object) {
        return contactRepository.save(object);
    }

    @Override
    public Iterable<Contact> save(Iterable<Contact> objectIterable) {
        return contactRepository.save(objectIterable);
    }

    @Override
    public Contact findOne(Integer id) {
        return contactRepository.findOne(id);
    }

    @Override
    public boolean exists(Integer id) {
        return contactRepository.exists(id);
    }

    @Override
    public Iterable<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public long count() {
        return contactRepository.count();
    }

    @Override
    public void delete(Integer id) {
        contactRepository.delete(id);
    }

    @Override
    public void delete(Contact object) {
        contactRepository.delete(object);
    }

    @Override
    public void delete(Iterable<Contact> objectIterable) {
        contactRepository.delete(objectIterable);
    }

    @Override
    public void deleteAll() {
        contactRepository.deleteAll();
    }
}
