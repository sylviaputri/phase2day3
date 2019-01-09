package com.future.ojekOnline.repository;

import com.future.ojekOnline.model.Booking;
import com.future.ojekOnline.model.StatusBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findAllByUser_IdAndStatusBooking(Long userId, StatusBooking statusBooking);
    Booking findBookingById(Long idBooking);
}
