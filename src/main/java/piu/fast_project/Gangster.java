package piu.fast_project;

import jakarta.persistence.*;


@Entity
@Table(name = "gangster")
public class Gangster {
    @Id
    @Column(name = "number_of_gangster")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numberOfGangster;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_passport")
    public Person person;

    public Gangster() {
    }

    public Gangster(Person person) {
        this.person = person;
    }

    public int getNumberOfGangster() {
        return numberOfGangster;
    }

    public void setNumberOfGangster(int numberOfGangster) {
        this.numberOfGangster = numberOfGangster;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
