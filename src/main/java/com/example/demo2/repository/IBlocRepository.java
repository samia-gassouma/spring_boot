package com.example.demo2.repository;

import com.example.demo2.entity.Bloc;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlocRepository extends CrudRepository<Bloc, Long> {
}
