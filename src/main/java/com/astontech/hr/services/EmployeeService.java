package com.astontech.hr.services;

import com.astontech.hr.domain.Employee;

public interface EmployeeService {

    Employee save(Employee employee);

    Iterable<Employee> save(Iterable<Employee> employeeIterable);

    Employee findOne(Integer id);

    boolean exists(Integer id);

    Iterable<Employee> findAll();

    long count();

    void delete(Integer id);

    void delete(Employee employee);

    void delete(Iterable<Employee> employeeIterable);

    void deleteAll();
}
