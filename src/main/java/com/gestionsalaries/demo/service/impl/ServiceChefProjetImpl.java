package com.gestionsalaries.demo.service.impl;


import com.gestionsalaries.demo.Entities.ChefProjet;
import com.gestionsalaries.demo.Entities.Develloper;
import com.gestionsalaries.demo.Entities.Manager;
import com.gestionsalaries.demo.dao.ChefProjerRepository;
import com.gestionsalaries.demo.dao.ManagerRepository;
import com.gestionsalaries.demo.service.ServiceChefProjet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServiceChefProjetImpl implements ServiceChefProjet {


    @Autowired
    ChefProjerRepository chefProjerRepository;

    @Autowired
    ManagerRepository managerRepository;

    @Override
    public ChefProjet saveChefProjet(ChefProjet chef_projet) {
        return chefProjerRepository.save(chef_projet);
    }

    @Override
    public ChefProjet addChefProjetToManager(ChefProjet chef_projet, Manager manager) {
        ChefProjet chef_projet1 = chefProjerRepository.getOne(chef_projet.getId_chefProjet());
        Manager manager1 = managerRepository.getOne(manager.getId_manager());
        chef_projet1.setManager(manager1);
        return chef_projet;

    }

    @Override
    public List<Develloper> getHerarchChefProjet(Long id) {
        ChefProjet chefProjet = chefProjerRepository.getOne(id);
        return chefProjet.getDevellopers();

    }
}
