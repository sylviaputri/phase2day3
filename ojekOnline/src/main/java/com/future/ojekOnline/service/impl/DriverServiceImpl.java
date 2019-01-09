package com.future.ojekOnline.service.impl;

import com.future.ojekOnline.model.Driver;
import com.future.ojekOnline.repository.DriverRepository;
import com.future.ojekOnline.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("driverService")
public class DriverServiceImpl implements DriverService {
    @Autowired
    DriverRepository driverRepository;

    @Override
    public List<Driver> listDrivers() {
        return driverRepository.findAll();
    }

    @Override
    public Driver getDriverById(Long id) {
        return driverRepository.findDriverById(id);
    }

    @Override
    public Driver createDriver(String name, int balance) {
        Driver driver = new Driver(name, balance);
        return driverRepository.save(driver);
    }

    @Override
    public Driver updateDriver(Long id, String name, int balance) {
        Driver driver = driverRepository.findDriverById(id);
        driver.setBalance(balance);
        driver.setName(name);
        return driverRepository.save(driver);
    }

    @Override
    public void deleteDriver(Long id) {
        driverRepository.delete(id);
    }
}
