package demoHibernate;

import demoHibernate.model.Course;
import demoHibernate.model.Student;
import demoHibernate.model.StudentName;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


public class App {


    public static void main(String[] args) {


        StudentName studentGC = new StudentName("Gautam","Chakraborty");
        StudentName studentJC = new StudentName("Jackie","Chan");

        Course physics = new Course("Physics",1001);
        Course cse = new Course("CSE",5001);
        Course eee = new Course("EEE",5002);
        Course algo = new Course("Algo",5003);

        Student gautam = new Student();
        Student jakie = new Student();

        gautam.setStudentName(studentGC);
        gautam.setSex("Male");
        gautam.getCourse().add(physics);
        gautam.getCourse().add(cse);

        jakie.setStudentName(studentJC);
        jakie.setSex("n/a");
        jakie.getCourse().add(eee);
        jakie.getCourse().add(algo);


        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

//        session.save(studentGC);
//        session.save(studentJC);
//        session.save(physics);
//        session.save(cse);
//        session.save(eee);
//        session.save(algo);
//        session.save(gautam);
//        session.save(jakie);


        Student getPerson = session.get(Student.class, 7);
        System.out.println(getPerson.getStudentName() + " " + getPerson.getSex());
//
        getPerson.setSex("nooooo");
        session.update(getPerson);

        getPerson = session.get(Student.class, 8);
        System.out.println(getPerson.getStudentName() + " " + getPerson.getSex());

        getPerson = session.get(Student.class, 7);
        System.out.println(getPerson.getStudentName() + " " + getPerson.getSex());

        System.out.println("\n");

        System.out.println(getPerson.getCourse().size());

        tx.commit();
        session.close();


        Session session2 = HibernateConfig.getSessionFactory().openSession();
        Transaction tx2 =  session2.beginTransaction();

        getPerson = session2.get(Student.class, 7);
        System.out.println(getPerson.getStudentName() + " " + getPerson.getSex());


        Query query = session2.createQuery("from student where id = 7");
        query.setCacheable(true);
        getPerson =(Student) query.uniqueResult();
        System.out.println(getPerson.getStudentName() + " " + getPerson.getSex());

        Query query2 = session2.createQuery("from student where id = 7");
        query2.setCacheable(true);
        getPerson =(Student) query2.uniqueResult();
        System.out.println(getPerson.getStudentName() + " " + getPerson.getSex());






        tx2.commit();
        session2.close();

        HibernateConfig.getSessionFactory().close();
    }
}
