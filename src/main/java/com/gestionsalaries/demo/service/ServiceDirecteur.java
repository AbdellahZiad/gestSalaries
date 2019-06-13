package com.gestionsalaries.demo.service;

import com.gestionsalaries.demo.Entities.Directeur;

import java.util.List;

public interface ServiceDirecteur {

    public Directeur savedirecteur(String nom, String email, String telephone);
    public Directeur herarchieDirecteur();

    //    public AppUser loadUserByUsername(String username);
//    public void addRoleToUser(String username, String rolename);
//    public void saveUser(AppUser appUser);
}
