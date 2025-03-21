package com.example.demo2.controller;

import com.example.demo2.entity.Bloc;
import com.example.demo2.entity.Chambre;
import com.example.demo2.entity.Universite;
import com.example.demo2.service.BlocService;
import com.example.demo2.service.UniversiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BlocController {
    @Autowired
    private BlocService blocService;
    @Autowired
    private UniversiteService universiteService;

    @GetMapping("/getAllBloc")
    List<Bloc> retrieveBlocs(){
        return blocService.retrieveBlocs();
    }

    @PutMapping("/updateBloc/{id}")
    public Bloc updateBloc (@RequestBody Bloc bloc, @PathVariable("id") long id){
        Optional<Bloc> b = Optional.ofNullable(blocService.retrieveBloc(id));
        if(!b.isPresent()) {
            return null;
        }
        bloc.setIdBloc(id);
        return blocService.updateBloc(bloc);
    }

    @PostMapping("/addBloc")
    public Bloc addBloc (@RequestBody Bloc bloc){
        return blocService.addBloc(bloc);
    }

    @GetMapping("/getBloc/{id}")
    public Bloc retrieveBloc (@PathVariable("id") long idBloc){
        return blocService.retrieveBloc(idBloc);
    }

    @DeleteMapping("/deleteBloc/{id}")
    public void removeBloc (@PathVariable("id") long idBloc){
        blocService.removeBloc(idBloc);
    }

    @GetMapping("/GetBlocByName/{name}")
    List <Bloc> retrieveBlocByName(@PathVariable("name") String name){
        return blocService.getBlocByName(name);
    }

    @PutMapping("/affecterChambresABloc/{idBloc}")
    public Bloc affecterChambresABloc(@PathVariable("idBloc") long idBloc, @RequestBody List<Long> numChambre){
        return blocService.affecterChambresABloc(numChambre, idBloc);
    }
}
