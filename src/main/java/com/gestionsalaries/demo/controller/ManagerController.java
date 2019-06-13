package com.gestionsalaries.demo.controller;


import com.gestionsalaries.demo.Entities.ChefProjet;
import com.gestionsalaries.demo.Entities.Directeur;
import com.gestionsalaries.demo.Entities.Manager;
import com.gestionsalaries.demo.dao.DirecteurRepository;
import com.gestionsalaries.demo.dao.ManagerRepository;
import com.gestionsalaries.demo.service.ServiceManager;
import com.gestionsalaries.demo.service.impl.ServiceManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gs")
public class ManagerController {

    @Autowired
    ServiceManager serviceManager;
    @Autowired
    ManagerRepository managerRepository;

    @Autowired
    DirecteurRepository directeurRepository;



    @PostMapping("/add_manager")
    public Manager setManager(@RequestBody Manager manager) {
        if (serviceManager.saveManager(manager)== null )
            throw new RuntimeException("cet Manager existe déjà !");
        else
            return manager;
    }

//    @GetMapping("/add_manager")
//    public List<Manager> getManager() {
//        return serviceManager.getAllManager();
//    }
//



    @PutMapping("/update_manager/{id}")
    Manager replaceManager(@RequestBody Manager newManager, @PathVariable Long id) {

        return managerRepository.findById(id)
                .map(manager -> {
                    manager.setNom(newManager.getNom());
                    manager.setEmail(newManager.getEmail());
                    return managerRepository.save(manager);
                })
                .orElseGet(() -> {
                    newManager.setId_manager(id);
                    return managerRepository.save(newManager);
                });
    }

    @DeleteMapping("/delete_manager/{id}")
    void deleteManager(@PathVariable Long id) {
        managerRepository.deleteById(id);
    }



    @GetMapping("/add_manager/{id}")
    public Manager getOneManager(@PathVariable Long id) {
        return managerRepository.getOne(id);
    }

    @GetMapping("/add_manager")
    public List<Manager> getManager() {
        return serviceManager.getAllManager();
    }

    @GetMapping("/herarchie_manager/{id}")
    public List<ChefProjet> getHerarchieManager(@PathVariable Long id)
    {
        return serviceManager.getHerarchManager(id);
    }

}
