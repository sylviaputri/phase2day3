package com.future.ojekOnline.repository;

import com.future.ojekOnline.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    Driver findDriverById(Long id);
}
