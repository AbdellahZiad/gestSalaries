package com.gestionsalaries.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "develloper")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Develloper implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_develloper;

    @Column(unique= true)
    private String nom;

    @Column(unique= true)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_chefProjet", referencedColumnName = "id_chefProjet")
    @JsonIgnore
    private ChefProjet chef_projet;


    public Develloper(){

    }



    public Develloper(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }

    public Long getId_develloper() {
        return id_develloper;
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

    public ChefProjet getChef_projet() {
        return chef_projet;
    }

    public void setChef_projet(ChefProjet chef_projet) {
        this.chef_projet = chef_projet;
    }

    @Override
    public String toString() {
        return "{" +
                "id_develloper=" + id_develloper +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", chef_projet=" + chef_projet +
                '}';
    }




}
