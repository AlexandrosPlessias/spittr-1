package com.spittr.spittr_app.services;

import com.spittr.spittr_app.models.Spittle;
import com.spittr.spittr_app.repositories.SpittleJDBCRepository;

public class SpittleService {
    private SpittleJDBCRepository spittleJDBCRepository;

    public SpittleService() {
        System.out.println("SpittleService.constructor");
        this.spittleJDBCRepository = new SpittleJDBCRepository();
    }

    public void createSpittle(String message, String time, Double longitude, Double latitude){
        System.out.println("SpittleService.createSpittle");
        // ------ Plain JAVA -------------
        //return new Spittle(id, message, time, longitude, latitude);

        // ------ JDBC Repository  ---------------
        this.spittleJDBCRepository.createSpittle(message, time, longitude, latitude);
    }
    public Spittle readSpittleById(Long id){
        System.out.println("SpittleService.readSpittleById");

        // ------ Plain JAVA -------------
        //System.out.println(spittle.read());

        // ------ JDBC Repository  ---------------
        return this.spittleJDBCRepository.getSpittleById(id);

    }
    public void updateSpittleMessage(Long id, String message){
        System.out.println("SpittleService.updateSpittleMessage");

        // ------ Plain JAVA -------------
        //spittle.update(message);

        // ------ JDBC Repository  ---------------
        spittleJDBCRepository.updateSpittleMessageById(id, message);
    }

    public void deleteSpittle(Long id){
        System.out.println("SpittleService.deleteSpittle");

        // ------ Plain JAVA -------------
        //spittle = null;

        // ------ JDBC Repository  ---------------
        spittleJDBCRepository.deleteSpittleById(id);
    }
}
