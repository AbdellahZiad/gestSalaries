package com.gestionsalaries.demo.controller;


import com.gestionsalaries.demo.Entities.ChefProjet;
import com.gestionsalaries.demo.Entities.Develloper;
import com.gestionsalaries.demo.Entities.Manager;
import com.gestionsalaries.demo.dao.ChefProjerRepository;
import com.gestionsalaries.demo.dao.ManagerRepository;
import com.gestionsalaries.demo.service.ServiceChefProjet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gs")
public class ChefProjetController {



    @Autowired
    ServiceChefProjet serviceChefProjet;

    @Autowired
    ChefProjerRepository chefProjerRepository;

    @Autowired
    ManagerRepository managerRepository;

    @PostMapping("/add_chefprojet")
    public ChefProjet setChefProjet(@RequestBody ChefProjet chef_projet) {
      return serviceChefProjet.saveChefProjet(chef_projet);

    }

    @GetMapping("/add_chefprojet")
    public List<ChefProjet> getChefProjet() {
        System.out.println(chefProjerRepository.findAll());
        return chefProjerRepository.findAll();
    }

    @GetMapping("/add_chefprojet/{id}")
    public ChefProjet getOneChefProjet(@PathVariable Long id) {
        return chefProjerRepository.getOne(id);
    }


    @DeleteMapping("/delete_chefprojet/{id}")
    void deleteChefProjet(@PathVariable Long id) {
        chefProjerRepository.deleteById(id);
    }





    @PutMapping("/updtmangr_chfprojt/{id}")
    ChefProjet replaceManagerForChefProjet(@RequestBody Manager manager, @PathVariable Long id){
        ChefProjet chef_projet = chefProjerRepository.getOne(id);
        serviceChefProjet.addChefProjetToManager(chef_projet,manager);
        return chef_projet;
    }

    @GetMapping("/herarchie_chefprojet/{id}")
    public List<Develloper> getHerarchieManager(@PathVariable Long id)
    {
        return serviceChefProjet.getHerarchChefProjet(id);
    }


}
