package com.future.ojekOnline.controller;

import com.future.ojekOnline.model.Driver;
import com.future.ojekOnline.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DriverController {

    @Autowired
    private DriverService driverService;

    @RequestMapping(value = {"/api/drivers"}, method = RequestMethod.GET)
    public List<Driver> getAllDrivers(){
        return driverService.listDrivers();
    }

    @RequestMapping(value = {"/api/driver/{id}"}, method = RequestMethod.GET)
    public Driver getDriverById(@PathVariable("id") Long id){
        return driverService.getDriverById(id);
    }
}
