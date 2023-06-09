package piu.fast_project;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "person")
public class Person {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_passport")
    private long idPassport;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "birthday")
    private Date birthday;

    public Person() {
    }

    public Person(long idPassport, String surname, String name) {
        this.idPassport = idPassport;
        this.surname = surname;
        this.name = name;
        this.birthday = java.sql.Date.valueOf("2001-01-01");
    }

    public long getIdPassport() {
        return idPassport;
    }

    public void setIdPassport(int idPassport) {
        this.idPassport = idPassport;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
