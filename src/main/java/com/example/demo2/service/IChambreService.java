package com.example.demo2.service;

import com.example.demo2.entity.Chambre;
import com.example.demo2.entity.TypeChambre;

import java.util.List;

public interface IChambreService {
    List<Chambre> retrieveAllChambres();
    Chambre addChambre(Chambre c);
    Chambre updateChambre (Chambre c);
    Chambre retrieveChambre (long idChambre);

    List <Chambre> getChambreReserve(String nomUniversite, TypeChambre type);
    public List<Chambre> getChambresParBlocEtType (long idBloc, TypeChambre typeC) ;
}
