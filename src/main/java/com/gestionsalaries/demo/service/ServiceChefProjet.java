package com.gestionsalaries.demo.service;

import com.gestionsalaries.demo.Entities.ChefProjet;
import com.gestionsalaries.demo.Entities.Develloper;
import com.gestionsalaries.demo.Entities.Manager;

import java.util.List;

public interface ServiceChefProjet {
    public ChefProjet saveChefProjet(ChefProjet chef_projet);
    public ChefProjet addChefProjetToManager(ChefProjet chef_projet, Manager manager);
    public List<Develloper> getHerarchChefProjet(Long id);

}
