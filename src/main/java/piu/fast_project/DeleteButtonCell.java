package piu.fast_project;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteButtonCell extends TableCell<Employee, Void> {
    private final Button deleteButton;

    public DeleteButtonCell() {
        deleteButton = new Button("Удалить");
        deleteButton.setFont(Font.font("Helvetica", FontWeight.BOLD,15));
        deleteButton.setTextFill(Color.WHITE);
        deleteButton.setTextAlignment(TextAlignment.CENTER);
        deleteButton.setStyle("-fx-background-color: #182E3E; ");
        deleteButton.setAlignment(Pos.CENTER);

        deleteButton.setOnAction(event -> {
            Employee employee = getTableRow().getItem();
            getTableView().getItems().remove(employee);
            String queryEmployee = "DELETE FROM employee WHERE id_passport = ?";
            String queryPerson = "DELETE FROM person WHERE id_passport = ?";
            String queryAuthorization = "DELETE FROM authorization WHERE id_passport = ?";
            String queryImageProfile = "DELETE FROM imageprofile WHERE id_passport = ?";
            Connection connection = MySQLConnection.getInstance().getConnection();
            try {
                PreparedStatement pstE = connection.prepareStatement(queryEmployee);
                pstE.setString(1, employee.passport);
                pstE.executeUpdate();

                PreparedStatement pstA = connection.prepareStatement(queryAuthorization);
                pstA.setString(1,employee.passport);
                pstA.executeUpdate();

                PreparedStatement pstI = connection.prepareStatement(queryImageProfile);
                pstI.setString(1,employee.passport);
                pstI.executeUpdate();

                PreparedStatement pstP = connection.prepareStatement(queryPerson);
                pstP.setString(1,employee.passport);
                pstP.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        deleteButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                deleteButton.setStyle("-fx-background-color: #085b96");
            }
        });

        deleteButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                deleteButton.setStyle("-fx-background-color: #182E3E");
            }
        });

    }
    @Override
    protected void updateItem(Void item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty) {
            setGraphic(deleteButton);
        } else {
            setGraphic(null);
        }
    }
}
