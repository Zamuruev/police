package piu.fast_project;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class fullEmployeeProfile extends TableCell<Employee,Void> {
    private final Button button;
    public fullEmployeeProfile(Scene scene,Stage stage) {
        this.button = new Button("Профиль");
        button.setFont(Font.font("Helvetica", FontWeight.BOLD,15));
        button.setTextFill(Color.WHITE);
        button.setTextAlignment(TextAlignment.CENTER);
        button.setStyle("-fx-background-color: #182E3E; ");
        button.setAlignment(Pos.CENTER);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(scene);
            }
        });

        button.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                button.setStyle("-fx-background-color: #085b96");
            }
        });

        button.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                button.setStyle("-fx-background-color: #182E3E");
            }
        });


    }

    @Override
    protected void updateItem(Void item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setGraphic(null);
        } else {
            setGraphic(button);
        }
    }
}

