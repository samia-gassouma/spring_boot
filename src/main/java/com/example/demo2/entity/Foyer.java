package com.example.demo2.entity;

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
public class Foyer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFoyer;
    private String nomFoyer;
    private long capaciteFoyer;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "foyer")
    private Universite universite;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="foyer")
    private Set<Bloc> blocs;

    @Override
    public String toString() {
        return "Foyer{" +
                "idForyer=" + idFoyer +
                ", nomFoyer='" + nomFoyer + '\'' +
                ", capaciteFoyer=" + capaciteFoyer +
                ", universite=" + universite +
                ", Blocs=" + blocs +
                '}';
    }
}
