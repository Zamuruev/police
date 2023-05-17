package piu.fast_project;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Employee {
    String name;
    String surname;
    String rank;
    String phone;
    String passport;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String serviceNumber;
    String salary;
    String mail;
    String id_contact;

   /* @OneToMany(mappedBy = "employee")
    private List<Case> cases;
*/
    public Employee() {

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

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(String serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getId_contact() {
        return id_contact;
    }

    public void setId_contact(String id_contact) {
        this.id_contact = id_contact;
    }

    public Employee(String name, String surname, String rank, String phone, String passport, String serviceNumber, String salary, String mail, String id_contact) {
        this.name = name;
        this.surname = surname;
        this.rank = rank;
        this.phone = phone;
        this.passport = passport;
        this.serviceNumber = serviceNumber;
        this.salary = salary;
        this.mail = mail;
        this.id_contact = id_contact;
    }
}
