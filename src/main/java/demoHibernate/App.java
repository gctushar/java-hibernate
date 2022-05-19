package demoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.spi.SessionFactoryServiceRegistryBuilder;

public class App {


    public static void main(String[] args) {
        Person gautam = new Person();

        gautam.setAid(105);
        gautam.setAname("Gautam");
        gautam.setColor("Grexxen");

        Configuration configuration = new Configuration().configure().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();
        session.save(gautam);


        Person getPerson = session.get(Person.class,5);
        System.out.println(getPerson);
        tx.commit();



        sessionFactory.close();
    }
}
