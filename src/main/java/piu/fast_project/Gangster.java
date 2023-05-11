package piu.fast_project;

import javax.persistence.*;

@Entity
@Table(name = "gangster")
public class Gangster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number_of_gangster")
    private Long number_of_gangster;

    @OneToOne
    @JoinColumn(name = "id_passport")
    private Person person;

    public Gangster(Long number_of_gangster, Person person) {
        this.number_of_gangster = number_of_gangster;
        this.person = person;
    }

    public Gangster() {

    }

    public Long getNumber_of_gangster() {
        return number_of_gangster;
    }

    public void setNumber_of_gangster(Long number_of_gangster) {
        this.number_of_gangster = number_of_gangster;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    /*public List<Case> getCases() {
        return cases;
    }

    public void setCases(List<Case> cases) {
        this.cases = cases;
    }*/
}
