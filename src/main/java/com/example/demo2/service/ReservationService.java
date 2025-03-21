package com.example.demo2.service;

import com.example.demo2.entity.*;
import com.example.demo2.repository.IBlocRepository;
import com.example.demo2.repository.IChambreRepository;
import com.example.demo2.repository.IEtudiantRepository;
import com.example.demo2.repository.IReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class ReservationService implements IReservationService {
    @Autowired
    IReservationRepository reservationRepository;

    @Autowired
    IEtudiantRepository etudiantRepository;

    @Autowired
    IBlocRepository blocRepository;

    @Autowired
    IChambreRepository chambreRepository;

    @Override
    public List<Reservation> retrieveAllReservation() {
        return (List<Reservation>) reservationRepository.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation res) {
        return reservationRepository.save(res);
    }

    @Override
    public Reservation retrieveReservation(String idReservation) {
        return reservationRepository.findById(idReservation).get();
    }

    @Override
    public List<Reservation> getReservationParnomUniversite(Date anneeUniversite,String nomUniversite){
        return reservationRepository.getReservationParNomUniversite(anneeUniversite,nomUniversite);
    }

    @Override
    public Reservation ajouterReservation(long idBloc, long cinEtudiant) {
        Etudiant e = etudiantRepository.findByCin(cinEtudiant);
        Bloc b = blocRepository.findById(idBloc).get();

        if(b.getCapaciteBloc() == 0){
            return null;
        }
        b.setCapaciteBloc(b.getCapaciteBloc()-1);
        Set<Chambre> chambres = blocRepository.findById(idBloc).get().getChambres();
        Chambre ch = null;
        Boolean plein = true;
        while (plein && chambres.contains(ch)){
            ch = chambres.iterator().next();
            long countPlaces = chambreRepository.countChambreByIdChambre(ch.getIdChambre());

            if(ch.getTypeC() == TypeChambre.SIMPLE && countPlaces == 1 || ch.getTypeC() == TypeChambre.DOUBLE && countPlaces == 2 || ch.getTypeC() == TypeChambre.DOUBLE && countPlaces == 3){
                plein = true;
            }
            else{
                plein = false;
            }
        }
        if(ch != null){
            String idReservation = ch.getNumeroChambre()+"-"+b.getNomBloc()+"-"+ LocalDate.now().getYear();
            Reservation res = new Reservation();
            res.setIdReservation(idReservation);
            if (reservationRepository.existsById(res.getIdReservation())) {
                throw new IllegalArgumentException("L'ID de la réservation existe déjà !");
            }
            ch.getReservations().add(res);
            chambreRepository.save(ch);
            res.setEstValide(true);
            res.setAnneeUniversitaire(new Date());
            res.getEtudiants().add(e);
            return reservationRepository.save(res);
        }
        else
            return null;

    }
}
