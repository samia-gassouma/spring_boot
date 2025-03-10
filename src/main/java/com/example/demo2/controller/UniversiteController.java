package com.example.demo2.controller;

import com.example.demo2.entity.Universite;
import com.example.demo2.repository.IUniversiteRepository;
import com.example.demo2.service.UniversiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UniversiteController {

    @Autowired
    UniversiteService universiteService;

    @GetMapping("/getAllUniversities")
    public List<Universite> retrieveAllUniversities() {
        return universiteService.retrieveAllUniversities();
    }

    @PostMapping("/addUniversity")
    public Universite addUniversite(@RequestBody Universite u) {
        return universiteService.addUniversite(u);
    }

    @PutMapping("/updateUniversity/{id}")
    public Universite updateUniversite(@RequestBody Universite u,@PathVariable("id") long id) {
        Optional<Universite> universite = Optional.ofNullable(universiteService.retrieveUniversite(id));
        if (!universite.isPresent()) {
            return null;
        }
        u.setIdUniversite(id);
        return universiteService.updateUniversite(u);
    }

    @DeleteMapping("/deleteUniversity/{id}")
    public Universite retrieveUniversite(@PathVariable("id") long idUniversite) {
        return universiteService.retrieveUniversite(idUniversite);
    }

    @PutMapping("/affecterFoyerUniversite/{id}/{nom}")
    public Universite affecterUni(@PathVariable("id") long id, @PathVariable("nom") String nom){
        return universiteService.affecterFoyerAUniversite(id, nom);
    }
}
