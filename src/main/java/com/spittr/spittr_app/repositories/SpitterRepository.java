package com.spittr.spittr_app.repositories;

import com.spittr.spittr_app.models.Spitter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SpitterRepository {
    private SessionFactory sessionFactory;

    public SpitterRepository() {
        /*print SpitterRepository.constrctor */
        Configuration config=new Configuration();
        config.configure();
        sessionFactory = config.buildSessionFactory();

    }

    public void createSpitter(Long id, String username, String password, String firstName, String lastName, String email){
        /*print SpitterRepository.createSpitter */
        Session session = sessionFactory.openSession();
        Transaction t=session.beginTransaction();

        Spitter spitter = new Spitter(id, username, password, firstName, lastName, email);
        session.save(spitter);
        t.commit();

    }
}
