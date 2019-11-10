package com.kamil.util;

import com.kamil.model.Client;
import com.kamil.model.Contract;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory factory;

    private HibernateUtil() {}

    public static synchronized SessionFactory getSessionFactory() {
        if (factory == null) {
            factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Contract.class)
                    .addAnnotatedClass(Client.class)
                    .buildSessionFactory();
        }
        return factory;
    }
}
