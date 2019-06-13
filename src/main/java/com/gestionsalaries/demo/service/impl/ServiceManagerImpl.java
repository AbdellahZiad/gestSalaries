package com.gestionsalaries.demo.service.impl;


import com.gestionsalaries.demo.Entities.ChefProjet;
import com.gestionsalaries.demo.Entities.Directeur;
import com.gestionsalaries.demo.Entities.Manager;
import com.gestionsalaries.demo.dao.DirecteurRepository;
import com.gestionsalaries.demo.dao.ManagerRepository;
import com.gestionsalaries.demo.service.ServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServiceManagerImpl implements ServiceManager {


    @Autowired
    ManagerRepository managerRepository;

    @Autowired
    DirecteurRepository directeurRepository;

    @Override
    public Manager saveManager(Manager manager) {
        if (managerRepository.findByNom(manager.getNom())!= null || managerRepository.findByEmail(manager.getEmail())!=null) {
            throw new RuntimeException("cet Manager existe déjà !");
        }
        else
            return managerRepository.save(manager);
    }

    @Override
    public Manager addManagerToDirecteur(Directeur directeur, Manager manager) {
        Manager manager1 = managerRepository.getOne(manager.getId_manager());
        Directeur directeur1 = directeurRepository.getOne(directeur.getId_directeur());
        manager1.setDirecteur(directeur1);
        return manager1;
    }

    @Override
    public List<Manager> getAllManager() {
        return managerRepository.findAll();
    }

    @Override
    public List<ChefProjet> getHerarchManager(Long id) {
        Manager manager = managerRepository.getOne(id);
        return manager.getChef_projets();

    }
}
