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


public class fullEmployeeProfile extends TableCell<Employee,Void> {
    private final Button button;
    public fullEmployeeProfile() {
        this.button = new Button("Профиль");
        button.setFont(Font.font("Helvetica", FontWeight.BOLD,15));
        button.setTextFill(Color.WHITE);
        button.setTextAlignment(TextAlignment.CENTER);
        button.setStyle("-fx-background-color: #182E3E; ");
        button.setAlignment(Pos.CENTER);

        button.setOnAction(event -> {
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

