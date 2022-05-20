package demoHibernate;

import demoHibernate.model.Person;
import demoHibernate.model.PersonName;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {


    public static void main(String[] args) {

        Person gautam = new Person();

        PersonName personName = new PersonName();
        personName.setfName("Gautam");
        personName.setlName("Chakraborty");
        gautam.setaPersonName(personName);
        gautam.setAid(105);

        gautam.setColor("Grexxen");

        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(personName);
        session.save(gautam);


//        System.out.println("\n\n\n");
//        Person getPerson = session.get(Person.class, 1);
//        System.out.println(getPerson);
        tx.commit();

        HibernateConfig.getSessionFactory().close();
    }
}
