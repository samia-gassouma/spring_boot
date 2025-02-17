package com.example.demo2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

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
}
