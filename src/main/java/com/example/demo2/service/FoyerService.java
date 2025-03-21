package com.example.demo2.service;

import com.example.demo2.entity.Bloc;
import com.example.demo2.entity.Foyer;
import com.example.demo2.entity.Universite;
import com.example.demo2.repository.IFoyerRepository;
import com.example.demo2.repository.IUniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class FoyerService implements IFoyerService{

    @Autowired
    IFoyerRepository foyerRepository;

    @Autowired
    IUniversiteRepository universiteRepository;

    @Override
    public List<Foyer> retrieveAllFoyers() {
        return (List<Foyer>) foyerRepository.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer retrieveFoyer(long idFoyer) {
        return foyerRepository.findById(idFoyer).get();
    }

    @Override
    public void removeFoyer(long idFoyer) {
        foyerRepository.deleteById(idFoyer);
    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).get();
        Set<Bloc> blocs = foyer.getBlocs();
        if(blocs != null) {
            blocs.forEach(bloc -> {
                bloc.setFoyer(foyer);
            });
        }


        universite.setFoyer(foyer);
        return foyerRepository.save(foyer);
    }

}
