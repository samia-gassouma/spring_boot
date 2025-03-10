package com.example.demo2.controller;

import com.example.demo2.entity.Chambre;
import com.example.demo2.entity.TypeChambre;
import com.example.demo2.service.ChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ChambreController {

    @Autowired
    private ChambreService chambreService;

    @GetMapping("/getAllChambre")
    public List<Chambre> retrieveAllChambres(){
        return chambreService.retrieveAllChambres();
    }

    @PostMapping("/addChambre")
    public Chambre addChambre(@RequestBody Chambre c){
        return chambreService.addChambre(c);
    }

    @PutMapping("/updateChambre/{id}")
    public Chambre updateChambre (@RequestBody Chambre c, @PathVariable("id") int id){
        Optional<Chambre> chambre = Optional.ofNullable(chambreService.retrieveChambre(id));
        if(!chambre.isPresent()){
            return null;
        }
        c.setIdChambre(id);
        return chambreService.updateChambre(c);
    }

    @GetMapping("/getChambre/{id}")
    public Chambre retrieveChambre (@PathVariable("id") long idChambre){
        return chambreService.retrieveChambre(idChambre);
    }

    @GetMapping("/getChambreReserve")
    public List<Chambre> retrieveChambreReserve(@RequestParam("nomUniversite") String nomUniversite, @RequestParam("type") TypeChambre type){
        return chambreService.getChambreReserve(nomUniversite, type);
    }

    @GetMapping("/getChambreParBlocEtType")
    public List<Chambre> retrieveChambreParBlocEtType(@RequestParam("idBloc") long idBloc, @RequestParam("type") TypeChambre type){
        return chambreService.getChambresParBlocEtType(idBloc, type);
    }
}
