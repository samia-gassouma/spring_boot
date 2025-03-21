package com.example.demo2.service;

import com.example.demo2.entity.Bloc;
import com.example.demo2.entity.Chambre;
import com.example.demo2.repository.IBlocRepository;
import com.example.demo2.repository.IChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlocService implements IBlocService{
    @Autowired
    IBlocRepository blocRepository;

    @Autowired
    IChambreRepository chambreRepository;

    @Override
    public List<Bloc> retrieveBlocs() {
        return (List<Bloc>) blocRepository.findAll();
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc retrieveBloc(long idBloc) {
        return blocRepository.findById(idBloc).get();
    }

    @Override
    public void removeBloc(long idBloc) {
        blocRepository.deleteById(idBloc);
    }

    @Override
    public List<Bloc> getBlocByName(String name) {
        return blocRepository.retrieveBlocByName(name);
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc){
        Bloc bloc = blocRepository.findById(idBloc).get();
        List<Chambre> chambres = chambreRepository.findAllByNumeroChambreIn(numChambre);
        if (chambres.isEmpty()) {
            throw new RuntimeException("Aucune chambre trouvée avec les numéros spécifiés : " + numChambre);
        }
        chambres.forEach(chambre -> {
            chambre.setBloc(bloc);
        });
        chambreRepository.saveAll(chambres);
        return bloc;
    }
}
