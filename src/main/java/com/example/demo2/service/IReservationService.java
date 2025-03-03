package com.example.demo2.service;

import com.example.demo2.entity.Reservation;

import java.util.List;

public interface IReservationService {
    List<Reservation> retrieveAllReservation();
    Reservation updateReservation (Reservation  res);
    Reservation retrieveReservation (String idReservation);

}
