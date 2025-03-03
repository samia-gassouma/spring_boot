package com.example.demo2.repository;

import com.example.demo2.entity.Chambre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IChambreRepository extends CrudRepository<Chambre, Long> {
}
