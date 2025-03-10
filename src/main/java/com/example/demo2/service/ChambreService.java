package com.example.demo2.service;

import com.example.demo2.entity.Chambre;
import com.example.demo2.entity.TypeChambre;
import com.example.demo2.repository.IChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChambreService implements IChambreService {

    @Autowired
    private IChambreRepository chambreRepository;

    @Override
    public List<Chambre> retrieveAllChambres() {
        return (List<Chambre>) chambreRepository.findAll();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre retrieveChambre(long idChambre) {
        return chambreRepository.findById(idChambre).get();
    }

    @Override
    public List <Chambre> getChambreReserve(String nomUniversite, TypeChambre type){
        return chambreRepository.getChambresNonReserveParNomUniversiteEtTypeChambre(nomUniversite, type);
    }

    @Override
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC) {
        return chambreRepository.getChambresParBlocEtType(idBloc, typeC);
    }
}
