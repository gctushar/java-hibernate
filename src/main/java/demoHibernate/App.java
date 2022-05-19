package demoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {


    public static void main(String[] args) {
        Person gautam = new Person();

        gautam.setAid(101);
        gautam.setAname("Gautam");
        gautam.setColor("Green");

        Configuration configuration = new Configuration().configure().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();
        session.save(gautam);
        tx.commit();
    }
}
