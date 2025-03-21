package com.example.demo2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Chambre implements Serializable {
    @Id
    @GeneratedValue
    private long idChambre;
    private long numeroChambre;
    private TypeChambre typeC;
    @ManyToOne
    @JsonIgnore
    private Bloc bloc;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Reservation> reservations;
}
