package com.gestionsalaries.demo.controller;

import com.gestionsalaries.demo.Entities.ChefProjet;
import com.gestionsalaries.demo.Entities.Develloper;
import com.gestionsalaries.demo.Entities.Directeur;
import com.gestionsalaries.demo.Entities.Manager;
import com.gestionsalaries.demo.dao.ChefProjerRepository;
import com.gestionsalaries.demo.dao.DeveloppeurRepository;
import com.gestionsalaries.demo.dao.DirecteurRepository;
import com.gestionsalaries.demo.dao.ManagerRepository;
import com.gestionsalaries.demo.service.ServiceChefProjet;
import com.gestionsalaries.demo.service.ServiceDevelloper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/gs")
public class DevelloperController {

    @Autowired
    ChefProjerRepository chefProjerRepository;


    @Autowired
    ServiceDevelloper serviceDevelloper;

    @Autowired
    DeveloppeurRepository developpeurRepository;

    @Autowired
    ManagerRepository managerRepository;

    @Autowired
    DirecteurRepository directeurRepository;


    @PostMapping("/add_develloper")
    public Develloper setDevelloper(@RequestBody Develloper develloper) {
        return serviceDevelloper.saveDevelloper(develloper);

    }

    @GetMapping("/add_develloper/{id}")
    public Develloper getOneDevlloper(@PathVariable Long id) {
        return developpeurRepository.getOne(id);
    }


    @GetMapping("/add_develloper")
    public List<Develloper> getDevlloper() {
        return developpeurRepository.findAll();
    }


    @GetMapping("/herarchiDownTop/{id}")
    public Develloper getHerarchierDevlloper(@PathVariable Long id) {
        Develloper develloper = developpeurRepository.getOne(id);
//        return serviceDevelloper.herarchierDevelopper(id);
        System.out.println(developpeurRepository.selectChefProjetDevelloper(id,id,id));
        return  developpeurRepository.selectChefProjetDevelloper(id,id,id);
    }


    @GetMapping("/herrarchie_dev/{id}")
    public Map<String, Object> getHerarchierDevlloperAll(@PathVariable Long id) {

        Map<String, Object> map = new HashMap<>();
        Develloper develloper = developpeurRepository.getOne(id);
        map.put("-------Herarchier develloper n* ----"+id, develloper.toString());

        return map;
    }



//
//    @GetMapping("/herrarchie_dev/{id}")
//    public String getHerarchierDevlloperAll(@PathVariable Long id) {
//
//
//        Develloper develloper = developpeurRepository.getOne(id);
//        return develloper.toString();
//    }

    @DeleteMapping("/delete_develloper/{id}")
    void deleteChefProjet(@PathVariable Long id) {
        developpeurRepository.deleteById(id);

    }


    @PutMapping("/updtchefprjt_devlper/{id}")
    Develloper replaceChefProjetForDevelloper(@RequestBody Develloper develloper, @PathVariable Long id) {
        ChefProjet chef_projet = chefProjerRepository.getOne(id);
        serviceDevelloper.addDevelloperToChefProjet(chef_projet, develloper);
        Develloper develloper1 = developpeurRepository.getOne(develloper.getId_develloper());
        return develloper1;
    }


}
