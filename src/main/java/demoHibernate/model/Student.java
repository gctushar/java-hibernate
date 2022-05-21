package demoHibernate.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "student")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
//@Table(name = "someting")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne
    private StudentName studentName;
    @Column(name = "sex")
    private String sex;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Course> course = new ArrayList<>();


    public int getId() {
        return id;
    }

    public void setId(int aid) {
        this.id = aid;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String color) {
        this.sex = color;
    }

    public StudentName getStudentName() {
        return studentName;
    }

    public void setStudentName(StudentName studentName) {
        this.studentName = studentName;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(ArrayList<Course> course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName=" + studentName +
                ", sex='" + sex + '\'' +
                ", course=" + course +
                '}';
    }
}
