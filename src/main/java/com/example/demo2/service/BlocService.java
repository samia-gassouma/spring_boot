package com.example.demo2.service;

import com.example.demo2.entity.Bloc;
import com.example.demo2.repository.IBlocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlocService implements IBlocService{
    @Autowired
    IBlocRepository blocRepository;

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
}
