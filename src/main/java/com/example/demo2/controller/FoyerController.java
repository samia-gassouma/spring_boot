package com.example.demo2.controller;

import com.example.demo2.entity.Foyer;
import com.example.demo2.service.FoyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FoyerController  {

    @Autowired
    FoyerService foyerService;

    @GetMapping("/getAllFoyer")
    public List<Foyer> retrieveAllFoyers() {
        return foyerService.retrieveAllFoyers();
    }

    @PostMapping("/addFoyer")
    public Foyer saveFoyer(@RequestBody Foyer f) {
        return foyerService.addFoyer(f);
    }


    @PutMapping("/updateFoyer/{id}")
    public Foyer updateFoyer(@RequestBody Foyer f, @PathVariable("id") long id) {
        Optional<Foyer> foyer = Optional.ofNullable(foyerService.retrieveFoyer(id));
        if(!foyer.isPresent()) {
            return null;
        }
            f.setIdFoyer(id);
            return foyerService.updateFoyer(f);
    }

    @GetMapping("/getFoyer/{id}")
    public Foyer retrieveFoyer(@PathVariable("id") long idFoyer) {
        return foyerService.retrieveFoyer(idFoyer);
    }

    @DeleteMapping("deleteFoyer/{id}")
    public void removeFoyer(@PathVariable("id") long idFoyer) {
        foyerService.removeFoyer(idFoyer);
    }

}
