package piu.fast_project;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class fullEmployeeProfile extends TableCell<Employee,Void> {
    private final Button button;
    public fullEmployeeProfile(Stage stage, Scene employeesScene) {
        this.button = new Button("Профиль");
        button.setFont(Font.font("Helvetica", FontWeight.BOLD,15));
        button.setTextFill(Color.WHITE);
        button.setTextAlignment(TextAlignment.CENTER);
        button.setStyle("-fx-background-color: #182E3E; ");
        button.setAlignment(Pos.CENTER);

        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {
                Employee employee = getTableRow().getItem();
                GridPane profileGrid = new GridPane();
                profileGrid.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #182E3E; -fx-border-width: 8px; -fx-grid-lines-color: #182E3E;");
                //profileGrid.setHgap(10);
                profileGrid.setGridLinesVisible(true);
                //profileGrid.setVgap(10);
                profileGrid.setAlignment(Pos.CENTER);
                String url1 ="file:C:/Users/zamur/Desktop/police/src/main/resources/img/policeman.png";
                String id_passport1;
                ImageView photoUser = new ImageView(url1);
                try {
                        Connection connection = MySQLConnection.getInstance().getConnection();
                        String query1 = "SELECT *FROM imageprofile WHERE id_passport = ?";
                        PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
                        preparedStatement1.setString(1, employee.passport);
                        ResultSet resultSet1 = preparedStatement1.executeQuery();
                        if(resultSet1.next())
                        {url1 = resultSet1.getString(3);
                            photoUser.setImage(new Image(url1));
                            resultSet1.close();
                            preparedStatement1.close();}
                        else {
                            url1 = "file:C:/Users/zamur/Desktop/police/src/main/resources/img/policeman.png";
                        }


                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                photoUser.setFitHeight(268);
                photoUser.setFitWidth(220);
                photoUser.setPreserveRatio(true);
                photoUser.setStyle("-fx-alignment: center;");

                GridPane photoGrid = new GridPane();
                photoGrid.add(photoUser,0,0);
                photoGrid.setStyle("-fx-border-color: #182E3E; -fx-border-width: 9px; -fx-font-weight: bold; -fx-alignment: center");
                photoGrid.setMaxSize(220,268);
                photoGrid.setPrefSize(220,268);
                photoGrid.setMinSize(220,268);

                Button editPhotoUserButton = new Button("Изменить фото");
                editPhotoUserButton.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                editPhotoUserButton.setTextFill(Color.WHITE);
                editPhotoUserButton.setTextAlignment(TextAlignment.CENTER);
                editPhotoUserButton.setStyle("-fx-background-color: #182E3E; ");
                editPhotoUserButton.setPrefSize(225, 50);

                Button editDataUserButton = new Button("Редактировать данные");
                editDataUserButton.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                editDataUserButton.setTextFill(Color.WHITE);
                editDataUserButton.setTextAlignment(TextAlignment.CENTER);
                editDataUserButton.setStyle("-fx-background-color: #182E3E; ");
                editDataUserButton.setPrefSize(325, 50);
                String finalUrl = url1;
                editPhotoUserButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        FileChooser fileChooser = new FileChooser();
                        fileChooser.setTitle("Выберите фото");
                        File selectedFile = fileChooser.showOpenDialog(stage);
                        if (selectedFile != null) {
                            Image image = new Image(selectedFile.toURI().toString());
                            String newUrlImage = selectedFile.toURI().toString();
                            String queryOld = "SELECT *FROM imageprofile WHERE id_passport = ?";
                            String query  = "UPDATE imageProfile SET url = ? WHERE url = ? AND id_passport = ?";
                            String queryInsert = "INSERT INTO imageprofile(url,id_passport) VALUES (?,?)";

                            Connection connection = MySQLConnection.getInstance().getConnection();
                            try {
                                PreparedStatement preparedStatement1 = connection.prepareStatement(queryOld);
                                preparedStatement1.setString(1,employee.passport);
                                ResultSet resultSet = preparedStatement1.executeQuery();
                                if(resultSet.next()) {
                                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                                    preparedStatement.setString(1,newUrlImage);
                                    preparedStatement.setString(2, finalUrl);
                                    preparedStatement.setString(3, employee.passport);
                                    preparedStatement.executeUpdate();
                                    preparedStatement.close();
                                }
                                else {
                                    PreparedStatement preparedStatement = connection.prepareStatement(queryInsert);
                                    preparedStatement.setString(1,newUrlImage);
                                    preparedStatement.setString(2,employee.passport);
                                    preparedStatement.executeUpdate();
                                    preparedStatement.close();
                                }
                                preparedStatement1.close();
                                resultSet.close();

                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }
                            photoUser.setImage(image);
                        }
                    }
                });

                editPhotoUserButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        editPhotoUserButton.setStyle("-fx-background-color: #085b96");
                    }
                });

                editPhotoUserButton.setOnMouseExited(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        editPhotoUserButton.setStyle("-fx-background-color: #182E3E");
                    }
                });

                editDataUserButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        editDataUserButton.setStyle("-fx-background-color: #085b96");
                    }
                });

                editDataUserButton.setOnMouseExited(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        editDataUserButton.setStyle("-fx-background-color: #182E3E");
                    }
                });

                VBox fullPhoto = new VBox();
                fullPhoto.setSpacing(10);
                fullPhoto.setAlignment(Pos.CENTER);
                fullPhoto.getChildren().addAll(photoGrid,editPhotoUserButton);

                VBox fullData = new VBox();
                fullData.setSpacing(10);
                fullData.setAlignment(Pos.CENTER);
                fullData.getChildren().addAll(profileGrid,editDataUserButton);

                HBox userData = new HBox();
                userData.setSpacing(10);
                userData.setAlignment(Pos.CENTER);
                userData.getChildren().addAll(fullPhoto, fullData);

                Button backButton = new Button("Вернуться");
                backButton.setFont(Font.font("Helvetica", FontWeight.BOLD,30));
                backButton.setTextFill(Color.WHITE);
                backButton.setTextAlignment(TextAlignment.CENTER);
                backButton.setStyle("-fx-background-color: #182E3E;");
                backButton.setPrefSize(500, 50);

                backButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        stage.setScene(employeesScene);
                    }
                });

                backButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        backButton.setStyle("-fx-background-color: #085b96");
                    }
                });

                backButton.setOnMouseExited(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        backButton.setStyle("-fx-background-color: #182E3E");
                    }
                });

                VBox userData1 = new VBox();
                userData1.setSpacing(10);
                userData1.setAlignment(Pos.CENTER);
                userData1.getChildren().addAll(backButton,userData);

                BorderPane profilePane = new BorderPane();
                profilePane.setCenter(userData1);
                profilePane.setStyle("-fx-background-color: linear-gradient(to bottom, #182E3E, white);");

                ImageView gerbImage = new ImageView("file:C:/Users/zamur/Desktop/police/src/main/resources/img/gerb.png");
                ImageView gerbImage1 = new ImageView("file:C:/Users/zamur/Desktop/police/src/main/resources/img/gerb.png");
                profilePane.setRight(gerbImage);
                profilePane.setLeft(gerbImage1);

                Label fullNameLabel = new Label("Фамилия, имя");
                fullNameLabel.setStyle("-fx-text-fill: #182E3E;");
                fullNameLabel.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
        /*profileGrid.setHalignment(fullNameLabel, HPos.CENTER);
        profileGrid.setValignment(fullNameLabel, VPos.CENTER);*/

                Label passportLabel = new Label("Паспорт");
                passportLabel.setStyle("-fx-text-fill: #182E3E;");
                passportLabel.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
        /*profileGrid.setHalignment(passportLabel, HPos.CENTER);
        profileGrid.setValignment(passportLabel, VPos.CENTER);*/

                Label phoneLabel = new Label("Телефон");
                phoneLabel.setStyle("-fx-text-fill: #182E3E;");
                phoneLabel.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
        /*profileGrid.setHalignment(phoneLabel, HPos.CENTER);
        profileGrid.setValignment(phoneLabel, VPos.CENTER);*/

                Label mailLabel = new Label("Почта");
                mailLabel.setStyle("-fx-text-fill: #182E3E;");
                mailLabel.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
        /*profileGrid.setHalignment(mailLabel, HPos.CENTER);
        profileGrid.setValignment(mailLabel, VPos.CENTER);*/

                Label rankLabel = new Label("Звание");
                rankLabel.setStyle("-fx-text-fill: #182E3E;");
                rankLabel.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
        /*profileGrid.setHalignment(rankLabel, HPos.CENTER);
        profileGrid.setValignment(rankLabel, VPos.CENTER);*/

                Label salaryLabel = new Label("Оклад");
                salaryLabel.setStyle("-fx-text-fill: #182E3E;");
                salaryLabel.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
        /*profileGrid.setHalignment(salaryLabel, HPos.CENTER);
        profileGrid.setValignment(salaryLabel, VPos.CENTER);*/

                Label serviceNumberLabel = new Label("Личный номер");
                serviceNumberLabel.setStyle("-fx-text-fill: #182E3E;");
                serviceNumberLabel.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
        /*profileGrid.setHalignment(serviceNumberLabel, HPos.CENTER);
        profileGrid.setValignment(serviceNumberLabel, VPos.CENTER);*/

                Text serviceNumberText = new Text();
                serviceNumberText.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                serviceNumberText.setFill(Color.rgb(24,46,62));
                profileGrid.setHalignment(serviceNumberText, HPos.CENTER);
                profileGrid.setValignment(serviceNumberText, VPos.CENTER);

                Text fullNameText = new Text();
                fullNameText.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                fullNameText.setFill(Color.rgb(24,46,62));
                profileGrid.setHalignment(fullNameText, HPos.CENTER);
                profileGrid.setValignment(fullNameText, VPos.CENTER);

                Text passportText = new Text();
                passportText.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                passportText.setFill(Color.rgb(24,46,62));
                profileGrid.setHalignment(passportText, HPos.CENTER);
                profileGrid.setValignment(passportText, VPos.CENTER);

                Text phoneText = new Text();
                phoneText.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                phoneText.setFill(Color.rgb(24,46,62));
                profileGrid.setHalignment(phoneText, HPos.CENTER);
                profileGrid.setValignment(phoneText, VPos.CENTER);

                Text rankText = new Text();
                rankText.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                rankText.setFill(Color.rgb(24,46,62));
                profileGrid.setHalignment(rankText, HPos.CENTER);
                profileGrid.setValignment(rankText, VPos.CENTER);

                Text salaryText = new Text();
                salaryText.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                salaryText.setFill(Color.rgb(24,46,62));
                profileGrid.setHalignment(salaryText, HPos.CENTER);
                profileGrid.setValignment(salaryText, VPos.CENTER);

                Text mailText = new Text();
                mailText.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                mailText.setFill(Color.rgb(24,46,62));
                profileGrid.setHalignment(mailText, HPos.CENTER);
                profileGrid.setValignment(mailText, VPos.CENTER);

                String query = "SELECT *FROM person, employee, contact WHERE person.id_passport = employee.id_passport AND person.id_passport = ? AND employee.id_contact = contact.id_contact";
                Connection connection = MySQLConnection.getInstance().getConnection();
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1,employee.passport);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next())
                    {serviceNumberText.setText(resultSet.getString("service_number"));
                        fullNameText.setText(resultSet.getString("surname") + " " + resultSet.getString("name"));
                        passportText.setText(employee.passport);
                        rankText.setText(resultSet.getString("ranks"));
                        salaryText.setText(resultSet.getString("salary"));
                        phoneText.setText(resultSet.getString("phone"));
                        mailText.setText(resultSet.getString("mail"));
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                profileGrid.add(serviceNumberLabel,0,0);
                profileGrid.add(fullNameLabel,0,1);
                profileGrid.add(passportLabel,0,2);
                profileGrid.add(phoneLabel,0,3);
                profileGrid.add(rankLabel,0,4);
                profileGrid.add(salaryLabel,0,5);
                profileGrid.add(mailLabel,0,6);

                Button saveDataUserButton = new Button("Сохранить");
                saveDataUserButton.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                saveDataUserButton.setTextFill(Color.WHITE);
                saveDataUserButton.setTextAlignment(TextAlignment.CENTER);
                saveDataUserButton.setStyle("-fx-background-color: #182E3E; ");
                saveDataUserButton.setPrefSize(325, 50);

                String fullName = fullNameText.getText();
                TextField fullNameField = new TextField(fullName);
                fullNameField.setAlignment(Pos.CENTER);

                String passport = passportText.getText();
                TextField passportField = new TextField(passport);
                passportField.setAlignment(Pos.CENTER);

                String phone = phoneText.getText();
                TextField phoneField = new TextField(phone);
                phoneField.setAlignment(Pos.CENTER);

                String mail = mailText.getText();
                TextField mailField = new TextField(mail);
                mailField.setAlignment(Pos.CENTER);

                String serviceNumberE = serviceNumberText.getText();
                TextField serviceNumberField = new TextField(serviceNumberE);
                serviceNumberField.setAlignment(Pos.CENTER);
                String rank1 = rankText.getText();
                TextField rankField1 = new TextField(rank1);
                rankField1.setAlignment(Pos.CENTER);

                String salary = salaryText.getText();
                TextField salaryField = new TextField(salary);
                salaryField.setAlignment(Pos.CENTER);

                editDataUserButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {

                        profileGrid.getChildren().remove(fullNameText);
                        fullNameField.setFont(Font.font("Helvetica", FontWeight.BOLD,20));
                        fullNameField.setStyle("-fx-text-fill: red");
                        fullNameField.setMinSize(50,5);

                        profileGrid.getChildren().remove(serviceNumberText);
                        serviceNumberField.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                        serviceNumberField.setStyle("-fx-text-fill: red");
                        serviceNumberField.setMinSize(50,5);

                        profileGrid.getChildren().remove(passportText);
                        passportField.setFont(Font.font("Helvetica", FontWeight.BOLD,20));
                        passportField.setStyle("-fx-text-fill: red");
                        passportField.setMinSize(50,5);

                        profileGrid.getChildren().remove(phoneText);
                        phoneField.setFont(Font.font("Helvetica", FontWeight.BOLD,20));
                        phoneField.setStyle("-fx-text-fill: red");
                        phoneField.setMinSize(50,5);

                        profileGrid.getChildren().remove(rankText);
                        rankField1.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                        rankField1.setStyle("-fx-text-fill: red");
                        rankField1.setMinSize(50,5);

                        profileGrid.getChildren().remove(salaryText);
                        salaryField.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                        salaryField.setStyle("-fx-text-fill: red");
                        salaryField.setMinSize(50,5);

                        profileGrid.getChildren().remove(mailText);
                        mailField.setFont(Font.font("Helvetica", FontWeight.BOLD,20));
                        mailField.setStyle("-fx-text-fill: red");
                        mailField.setMinSize(50,5);


                        //profileGrid.setMaxSize(500,20);
                        profileGrid.add(serviceNumberField,1,0);
                        profileGrid.add(fullNameField,1,1);
                        profileGrid.add(passportField,1,2);
                        profileGrid.add(phoneField,1,3);
                        profileGrid.add(rankField1,1,4);
                        profileGrid.add(salaryField,1,5);
                        profileGrid.add(mailField,1,6);

                        fullData.getChildren().remove(editDataUserButton);
                        fullData.getChildren().add(saveDataUserButton);


                    }
                });

                saveDataUserButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        fullNameText.setText(fullNameField.getText());
                        profileGrid.getChildren().remove(fullNameField);

                        passportText.setText(passportField.getText());
                        profileGrid.getChildren().remove(passportField);

                        phoneText.setText(phoneField.getText());
                        profileGrid.getChildren().remove(phoneField);

                        mailText.setText(mailField.getText());
                        profileGrid.getChildren().remove(mailField);

                        rankText.setText(rankField1.getText());
                        profileGrid.getChildren().remove(rankField1);

                        salaryText.setText(salaryField.getText());
                        profileGrid.getChildren().remove(salaryField);

                        serviceNumberText.setText(serviceNumberField.getText());
                        profileGrid.getChildren().remove(serviceNumberField);

                        profileGrid.add(serviceNumberText,1,0);
                        profileGrid.add(fullNameText,1,1);
                        profileGrid.add(passportText,1,2);
                        profileGrid.add(phoneText,1,3);
                        profileGrid.add(rankText,1,4);
                        profileGrid.add(salaryText,1,5);
                        profileGrid.add(mailText,1,6);
                        fullData.getChildren().remove(saveDataUserButton);
                        fullData.getChildren().add(editDataUserButton);
                        //profileGrid.setMaxSize(600,20);
                    }
                });

                saveDataUserButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        saveDataUserButton.setStyle("-fx-background-color: #085b96");
                    }
                });

                saveDataUserButton.setOnMouseExited(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        saveDataUserButton.setStyle("-fx-background-color: #182E3E");
                    }
                });

                profileGrid.add(serviceNumberText,1,0);
                profileGrid.add(fullNameText,1,1);
                profileGrid.add(passportText,1,2);
                profileGrid.add(phoneText,1,3);
                profileGrid.add(rankText,1,4);
                profileGrid.add(salaryText,1,5);
                profileGrid.add(mailText,1,6);


                Scene profile = new Scene(profilePane,1545,840);
                stage.setScene(profile);
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

