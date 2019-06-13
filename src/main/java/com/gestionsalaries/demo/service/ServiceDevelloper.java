package com.gestionsalaries.demo.service;

import com.gestionsalaries.demo.Entities.ChefProjet;
import com.gestionsalaries.demo.Entities.Develloper;
import com.gestionsalaries.demo.Entities.Directeur;

public interface ServiceDevelloper {
    public Develloper saveDevelloper(Develloper develloper);
    public Develloper addDevelloperToChefProjet(ChefProjet chef_projet, Develloper develloper);
    public Directeur herarchierDevelopper(Long id);
}
