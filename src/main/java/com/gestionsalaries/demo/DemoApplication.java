package com.gestionsalaries.demo;

import com.gestionsalaries.demo.Entities.ChefProjet;
import com.gestionsalaries.demo.Entities.Develloper;
import com.gestionsalaries.demo.Entities.Directeur;
import com.gestionsalaries.demo.Entities.Manager;
import com.gestionsalaries.demo.dao.DeveloppeurRepository;
import com.gestionsalaries.demo.dao.DirecteurRepository;
import com.gestionsalaries.demo.service.ServiceChefProjet;
import com.gestionsalaries.demo.service.ServiceDevelloper;
import com.gestionsalaries.demo.service.ServiceManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication  implements CommandLineRunner {


    @Autowired
    ServiceDevelloper serviceDevelloper;

    @Autowired
    ServiceChefProjet serviceChefProjet;

    @Autowired
    ServiceManager serviceManager;

    @Autowired
    DirecteurRepository directeurRepository;


    private static Logger log = LoggerFactory.getLogger(DemoApplication.class);


    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
        System.out.println("\t \t ---------------------------------------- Gestion des salaries ------------------------ !!!");
        log.info("------Gestion Salaire-------------------");
    }



    @Override
    public void run(String... args) throws Exception {

        System.out.println("\t \t ---------------------------------------- Ajouter le Directeur------------------------ !!!");

        Directeur directeur=new Directeur();
        directeur.setEmail("mfourka@lnet.ma");
        directeur.setNom("Mohamed");
        directeur.setTelephone("+212 0522502001");
        directeurRepository.save(directeur);

        System.out.println("\t \t ---------------------------------------- Ajouter les Managers------------------------ !!!");
        Manager manager = new Manager("Adam","adam@lnet.ma");
        serviceManager.saveManager(manager);
        serviceManager.addManagerToDirecteur(directeur,manager);

        Manager manager1 = new Manager("Said","said@lnet.ma");
        serviceManager.saveManager(manager1);
        serviceManager.addManagerToDirecteur(directeur,manager1);

        Manager manager2 = new Manager("Amin","amin@lnet.ma");
        serviceManager.saveManager(manager2);
        serviceManager.addManagerToDirecteur(directeur,manager2);


        System.out.println("\t \t ---------------------------------------- Ajouter les Chefs de Projet------------------------ !!!");
        ChefProjet chef_projet = new ChefProjet("Ahmed","ahmed@lnet.ma");
        serviceChefProjet.saveChefProjet(chef_projet);
        serviceChefProjet.addChefProjetToManager(chef_projet,manager);

        ChefProjet chef_projet1 = new ChefProjet("Ayoub","ayoub@lnet.ma");
        serviceChefProjet.saveChefProjet(chef_projet1);
        serviceChefProjet.addChefProjetToManager(chef_projet1,manager);

        ChefProjet chef_projet2 = new ChefProjet("Yasser","yasser@lnet.ma");
        serviceChefProjet.saveChefProjet(chef_projet2);
        serviceChefProjet.addChefProjetToManager(chef_projet2,manager1);

        ChefProjet chef_projet3 = new ChefProjet("Sofian","sofian@lnet.ma");
        serviceChefProjet.saveChefProjet(chef_projet3);
        serviceChefProjet.addChefProjetToManager(chef_projet3,manager2);



        System.out.println("\t \t ---------------------------------------- Ajouter les developpeurs------------------------ !!!");

       /*  les developpeur de premier chef de projet*/

        Develloper develloper1 = new Develloper("Anouar","anouar@lnet.ma");
        Develloper develloper2 = new Develloper("Yassine ","yassine@lnet.ma");
        serviceDevelloper.saveDevelloper(develloper1);
        serviceDevelloper.addDevelloperToChefProjet(chef_projet,develloper1);
        serviceDevelloper.saveDevelloper(develloper2);
        serviceDevelloper.addDevelloperToChefProjet(chef_projet,develloper2);




        /*  les developpeur de duxieme chef de projet*/

        Develloper develloper3 = new Develloper("Abdellah","abdellah@lnet.ma");
        Develloper develloper4 = new Develloper("Nadia ","nadia@lnet.ma");
        Develloper develloper5 = new Develloper("Soukaina","soukaina@lnet.ma");
        Develloper develloper6 = new Develloper("Abdelali ","abdeali@lnet.ma");
        serviceDevelloper.saveDevelloper(develloper3);
        serviceDevelloper.addDevelloperToChefProjet(chef_projet1,develloper3);
        serviceDevelloper.saveDevelloper(develloper4);
        serviceDevelloper.addDevelloperToChefProjet(chef_projet1,develloper4);
        serviceDevelloper.saveDevelloper(develloper5);
        serviceDevelloper.addDevelloperToChefProjet(chef_projet1,develloper5);
        serviceDevelloper.saveDevelloper(develloper6);
        serviceDevelloper.addDevelloperToChefProjet(chef_projet1,develloper6);











    }
}