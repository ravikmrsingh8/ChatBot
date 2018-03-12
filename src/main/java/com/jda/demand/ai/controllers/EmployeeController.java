package com.jda.demand.ai.controllers;

import com.jda.demand.ai.model.Employee;
import com.jda.demand.ai.services.employees.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@CrossOrigin
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> employees() {
        return service.findAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Employee findEmployee(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addEmployee(@RequestBody Employee e) {
        service.save(e);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Employee updateEmployee(@RequestBody Employee e) {
        return service.update(e);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Employee deleteEmployee(@PathVariable long id) {
        return service.remove(id);
    }
}
