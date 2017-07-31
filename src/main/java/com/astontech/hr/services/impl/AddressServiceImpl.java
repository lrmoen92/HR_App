package com.astontech.hr.services.impl;

import com.astontech.hr.domain.Address;
import com.astontech.hr.repositories.AddressRepository;
import com.astontech.hr.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address save(Address object) {
        return addressRepository.save(object);
    }

    @Override
    public Iterable<Address> save(Iterable<Address> objectIterable) {
        return addressRepository.save(objectIterable);
    }

    @Override
    public Address findOne(Integer id) {
        return addressRepository.findOne(id);
    }

    @Override
    public boolean exists(Integer id) {
        return addressRepository.exists(id);
    }

    @Override
    public Iterable<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public long count() {
        return addressRepository.count();
    }

    @Override
    public void delete(Integer id) {
        addressRepository.delete(id);
    }

    @Override
    public void delete(Address object) {
        addressRepository.delete(object);
    }

    @Override
    public void delete(Iterable<Address> objectIterable) {
        addressRepository.delete(objectIterable);
    }

    @Override
    public void deleteAll() {
        addressRepository.deleteAll();
    }
}
