package com.example.demo2.controller;

import com.example.demo2.entity.Etudiant;
import com.example.demo2.entity.Foyer;
import com.example.demo2.service.ChambreService;
import com.example.demo2.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EtudiantController {

    @Autowired
    EtudiantService etudiantService;
    @Autowired
    private ChambreService chambreService;

    @GetMapping("/getAllEtudiant")
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantService.retrieveAllEtudiants();
    }

    @PostMapping("/addEtudiants")
    public List<Etudiant> addEtudiants(@RequestBody List<Etudiant> etudiants) {
        return etudiantService.addEtudiants(etudiants);
    }

    @PutMapping("/updateEtudiant/{id}")
    public Etudiant updateEtudiant(@ RequestBody Etudiant e, @PathVariable long id) {
        Optional<Etudiant> et = Optional.ofNullable(etudiantService.retrieveEtudiant(id));
        if (!et.isPresent()) {
            return null;
        }
        e.setIdEtudiant(id);
        return etudiantService.updateEtudiant(e);
    }

    @GetMapping("/getEtudiant/{id}")
    public Etudiant retrieveEtudiant(@PathVariable("id") long idEtudiant) {
        return etudiantService.retrieveEtudiant(idEtudiant);
    }

    @DeleteMapping("/deleteEtudiant/{id}")
    public void removeEtudiant(@PathVariable("id") long idEtudiant) {
        etudiantService.removeEtudiant(idEtudiant);
    }
}
