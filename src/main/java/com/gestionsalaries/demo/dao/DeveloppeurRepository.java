package com.gestionsalaries.demo.dao;

import com.gestionsalaries.demo.Entities.Develloper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DeveloppeurRepository extends JpaRepository<Develloper,Long> {
    Boolean existsByNom(String nom);
    Boolean existsByEmail(String email);
    Develloper findByNom(String nom);
    Develloper findByEmail(String email);

    @Query("select developer from Develloper developer,ChefProjet chefProjet,Manager manager  where developer.chef_projet.id_chefProjet = ?1 and chefProjet.manager.id_manager= ?2 and manager.directeur.id_directeur= ?3")
    Develloper selectChefProjetDevelloper(Long id_chefProjet,Long id_manager,Long id_directeur);


    /*Request sql  select * from develloper dv,chef_projet chefProjet,manager manager,directeur d  where chefProjet.id_chef_projet = 1 and manager.id_manager= 1 and d.id_directeur=1 AND dv.id_develloper = 1*/

}

