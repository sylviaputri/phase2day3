package com.future.ojekOnline.service;

import com.future.ojekOnline.model.Driver;

import java.util.List;

public interface DriverService {
    public abstract List<Driver> listDrivers();
    public abstract Driver getDriverById(Long id);
    public abstract Driver createDriver(String name, int balance);
    public abstract Driver updateDriver(Long id, String name, int balance);
    public abstract void deleteDriver(Long id);
}
