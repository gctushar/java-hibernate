package demoHibernate;

import demoHibernate.model.Course;
import demoHibernate.model.Student;
import demoHibernate.model.StudentName;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {

    public static void main(String[] args) {

        Student gautam = new Student();

        StudentName studentName = new StudentName("Gautam","Chakraborty");
        Course physics = new Course("Physics",1001);
        Course cse = new Course("CSE",5001);
        Course eee = new Course("EEE",5002);

        gautam.setStudentName(studentName);
        gautam.setSex("Male");
        gautam.getCourse().add(physics);
        gautam.getCourse().add(cse);
        gautam.getCourse().add(eee);


        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(studentName);
        session.save(physics);
        session.save(cse);
        session.save(eee);
        session.save(gautam);


//        System.out.println("\n\n\n");
//        Person getPerson = session.get(Person.class, 1);
//        System.out.println(getPerson);
        tx.commit();

        HibernateConfig.getSessionFactory().close();
    }
}
