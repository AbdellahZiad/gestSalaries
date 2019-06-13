package com.gestionsalaries.demo.service;

import com.gestionsalaries.demo.Entities.ChefProjet;
import com.gestionsalaries.demo.Entities.Directeur;
import com.gestionsalaries.demo.Entities.Manager;

import java.util.List;

public interface ServiceManager {

    public Manager saveManager(Manager manager);
    public Manager addManagerToDirecteur(Directeur directeur, Manager manager);
    public List<Manager> getAllManager();
    public List<ChefProjet> getHerarchManager(Long id);




}
