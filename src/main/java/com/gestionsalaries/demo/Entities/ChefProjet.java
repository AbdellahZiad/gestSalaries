package com.gestionsalaries.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ChefProjet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_chefProjet;

    @Column(unique= true)
    private String nom;

    @Column(unique= true)
    private String email;

    @OneToMany(mappedBy="chef_projet", fetch = FetchType.LAZY)
    private List<Develloper> devellopers = new ArrayList<Develloper>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_manager", referencedColumnName = "id_manager")
    @JsonIgnore
    private Manager manager;




    public ChefProjet(){
    }

    public ChefProjet(String nom, String email) {
        this.nom = nom;
        this.email = email;

    }




    public Long getId_chefProjet() {
        return id_chefProjet;
    }



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public List<Develloper> getDevellopers() {
        return devellopers;
    }

    public void setDevellopers(List<Develloper> devellopers) {
        this.devellopers = devellopers;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "{" +
                "id_chefProjet=" + id_chefProjet +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", manager=" + manager.toString() +
                '}';
    }

}
