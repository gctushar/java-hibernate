package demoHibernate;

import demoHibernate.model.Course;
import demoHibernate.model.Student;
import demoHibernate.model.StudentName;
import demoHibernate.model.TempCourse;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {

    private static SessionFactory sessionFactory;

    private HibernateConfig() {
        sessionFactory = new Configuration().configure()
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(StudentName.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(TempCourse.class)
                .buildSessionFactory();
    }


    public static synchronized SessionFactory getSessionFactory() {

        if (null == sessionFactory || sessionFactory.isClosed()) {
            new HibernateConfig();
        }

        return sessionFactory;
    }


}
