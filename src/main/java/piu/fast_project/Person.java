package piu.fast_project;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @Column(name = "id_passport")
    private Long id_passport;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "birthday")
    private String birthday;

   /* @OneToOne(mappedBy = "person")
    private Gangster gangster;*/

    public Person(Long id_passport, String name, String surname, String birthday) {
        this.id_passport = id_passport;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }

    public Person() {

    }

    public Long getId_passport() {
        return id_passport;
    }

    public void setId_passport(Long id_passport) {
        this.id_passport = id_passport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

//    public Gangster getGangster() {
//        return gangster;
//    }
//
//    public void setGangster(Gangster gangster) {
//        this.gangster = gangster;
//    }

}
