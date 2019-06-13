package com.gestionsalaries.demo.dao;

import com.gestionsalaries.demo.Entities.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ManagerRepository extends JpaRepository<Manager,Long>{
    Manager findByNom(String nom);
    Manager findByEmail(String email);

//    @Query("select manager from FondsDataCashflow manager where manager.directeur.id_directeur = ?1 " + "and manager.chef_projets.id_chefProjet= ?1")
//    Manager selectManager(Long id_directeur, Long id_chefProjet);
}
