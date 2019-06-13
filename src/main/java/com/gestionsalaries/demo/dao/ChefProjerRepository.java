package com.gestionsalaries.demo.dao;

import com.gestionsalaries.demo.Entities.ChefProjet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChefProjerRepository extends JpaRepository<ChefProjet,Long> {
    Boolean existsByNom(String nom);
    Boolean existsByEmail(String email);

}
