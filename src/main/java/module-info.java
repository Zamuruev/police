module piu.fast_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens piu.fast_project to javafx.fxml;
    exports piu.fast_project;
}