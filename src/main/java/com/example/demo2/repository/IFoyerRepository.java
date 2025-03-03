package com.example.demo2.repository;

import com.example.demo2.entity.Foyer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFoyerRepository extends CrudRepository<Foyer,Long> {
}
