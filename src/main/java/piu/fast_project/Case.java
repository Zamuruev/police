package piu.fast_project;

import javax.persistence.*;

@Entity
@Table (name = "case")
public class Case {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number_of_case")
    private Long number_of_case;

    @ManyToOne
    @JoinColumn(name = "number_of_gangster")
    private Gangster gangster;

    @Column(name = "status_of_case")
    private String status_of_case;

    @Column(name = "name_of_case")
    private String name_of_case;

    @Column(name = "date_of_crime")
    private String date_of_crime;

    public Case() {

    }

    public Long getNumber_of_case() {
        return number_of_case;
    }

    public void setNumber_of_case(Long number_of_case) {
        this.number_of_case = number_of_case;
    }


    public Gangster getGangster() {
        return gangster;
    }

    public void setGangster(Gangster gangster) {
        this.gangster = gangster;
    }

    public String getStatus_of_case() {
        return status_of_case;
    }

    public void setStatus_of_case(String status_of_case) {
        this.status_of_case = status_of_case;
    }

    public String getName_of_case() {
        return name_of_case;
    }

    public void setName_of_case(String name_of_case) {
        this.name_of_case = name_of_case;
    }

    public String getDate_of_crime() {
        return date_of_crime;
    }

    public void setDate_of_crime(String date_of_crime) {
        this.date_of_crime = date_of_crime;
    }

    public Case(Gangster gangster, String status_of_case, String name_of_case, String date_of_crime) {
        this.gangster = gangster;
        this.status_of_case = status_of_case;
        this.name_of_case = name_of_case;
        this.date_of_crime = date_of_crime;
    }
}
