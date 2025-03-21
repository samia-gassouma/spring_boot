package com.example.demo2.service;

import com.example.demo2.entity.Foyer;

import java.util.List;

public interface IFoyerService {
    List<Foyer> retrieveAllFoyers();
    Foyer addFoyer (Foyer f);
    Foyer updateFoyer (Foyer f);
    Foyer retrieveFoyer (long idFoyer);
    void removeFoyer (long idFoyer);

    Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite);
}
