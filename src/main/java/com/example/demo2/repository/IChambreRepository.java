package com.example.demo2.repository;

import com.example.demo2.entity.Chambre;
import com.example.demo2.entity.TypeChambre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IChambreRepository extends CrudRepository<Chambre, Long> {
    @Query("SELECT c FROM Chambre c LEFT JOIN c.reservations r WHERE r IS NULL AND c.typeC = :type AND c.bloc.foyer.universite.nomUniversite = :nom")
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(@Param("nom") String nomUniversite, @Param("type") TypeChambre type) ;

    @Query("SELECT c FROM Chambre c WHERE c.bloc.idBloc=:idBloc AND c.typeC=:typeC")
    public List<Chambre> getChambresParBlocEtType (long idBloc, TypeChambre typeC) ;

    List<Chambre> findAllByNumeroChambreIn(List<Long> numChambre);

    long countChambreByIdChambre(long idChambre);
}
