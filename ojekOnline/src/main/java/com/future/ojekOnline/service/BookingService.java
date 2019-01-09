package com.future.ojekOnline.service;

import com.future.ojekOnline.model.Booking;
import com.future.ojekOnline.model.PaymentMethod;
import com.future.ojekOnline.model.StatusBooking;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.logging.Logger;

public interface BookingService {
    public abstract List<Booking> listHistoryByUserId(Long idUser);
    public abstract Booking getBookingById(Long idBooking);
    public abstract Booking cancelBooking(Long idBooking);
    public abstract Booking doneBooking(Long idBooking);
    public abstract Booking bookingDriver(Long idUser, Long idDriver, String tanggal);
    public abstract Booking createBooking(int harga, String tanggal, Long idDriver, Long idUser, StatusBooking statusBooking, PaymentMethod paymentMethod, String lokasiAwal, String lokasiTujuan);
    public abstract Booking updateBooking(Long idBooking, int harga, String tanggal, Long idDriver, Long idUser, StatusBooking statusBooking, PaymentMethod paymentMethod, String lokasiAwal, String lokasiTujuan);
    public abstract void deleteBooking(Long idBooking);
}
