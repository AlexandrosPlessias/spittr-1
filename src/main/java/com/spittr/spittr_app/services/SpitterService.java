package com.spittr.spittr_app.services;

import com.spittr.spittr_app.models.Spitter;
import com.spittr.spittr_app.repositories.SpitterJDBCRepository;
import com.spittr.spittr_app.repositories.SpitterRepository;


public class SpitterService {
    private SpitterJDBCRepository spitterJDBCRepository;
    private SpitterRepository spitterRepository;

    public SpitterService() {
        this.spitterJDBCRepository = new SpitterJDBCRepository();
        this.spitterRepository = new SpitterRepository();
    }

    public void createSpitter(String username, String password, String firstName, String lastName, String email){
        System.out.println("SpitterService.createSpitter");
        // ------ Plain JAVA -------------
        //return new Spitter(id, username, password, firstName, lastName, email);

        // ------ JDBC Repository  ---------------
        this.spitterJDBCRepository.createSpitter(username, password, firstName, lastName, email);

        // -------- Hibernate Repository ---------
//        this.spitterRepository.createSpitter(id, username, password, firstName, lastName, email);
    }

    public Spitter readSpitterByUsername(String username){
        System.out.println("SpitterService.readSpitterByUsername");
        // ------ Plain JAVA -------------
        //System.out.println(spitter.read());

        // ------ JDBC Repository  ---------------
        return this.spitterJDBCRepository.getSpitterByUsername(username);

    }
    public void updateSpitterEmailByUsername(String username, String email){
        System.out.println("SpitterService.updateSpitterEmailByUsername");
        // ------ Plain JAVA -------------
        //spitter.update(email);

        // ------ JDBC Repository  ---------------
        spitterJDBCRepository.updateSpitterEmailByUsername(username, email);
    }
    public void deleteSpitterByUsername(String username){
        System.out.println("SpitterService.deleteSpitterByUsername");

        // ------ Plain JAVA -------------
        //spitter = null;

        // ------ JDBC Repository  ---------
        spitterJDBCRepository.deleteSpitterByUsername(username);
    }
}
