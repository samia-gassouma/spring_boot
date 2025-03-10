package com.example.demo2.repository;

import com.example.demo2.entity.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IReservationRepository extends CrudRepository<Reservation, String> {
    @Query("SELECT r FROM Chambre c JOIN c.reservations r WHERE YEAR(r.anneeUniversitaire) = YEAR (:anneeUniversite)  AND c.bloc.foyer.universite.nomUniversite= :nomUniversite")
    public List<Reservation> getReservationParNomUniversite(@Param("anneeUniversite") Date anneeUniversite,@Param("nomUniversite") String nomUniversite) ;

}
