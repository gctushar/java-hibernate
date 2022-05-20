package demoHibernate;

import demoHibernate.model.Person;
import demoHibernate.model.PersonName;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {

    private static SessionFactory sessionFactory;

    private HibernateConfig() {
        sessionFactory = new Configuration().configure()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(PersonName.class)
                .buildSessionFactory();
    }


    public static synchronized SessionFactory getSessionFactory() {

        if (null == sessionFactory || sessionFactory.isClosed()) {
            new HibernateConfig();
        }

        return sessionFactory;
    }


}
