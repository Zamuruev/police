module piu.fast_project {
    requires javafx.controls;
    requires java.sql;
    requires java.naming;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;


    opens piu.fast_project to org.hibernate.orm.core;
    exports piu.fast_project;
}
