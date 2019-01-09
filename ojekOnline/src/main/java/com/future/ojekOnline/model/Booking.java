package com.future.ojekOnline.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private int harga;

    @Column
    private String tanggal;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_driver", nullable=false)
    private Driver driver;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_user", nullable=false)
    private User user;

    @Enumerated(EnumType.STRING)
    private StatusBooking statusBooking;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Column
    private String lokasiAwal;

    @Column
    private String lokasiTujuan;

    public Booking(){}

    public Booking(User user, Driver driver, String tanggal){
        this.user = user;
        this.driver = driver;
        this.tanggal = tanggal;
    }

    public Booking(int harga, String tanggal, Driver driver, User user, StatusBooking statusBooking, PaymentMethod paymentMethod, String lokasiAwal, String lokasiTujuan){
        this.harga = harga;
        this.user = user;
        this.driver = driver;
        this.tanggal = tanggal;
        this.statusBooking = statusBooking;
        this.paymentMethod = paymentMethod;
        this.lokasiAwal = lokasiAwal;
        this.lokasiTujuan = lokasiTujuan;
    }
}
