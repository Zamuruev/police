package piu.fast_project;

import java.sql.Date;

public class CombinedData {
    private long idPassport;

    private String surname;

    private String name;

    private Date birthday;

    private int numberOfGangster;

    public CombinedData(long idPassport, String surname, String name, Date birthday, int numberOfGangster) {
        this.idPassport = idPassport;
        this.surname = surname;
        this.name = name;
        this.birthday = birthday;
        this.numberOfGangster = numberOfGangster;
    }

    public CombinedData() {
        this.idPassport = 0;
        this.surname = "surname";
        this.name = "name";
        this.birthday = java.sql.Date.valueOf("2001-01-01");
        this.numberOfGangster = 0;
    }

    public long getIdPassport() {
        return idPassport;
    }

    public void setIdPassport(long idPassport) {
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

    public int getNumberOfGangster() {
        return numberOfGangster;
    }

    public void setNumberOfGangster(int numberOfGangster) {
        this.numberOfGangster = numberOfGangster;
    }
}
