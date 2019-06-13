package com.gestionsalaries.demo.service.impl;

import com.gestionsalaries.demo.Entities.Directeur;
import com.gestionsalaries.demo.dao.DirecteurRepository;
import com.gestionsalaries.demo.service.ServiceDirecteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServiceDirecteurImpl implements ServiceDirecteur {

    @Autowired
    DirecteurRepository directeurRepository;

    @Override
    public Directeur savedirecteur(String nom, String email, String telephone) {
        return null;
    }

    @Override
    public Directeur herarchieDirecteur() {
        Directeur directeur = directeurRepository.findAll().get(0);
        return  directeur;


    }
}
