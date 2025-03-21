package com.example.demo2.controller;

import com.example.demo2.entity.Reservation;
import com.example.demo2.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/getAllReservation")
    public List<Reservation> retrieveAllReservation(){
        return reservationService.retrieveAllReservation();
    }

    @PutMapping("/updateReservation/{id}")
    public Reservation updateReservation (@RequestBody Reservation  res,@PathVariable("id") String id){
        Optional<Reservation> reservation = Optional.ofNullable(reservationService.retrieveReservation(id));
        if(!reservation.isPresent()){
            return null;
        }
        //res.setIdReservation(id);
        return reservationService.updateReservation(res);
    }

    @GetMapping("/getReservation/{id}")
    public Reservation retrieveReservation (@PathVariable("id") String idReservation){
        return reservationService.retrieveReservation(idReservation);
    }

    @GetMapping("/getReservationParUniversite")
    public List<Reservation> retrieveReservationParuniversite(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date anneeUniversite, @RequestParam String nomUniversite){
        return reservationService.getReservationParnomUniversite(anneeUniversite,nomUniversite);
    }

    @PostMapping("/addReservation/{idBloc}/{cinEtudiant}")
    public Reservation createReservation(@PathVariable long idBloc, @PathVariable int cinEtudiant){
        return reservationService.ajouterReservation(idBloc,cinEtudiant);
    }
}
