package demoHibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity(name = "person")
//@Table(name = "someting")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int aid;
//    @OneToOne
    @Transient
    private PersonName aPersonName;
    @Column(name = "fcolor")
    private String color;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public PersonName getaPersonName() {
        return aPersonName;
    }

    public void setaPersonName(PersonName aPersonName) {
        this.aPersonName = aPersonName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }




    @Override
    public String toString() {
        return "Person{" +
                "aid=" + aid +
                ", aname='" + aPersonName + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
