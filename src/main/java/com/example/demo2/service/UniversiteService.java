package com.example.demo2.service;

import com.example.demo2.entity.Foyer;
import com.example.demo2.entity.Universite;
import com.example.demo2.repository.IFoyerRepository;
import com.example.demo2.repository.IUniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversiteService implements IUniversiteService {

    @Autowired
    IUniversiteRepository universiteRepository;

    @Autowired
    IFoyerRepository foyerRepository;

    @Override
    public List<Universite> retrieveAllUniversities() {
        return (List<Universite>) universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversite(long idUniversite) {
        return universiteRepository.findById(idUniversite).get();
    }

    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite);
        assert universite != null;
        Foyer foyer = foyerRepository.findById(idFoyer).get();
        universite.setFoyer(foyer);
        return universiteRepository.save(universite); // Ensure the update is persisted

    }

}
