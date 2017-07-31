package com.astontech.hr.services;

import com.astontech.hr.domain.Address;

public interface AddressService {

    Address save(Address object);

    Iterable<Address> save(Iterable<Address> objectIterable);

    Address findOne(Integer id);

    boolean exists(Integer id);

    Iterable<Address> findAll();

    long count();

    void delete(Integer id);

    void delete(Address object);

    void delete(Iterable<Address> objectIterable);

    void deleteAll();
}