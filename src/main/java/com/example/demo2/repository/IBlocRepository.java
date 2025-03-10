package com.example.demo2.repository;

import com.example.demo2.entity.Bloc;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlocRepository extends CrudRepository<Bloc, Long> {

    @Query("select b from Bloc b where b.nomBloc =:nom")
    public List<Bloc> retrieveBlocByName(@Param("nom")String nom);
}
