module piu.fast_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires spring.boot.autoconfigure;

    opens piu.fast_project to javafx.fxml;
    exports piu.fast_project;
}
