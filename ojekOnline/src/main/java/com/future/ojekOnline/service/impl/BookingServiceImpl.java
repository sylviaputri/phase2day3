package com.future.ojekOnline.service.impl;

import com.future.ojekOnline.model.*;
import com.future.ojekOnline.repository.BookingRepository;
import com.future.ojekOnline.repository.DriverRepository;
import com.future.ojekOnline.repository.UserRepository;
import com.future.ojekOnline.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookingService")
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Booking> listHistoryByUserId(Long idUser) {
        return bookingRepository.findAllByUser_IdAndStatusBooking(idUser, StatusBooking.done);
    }

    @Override
    public Booking getBookingById(Long idBooking) {
        return bookingRepository.findBookingById(idBooking);
    }

    @Override
    public Booking cancelBooking(Long idBooking) {
        Booking booking = bookingRepository.findBookingById(idBooking);
        booking.setStatusBooking(StatusBooking.cancel);
        return bookingRepository.save(booking);
    }

    @Override
    public Booking doneBooking(Long idBooking) {
        Booking booking = bookingRepository.findBookingById(idBooking);
        booking.setStatusBooking(StatusBooking.done);

        //kurangi balance user
        User user = booking.getUser();
        user.setBalance(user.getBalance()-booking.getHarga());
        userRepository.save(user);

        //tambah balance driver
        Driver driver = booking.getDriver();
        driver.setBalance(driver.getBalance()+booking.getHarga());
        driverRepository.save(driver);

        //save booking
        return bookingRepository.save(booking);
    }

    @Override
    public Booking bookingDriver(Long idUser, Long idDriver, String tanggal) {
        User user = userRepository.findUserById(idUser);
        Driver driver = driverRepository.findDriverById(idDriver);
        Booking booking = new Booking(user,driver,tanggal);
        return bookingRepository.save(booking);
    }

    @Override
    public Booking createBooking(int harga, String tanggal, Long idDriver, Long idUser, StatusBooking statusBooking, PaymentMethod paymentMethod, String lokasiAwal, String lokasiTujuan) {
        User user = userRepository.findUserById(idUser);
        Driver driver = driverRepository.findDriverById(idDriver);
        Booking booking = new Booking(harga, tanggal, driver, user, statusBooking, paymentMethod, lokasiAwal, lokasiTujuan);
        return bookingRepository.save(booking);
    }

    @Override
    public Booking updateBooking(Long idBooking, int harga, String tanggal, Long idDriver, Long idUser, StatusBooking statusBooking, PaymentMethod paymentMethod, String lokasiAwal, String lokasiTujuan) {
        User user = userRepository.findUserById(idUser);
        Driver driver = driverRepository.findDriverById(idDriver);
        Booking booking = bookingRepository.findBookingById(idBooking);
        booking.setHarga(harga);
        booking.setTanggal(tanggal);
        booking.setUser(user);
        booking.setDriver(driver);
        booking.setStatusBooking(statusBooking);
        booking.setPaymentMethod(paymentMethod);
        booking.setLokasiAwal(lokasiAwal);
        booking.setLokasiTujuan(lokasiTujuan);
        return bookingRepository.save(booking);
    }

    @Override
    public void deleteBooking(Long idBooking) {
        bookingRepository.delete(idBooking);
    }
}
