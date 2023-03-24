package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import part1.Car;
import part1.DriverLicense;
import part1.Owner;
import part1.Type;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
                .build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Owner.class)
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(DriverLicense.class)
                .getMetadataBuilder()
                .build();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        List<Car> cars = new ArrayList<Car>();
        cars.add(new Car("Mazda", Type.AUTO,200,25000,2015));
        cars.add(new Car("Toyotya", Type.MECHANICAL,250,23000,2010));
        cars.add(new Car("Mustang", Type.MECHANICAL,300,30000,2009));

        Owner owner = new Owner("Sergiy",cars,new DriverLicense("228339"));
        session.save(owner);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}