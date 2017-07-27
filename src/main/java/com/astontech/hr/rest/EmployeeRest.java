package com.astontech.hr.rest;

import com.astontech.hr.domain.Employee;
import com.astontech.hr.services.EmployeeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeRest {

    private Logger log = Logger.getLogger(EmployeeRest.class);

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Employee> getAll(){
        return employeeService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Employee getById(@PathVariable int id){
        return employeeService.findOne(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Employee save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable int id){
        boolean result = false;
        try{
            employeeService.delete(id);
            result = true;
        }catch(Exception ex){
            log.info(ex);
        }
        return result;
    }


}
