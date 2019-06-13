package com.gestionsalaries.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Manager  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_manager;

    @Column(unique= true)
    private String nom;

    @Column(unique= true)
    private String email;


    @OneToMany(mappedBy="manager", fetch = FetchType.LAZY)
    private List<ChefProjet> chef_projets = new ArrayList<ChefProjet>();



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_directeur", referencedColumnName = "id_directeur")
    @JsonIgnore
    private Directeur directeur;



    public Manager(){
    }


    public Manager(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }



    public Long getId_manager() {
        return id_manager;
    }

    public void setId_manager(Long id_manager) {
        this.id_manager = id_manager;
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

    public List<ChefProjet> getChef_projets() {
        return chef_projets;
    }

    public void setChef_projets(List<ChefProjet> chef_projets) {
        this.chef_projets = chef_projets;
    }

    public Directeur getDirecteur() {
        return directeur;
    }

    public void setDirecteur(Directeur directeur) {
        this.directeur = directeur;
    }

    @Override
    public String toString() {
        return "{" +
                "id_manager=" + id_manager +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", directeur=" + directeur.toString() +
                '}';
    }
}
