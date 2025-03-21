package com.example.demo2.repository;

import com.example.demo2.entity.Etudiant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEtudiantRepository extends CrudRepository<Etudiant,Long> {
    Etudiant findByCin(long cinEtudiant);
}
