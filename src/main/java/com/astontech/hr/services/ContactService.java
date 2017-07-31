package com.astontech.hr.services;

import com.astontech.hr.domain.Contact;

public interface ContactService {

    Contact save(Contact object);

    Iterable<Contact> save(Iterable<Contact> objectIterable);

    Contact findOne(Integer id);

    boolean exists(Integer id);

    Iterable<Contact> findAll();

    long count();

    void delete(Integer id);

    void delete(Contact object);

    void delete(Iterable<Contact> objectIterable);

    void deleteAll();
}