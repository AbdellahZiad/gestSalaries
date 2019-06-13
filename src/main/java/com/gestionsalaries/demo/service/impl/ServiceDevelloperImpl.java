package com.gestionsalaries.demo.service.impl;

import com.gestionsalaries.demo.Entities.ChefProjet;
import com.gestionsalaries.demo.Entities.Develloper;
import com.gestionsalaries.demo.Entities.Directeur;
import com.gestionsalaries.demo.dao.ChefProjerRepository;
import com.gestionsalaries.demo.dao.DeveloppeurRepository;
import com.gestionsalaries.demo.dao.DirecteurRepository;
import com.gestionsalaries.demo.service.ServiceDevelloper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServiceDevelloperImpl implements ServiceDevelloper {

    @Autowired
    DeveloppeurRepository developpeurRepository;
    @Autowired
    ChefProjerRepository chefProjerRepository;

    @Autowired
    DirecteurRepository directeurRepository;


    @Override
    public Develloper saveDevelloper(Develloper develloper) {
        if (developpeurRepository.findByNom(develloper.getNom())!= null || developpeurRepository.findByEmail(develloper.getEmail())!=null) {
            throw new RuntimeException("cet Manager existe déjà !");
        }
        else
            return developpeurRepository.save(develloper);
    }


    @Override
    public Develloper addDevelloperToChefProjet(ChefProjet chef_projet, Develloper develloper) {
        ChefProjet chef_projet1 = chefProjerRepository.getOne(chef_projet.getId_chefProjet());
        Develloper develloper1 = developpeurRepository.getOne(develloper.getId_develloper());
        develloper1.setChef_projet(chef_projet1);
        return develloper1;
    }

    @Override
    public Directeur herarchierDevelopper(Long id) {
        Develloper develloper = developpeurRepository.getOne(id);
        Directeur directeur = develloper.getChef_projet().getManager().getDirecteur();
//        .getManager().getDirecteur();
        return  directeur;

    }
}
