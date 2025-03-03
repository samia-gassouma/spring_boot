package com.example.demo2.repository;

import com.example.demo2.entity.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReservationRepository extends CrudRepository<Reservation, String> {
}
