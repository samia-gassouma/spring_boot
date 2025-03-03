package com.example.demo2.repository;

import com.example.demo2.entity.Universite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUniversiteRepository extends CrudRepository<Universite, Long> {
}
