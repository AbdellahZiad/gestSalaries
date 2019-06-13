package com.gestionsalaries.demo.controller;

import com.gestionsalaries.demo.Entities.Directeur;
import com.gestionsalaries.demo.Entities.Manager;
import com.gestionsalaries.demo.dao.ChefProjerRepository;
import com.gestionsalaries.demo.dao.DeveloppeurRepository;
import com.gestionsalaries.demo.dao.DirecteurRepository;
import com.gestionsalaries.demo.dao.ManagerRepository;
import com.gestionsalaries.demo.service.ServiceDirecteur;
import com.gestionsalaries.demo.service.ServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gs")
public class DirecteurController {
    @Autowired
    DirecteurRepository directeurRepository;

    @Autowired
    DeveloppeurRepository developpeurRepository;

    @Autowired
    ChefProjerRepository chefProjerRepository;

    @Autowired
    ServiceManager serviceManager;

    @Autowired
    ServiceDirecteur serviceDirecteur;



    @PostMapping("/add_directeur")
    public Directeur setDirecteur(@RequestBody Directeur directeur) {
          Directeur directeur1 = new Directeur();
          directeur1.setNom(directeur.getNom());
          directeur1.setEmail(directeur.getEmail());
          directeur1.setTelephone(directeur.getTelephone());

        return directeurRepository.save(directeur1);
    }

    @GetMapping("/add_directeur")
    public List<Directeur> getDirecteur() {
        return directeurRepository.findAll();
    }



    @PutMapping("/update_directeur/{id}")
    Directeur replaceDirecteur(@RequestBody Directeur newDirecteur, @PathVariable Long id) {

        return directeurRepository.findById(id)
                .map(directeur -> {
                    directeur.setNom(newDirecteur.getNom());
                    directeur.setEmail(newDirecteur.getEmail());
                    directeur.setTelephone(newDirecteur.getTelephone());
                    return directeurRepository.save(directeur);
                })
                .orElseGet(() -> {
                    newDirecteur.setId_directeur(id);
                    return directeurRepository.save(newDirecteur);
                });
    }

    @DeleteMapping("/delete_directeur/{id}")
    void deleteDirecteur(@PathVariable Long id) {
        directeurRepository.deleteById(id);
    }


    @GetMapping("/hearchie_directeur")
    public Directeur getHerarchierDirecteur() {
        return serviceDirecteur.herarchieDirecteur();
    }



}


