package org.example;

import java.sql.*;
import java.util.List;

import entities.Word;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) throws SQLException {

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Word.class)
                .getMetadataBuilder()
                .build();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

        //part1
//        session.beginTransaction();
//        session.save(new Word("Pen"));
//        session.save(new Word("Book"));
//        session.save(new Word("Water"));
//        session.save(new Word("Fire"));
//        session.save(new Word("Native"));
//
//        session.getTransaction().commit();
//        sessionFactory.close();

//        List<Word> words = session.createQuery("select w from Word w", Word.class).getResultList();
//        System.out.println(words);
    }
}