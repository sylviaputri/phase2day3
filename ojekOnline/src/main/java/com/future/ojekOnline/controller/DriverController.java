package com.future.ojekOnline.controller;

import com.future.ojekOnline.model.Driver;
import com.future.ojekOnline.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DriverController {

    @Autowired
    private DriverService driverService;

    @RequestMapping(value = {"/api/getAllDrivers"}, method = RequestMethod.GET)
    public List<Driver> getAllDrivers(){
        return driverService.listDrivers();
    }

    @RequestMapping(value = {"/api/getDriverById/{id}"}, method = RequestMethod.GET)
    public Driver getDriverById(@PathVariable("id") Long id){
        return driverService.getDriverById(id);
    }
}
