package piu.fast_project;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyApp extends Application {
    int width = 1545;
    int height = 840;
    @Override
    public void start(Stage stage) throws IOException {

        // region // создание окна

        // endregion

        // установка иконки
        stage.getIcons().add(new Image("file:C:/Users/zamur/Desktop/fast_project/src/main/resources/img/logo.png"));

        // установка заголовка окна
        stage.setTitle("Полиция");

        Label loginLabel = new Label("Логин");
        loginLabel.setStyle("-fx-text-fill: #182E3E;");
        loginLabel.setFont(Font.font("Helvetica", FontWeight.BOLD,30));

        Label passwordLabel = new Label("Паспорт");
        passwordLabel.setStyle("-fx-text-fill: #182E3E;");
        passwordLabel.setFont(Font.font("Helvetica", FontWeight.BOLD,30));

        TextField loginField = new TextField();
        loginField.setPromptText("Логин");
        loginField.setStyle("-fx-text-fill: #182E3E;");
        loginField.setFont(Font.font("Helvetica", FontWeight.BOLD,30));

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Пароль");
        passwordField.setStyle("-fx-text-fill: #182E3E;");
        passwordField.setFont(Font.font("Helvetica", FontWeight.BOLD,30));

        GridPane loginPane = new GridPane();
        loginPane.add(loginLabel, 0, 0);
        loginPane.add(passwordLabel, 0, 1);
        loginPane.add(loginField,1,0);
        loginPane.add(passwordField,1,1);
        loginPane.setAlignment(Pos.CENTER);
        loginPane.setHgap(10);
        loginPane.setVgap(10);

        Text welcomeText = new Text("Добро пожаловать в полицию!");
        welcomeText.setFill(Color.WHITE);
        welcomeText.setFont(Font.font("Helvetica", FontWeight.BOLD,50));
        welcomeText.setTextAlignment(TextAlignment.CENTER);

        Button welcomeButton = new Button("Войти");
        welcomeButton.setFont(Font.font("Helvetica", FontWeight.BOLD,30));
        welcomeButton.setTextFill(Color.WHITE);
        welcomeButton.setTextAlignment(TextAlignment.CENTER);
        welcomeButton.setStyle("-fx-background-color: #182E3E;");
        welcomeButton.setPrefSize(500, 50);

        welcomeButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                welcomeButton.setStyle("-fx-background-color: #085b96");
            }
        });

        welcomeButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                welcomeButton.setStyle("-fx-background-color: #182E3E");
            }
        });

        loginPane.add(welcomeButton,1,2);

        VBox welcomePane = new VBox();
        welcomePane.getChildren().addAll(welcomeText,loginPane);
        welcomePane.setAlignment(Pos.CENTER);
        welcomePane.setStyle("-fx-background-color: linear-gradient(to bottom, #182E3E, white)");
        welcomePane.setSpacing(10);

        Scene welcomeScene = new Scene(welcomePane, width,height);
        welcomeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(loginField.getText().equals("admin") && passwordField.getText().equals("admin"))
                {
                    String login1 = loginField.getText();
                    loginField.clear();
                    String password1 = passwordField.getText();
                    passwordField.clear();
                    // кнопка "Список сотрудников"
                    Button employeesButton = new Button("Сотрудники");
                    employeesButton.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                    employeesButton.setTextFill(Color.WHITE);
                    employeesButton.setTextAlignment(TextAlignment.CENTER);
                    employeesButton.setStyle("-fx-background-color: #182E3E;");
                    employeesButton.setPrefSize(300, 50);
                    employeesButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            employeesButton.setStyle("-fx-background-color: #085b96");
                        }
                    });

                    employeesButton.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            employeesButton.setStyle("-fx-background-color: #182E3E");
                        }
                    });

                    // кнопка "Список преступников"
                    Button gangsterButton = new Button("Преступники");
                    gangsterButton.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                    gangsterButton.setTextFill(Color.WHITE);
                    gangsterButton.setTextAlignment(TextAlignment.CENTER);
                    gangsterButton.setStyle("-fx-background-color: #182E3E; ");
                    gangsterButton.setPrefSize(300, 50);
                    gangsterButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            gangsterButton.setStyle("-fx-background-color: #085b96");
                        }
                    });

                    gangsterButton.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            gangsterButton.setStyle("-fx-background-color: #182E3E");
                        }
                    });

                    // кнопка "Профиль"
                    Button profileButton = new Button("Профиль");
                    profileButton.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                    profileButton.setTextFill(Color.WHITE);
                    profileButton.setTextAlignment(TextAlignment.CENTER);
                    profileButton.setStyle("-fx-background-color: #182E3E; ");
                    profileButton.setPrefSize(300, 50);

                    profileButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            profileButton.setStyle("-fx-background-color: #085b96");
                        }
                    });

                    profileButton.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            profileButton.setStyle("-fx-background-color: #182E3E");
                        }
                    });

                    // кнопка "Выход"
                    Button exitButton = new Button("Выход");
                    exitButton.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                    exitButton.setTextFill(Color.WHITE);
                    exitButton.setTextAlignment(TextAlignment.CENTER);
                    exitButton.setStyle("-fx-background-color: #182E3E; ");
                    exitButton.setPrefSize(300, 50);
                    exitButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            exitButton.setStyle("-fx-background-color: #085b96");
                        }
                    });

                    exitButton.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            exitButton.setStyle("-fx-background-color: #182E3E");
                        }
                    });

                    exitButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            stage.setScene(welcomeScene);
                        }
                    });

                    Button casesButton = new Button("Дела");
                    casesButton.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                    casesButton.setTextFill(Color.WHITE);
                    casesButton.setTextAlignment(TextAlignment.CENTER);
                    casesButton.setStyle("-fx-background-color: #182E3E; ");
                    casesButton.setPrefSize(300, 50);

                    casesButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            casesButton.setStyle("-fx-background-color: #085b96");
                        }
                    });

                    casesButton.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            casesButton.setStyle("-fx-background-color: #182E3E");
                        }
                    });

                    HBox menu = new HBox();
                    menu.setAlignment(Pos.TOP_CENTER);
                    menu.getChildren().addAll(employeesButton,gangsterButton, casesButton, profileButton, exitButton);
                    menu.setSpacing(10);
                    menu.setStyle("-fx-background-color: #7d7f7d");
                    menu.setPadding(new Insets(10));

                    GridPane profileGrid = new GridPane();
                    profileGrid.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #182E3E; -fx-border-width: 8px; -fx-grid-lines-color: #182E3E;");
                    //profileGrid.setHgap(10);
                    profileGrid.setGridLinesVisible(true);
                    //profileGrid.setVgap(10);
                    profileGrid.setAlignment(Pos.CENTER);
                    String url1 ="file:C:/Users/zamur/Desktop/fast_project/src/main/resources/img/policeman.png";
                    String id_passport1;
                    ImageView photoUser = new ImageView(url1);
                    try {
                        String query = "SELECT id_passport FROM authorization WHERE login = ? AND password = ?";

                        Connection connection = MySQLConnection.getInstance().getConnection();
                        PreparedStatement preparedStatement = connection.prepareStatement(query);
                        preparedStatement.setString(1,login1);
                        preparedStatement.setString(2,password1);
                        ResultSet resultSet = preparedStatement.executeQuery();
                        if(resultSet.next()) {
                            id_passport1 = resultSet.getString("id_passport");
                            resultSet.close();
                            preparedStatement.close();

                            String query1 = "SELECT *FROM imageprofile WHERE id_passport = ?";
                            PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
                            preparedStatement1.setString(1, id_passport1);
                            ResultSet resultSet1 = preparedStatement1.executeQuery();
                            if(resultSet1.next())
                            {url1 = resultSet1.getString(3);
                                photoUser.setImage(new Image(url1));
                                resultSet1.close();
                            preparedStatement1.close();}
                            else {
                                url1 = "file:C:/Users/zamur/Desktop/fast_project/src/main/resources/img/policeman.png";
                            }
                        }
                        else {
                            id_passport1 = null;
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
                                String queryOld = "SELECT COUNT(*) FROM imageprofile WHERE id_passport = ?";
                                String query  = "UPDATE imageProfile SET url = ? WHERE url = ?";
                                String queryInsert = "INSERT INTO imageprofile(url,id_passport) VALUES (?,?)";

                                Connection connection = MySQLConnection.getInstance().getConnection();
                                try {
                                    PreparedStatement preparedStatement1 = connection.prepareStatement(queryOld);
                                    preparedStatement1.setString(1,id_passport1);
                                    ResultSet resultSet = preparedStatement1.executeQuery();
                                    if(!resultSet.next()) {
                                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                                    preparedStatement.setString(1,newUrlImage);
                                    preparedStatement.setString(2, finalUrl);
                                    preparedStatement.executeUpdate();
                                    preparedStatement.close();
                                    }
                                    else {
                                        PreparedStatement preparedStatement = connection.prepareStatement(queryInsert);
                                        preparedStatement.setString(1,newUrlImage);
                                        preparedStatement.setString(2,id_passport1);
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

                    BorderPane profilePane = new BorderPane();
                    profilePane.setTop(menu);
                    profilePane.setCenter(userData);
                    profilePane.setStyle("-fx-background-color: linear-gradient(to bottom, #182E3E, white);");

                    ImageView gerbImage = new ImageView("file:C:/Users/zamur/Desktop/fast_project/src/main/resources/img/gerb.png");
                    ImageView gerbImage1 = new ImageView("file:C:/Users/zamur/Desktop/fast_project/src/main/resources/img/gerb.png");
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

                    String query = "SELECT *FROM person INNER JOIN employee ON person.id_passport = employee.id_passport WHERE person.id_passport = ?";
                    Connection connection = MySQLConnection.getInstance().getConnection();
                    try {
                        PreparedStatement preparedStatement = connection.prepareStatement(query);
                        preparedStatement.setString(1,id_passport1);
                        ResultSet resultSet = preparedStatement.executeQuery();
                        if(resultSet.next())
                        {serviceNumberText.setText(resultSet.getString("service_number"));
                        fullNameText.setText(resultSet.getString("surname") + " " + resultSet.getString("name"));
                        passportText.setText(id_passport1);
                        rankText.setText(resultSet.getString("ranks"));
                        salaryText.setText(resultSet.getString("salary"));
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

                    editDataUserButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {

                            profileGrid.getChildren().remove(fullNameText);
                            fullNameField.setFont(Font.font("Helvetica", FontWeight.BOLD,20));
                            fullNameField.setStyle("-fx-text-fill: red");
                            fullNameField.setMinSize(50,5);
                            fullNameText.setText(fullNameField.getText());

                /*String serviceNumberEmployee = serviceNumberEmployeeText.getText();
                profileGrid.getChildren().remove(serviceNumberEmployeeText);
                TextField serviceNumberEmployeeField = new TextField(serviceNumberEmployee);
                serviceNumberEmployeeField.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                serviceNumberEmployeeField.setStyle("-fx-text-fill: #182E3E");
                serviceNumberEmployeeField.setMinSize(260,45);*/

                            profileGrid.getChildren().remove(passportText);
                            passportField.setFont(Font.font("Helvetica", FontWeight.BOLD,20));
                            passportField.setStyle("-fx-text-fill: red");
                            passportField.setMinSize(50,5);
                            passportText.setText(passportField.getText());

                            profileGrid.getChildren().remove(phoneText);
                            phoneField.setFont(Font.font("Helvetica", FontWeight.BOLD,20));
                            phoneField.setStyle("-fx-text-fill: red");
                            phoneField.setMinSize(50,5);
                            phoneText.setText(phoneField.getText());

                /*String rank = rankText.getText();
                profileGrid.getChildren().remove(rankText);
                TextField rankField = new TextField(rank);
                rankField.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                rankField.setStyle("-fx-text-fill: #182E3E");
                rankField.setMinSize(260,45);

                String salary = salaryText.getText();
                profileGrid.getChildren().remove(salaryText);
                TextField salaryField = new TextField(salary);
                salaryField.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                salaryField.setStyle("-fx-text-fill: #182E3E");
                salaryField.setMinSize(260,45);*/

                            profileGrid.getChildren().remove(mailText);
                            mailField.setFont(Font.font("Helvetica", FontWeight.BOLD,20));
                            mailField.setStyle("-fx-text-fill: red");
                            mailField.setMinSize(50,5);
                            mailText.setText(mailField.getText());

                            profileGrid.setMaxSize(500,20);
                            profileGrid.add(fullNameField,1,1);
                            profileGrid.add(passportField,1,2);
                            profileGrid.add(phoneField,1,3);
                            //profileGrid.add(rankField,1,4);
                            //profileGrid.add(salaryField,1,5);
                            profileGrid.add(mailField,1,6);

                            fullData.getChildren().remove(editDataUserButton);
                            fullData.getChildren().add(saveDataUserButton);
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
                    saveDataUserButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            profileGrid.getChildren().remove(fullNameField);
                            profileGrid.getChildren().remove(passportField);
                            profileGrid.getChildren().remove(phoneField);
                            profileGrid.getChildren().remove(mailField);
                            profileGrid.add(fullNameText,1,1);
                            profileGrid.add(passportText,1,2);
                            profileGrid.add(phoneText,1,3);
                            profileGrid.add(mailText,1,6);
                            fullData.getChildren().remove(saveDataUserButton);
                            fullData.getChildren().add(editDataUserButton);
                            //profileGrid.setMaxSize(600,20);
                        }
                    });

                    Scene profile = new Scene(profilePane,width,height);
                    profileButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            stage.setScene(profile);
                            stage.show();
                        }
                    });

                    TableView<Employee> employeesTable = new TableView<>();
                    TableColumn<Employee,String> serviceNumberEmployee = new TableColumn<>("Личный номер");
                    serviceNumberEmployee.setPrefWidth(155);
                    TableColumn<Employee,String> passportEmployee = new TableColumn<>("Паспорт");
                    passportEmployee.setPrefWidth(155);
                    TableColumn<Employee,String> surnameEmployee = new TableColumn<>("Фамилия");
                    surnameEmployee.setPrefWidth(155);
                    TableColumn<Employee,String> nameEmployee = new TableColumn<>("Имя");
                    nameEmployee.setPrefWidth(155);
                    TableColumn<Employee,String> rankEmployee = new TableColumn<>("Звание");
                    rankEmployee.setPrefWidth(155);
                    TableColumn<Employee,String> salaryEmployee = new TableColumn<>("Оклад");
                    salaryEmployee.setPrefWidth(155);
                    TableColumn<Employee,String> phoneEmployee = new TableColumn<>("Телефон");
                    phoneEmployee.setPrefWidth(155);
                    TableColumn<Employee,String> mailEmployee = new TableColumn<>("Почта");
                    mailEmployee.setPrefWidth(155);
                    TableColumn<Employee,Void> deleteEmployee = new TableColumn<>("Удалить");
                    deleteEmployee.setCellFactory(cell -> new DeleteButtonCell());
                    deleteEmployee.setPrefWidth(88);
                    TableColumn<Employee,Void> profileEmployee = new TableColumn<>("Профиль");
                    profileEmployee.setCellFactory(cell -> new fullEmployeeProfile(profile,stage));
                    profileEmployee.setPrefWidth(98);

                    serviceNumberEmployee.setCellValueFactory(new PropertyValueFactory<>("serviceNumber"));
                    passportEmployee.setCellValueFactory(new PropertyValueFactory<>("passport"));
                    surnameEmployee.setCellValueFactory(new PropertyValueFactory<>("surname"));
                    nameEmployee.setCellValueFactory(new PropertyValueFactory<>("name"));
                    rankEmployee.setCellValueFactory(new PropertyValueFactory<>("rank"));
                    salaryEmployee.setCellValueFactory(new PropertyValueFactory<>("salary"));
                    phoneEmployee.setCellValueFactory(new PropertyValueFactory<>("phone"));
                    mailEmployee.setCellValueFactory(new PropertyValueFactory<>("mail"));

                    serviceNumberEmployee.setStyle("-fx-font-weight: bold; -fx-text-fill: #182E3E; -fx-font-family: Helvetica; -fx-font-size: 14px; -fx-alignment: center");
                    passportEmployee.setStyle("-fx-font-weight: bold; -fx-text-fill: #182E3E; -fx-font-family: Helvetica; -fx-font-size: 14px; -fx-alignment: center");
                    surnameEmployee.setStyle("-fx-font-weight: bold; -fx-text-fill: #182E3E; -fx-font-family: Helvetica; -fx-font-size: 14px; -fx-alignment: center");
                    nameEmployee.setStyle("-fx-font-weight: bold; -fx-text-fill: #182E3E; -fx-font-family: Helvetica; -fx-font-size: 14px; -fx-alignment: center");
                    rankEmployee.setStyle("-fx-font-weight: bold; -fx-text-fill: #182E3E; -fx-font-family: Helvetica; -fx-font-size: 14px; -fx-alignment: center");
                    salaryEmployee.setStyle("-fx-font-weight: bold; -fx-text-fill: #182E3E; -fx-font-family: Helvetica; -fx-font-size: 14px; -fx-alignment: center");
                    phoneEmployee.setStyle("-fx-font-weight: bold; -fx-text-fill: #182E3E; -fx-font-family: Helvetica; -fx-font-size: 14px; -fx-alignment: center");
                    mailEmployee.setStyle("-fx-font-weight: bold; -fx-text-fill: #182E3E; -fx-font-family: Helvetica; -fx-font-size: 14px; -fx-alignment: center");

                    employeesTable.getColumns().addAll(serviceNumberEmployee,passportEmployee,surnameEmployee,nameEmployee,rankEmployee,
                            salaryEmployee,phoneEmployee,mailEmployee,deleteEmployee, profileEmployee);

                    // кнопка "Список сотрудников"
                    Button employeesButtonList = new Button("Сотрудники");
                    employeesButtonList.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                    employeesButtonList.setTextFill(Color.WHITE);
                    employeesButtonList.setTextAlignment(TextAlignment.CENTER);
                    employeesButtonList.setStyle("-fx-background-color: #182E3E;");
                    employeesButtonList.setPrefSize(300, 50);
                    employeesButtonList.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            employeesButtonList.setStyle("-fx-background-color: #085b96");
                        }
                    });

                    employeesButtonList.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            employeesButtonList.setStyle("-fx-background-color: #182E3E");
                        }
                    });

                    // кнопка "Список преступников"
                    Button gangsterButtonList = new Button("Преступники");
                    gangsterButtonList.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                    gangsterButtonList.setTextFill(Color.WHITE);
                    gangsterButtonList.setTextAlignment(TextAlignment.CENTER);
                    gangsterButtonList.setStyle("-fx-background-color: #182E3E; ");
                    gangsterButtonList.setPrefSize(300, 50);
                    gangsterButtonList.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            gangsterButtonList.setStyle("-fx-background-color: #085b96");
                        }
                    });

                    gangsterButtonList.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            gangsterButtonList.setStyle("-fx-background-color: #182E3E");
                        }
                    });

                    // кнопка "Профиль"
                    Button profileButtonList = new Button("Профиль");
                    profileButtonList.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                    profileButtonList.setTextFill(Color.WHITE);
                    profileButtonList.setTextAlignment(TextAlignment.CENTER);
                    profileButtonList.setStyle("-fx-background-color: #182E3E; ");
                    profileButtonList.setPrefSize(300, 50);

                    profileButtonList.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            profileButtonList.setStyle("-fx-background-color: #085b96");
                        }
                    });

                    profileButtonList.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            profileButtonList.setStyle("-fx-background-color: #182E3E");
                        }
                    });

                    profileButtonList.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            stage.setScene(profile); stage.show();
                        }
                    });

                    // кнопка "Выход"
                    Button exitButtonList = new Button("Выход");
                    exitButtonList.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                    exitButtonList.setTextFill(Color.WHITE);
                    exitButtonList.setTextAlignment(TextAlignment.CENTER);
                    exitButtonList.setStyle("-fx-background-color: #182E3E; ");
                    exitButtonList.setPrefSize(300, 50);
                    exitButtonList.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            exitButtonList.setStyle("-fx-background-color: #085b96");
                        }
                    });

                    exitButtonList.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            exitButtonList.setStyle("-fx-background-color: #182E3E");
                        }
                    });

                    exitButtonList.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            stage.close();
                        }
                    });

                    Button casesButtonList = new Button("Дела");
                    casesButtonList.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                    casesButtonList.setTextFill(Color.WHITE);
                    casesButtonList.setTextAlignment(TextAlignment.CENTER);
                    casesButtonList.setStyle("-fx-background-color: #182E3E; ");
                    casesButtonList.setPrefSize(300, 50);

                    casesButtonList.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            casesButtonList.setStyle("-fx-background-color: #085b96");
                        }
                    });

                    casesButtonList.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {casesButtonList.setStyle("-fx-background-color: #182E3E");
                        }
                    });

                    Button addEmployee = new Button("Добавить сотрудника");
                    addEmployee.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                    addEmployee.setTextFill(Color.WHITE);
                    addEmployee.setTextAlignment(TextAlignment.CENTER);
                    addEmployee.setStyle("-fx-background-color: #182E3E; ");
                    addEmployee.setPrefSize(305, 50);

                    Button searchFullEmployees = new Button("Все сотрудники");
                    searchFullEmployees.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                    searchFullEmployees.setTextFill(Color.WHITE);
                    searchFullEmployees.setTextAlignment(TextAlignment.CENTER);
                    searchFullEmployees.setStyle("-fx-background-color: #182E3E; ");
                    searchFullEmployees.setPrefSize(305, 50);

                    searchFullEmployees.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            String query = "SELECT *FROM employee JOIN person ON employee.id_passport = person.id_passport";
                            Connection connection = MySQLConnection.getInstance().getConnection();

                            try {
                                PreparedStatement pst = connection.prepareStatement(query);
                                ResultSet resultSet = pst.executeQuery();

                                ObservableList<Employee> observableList = FXCollections.observableArrayList();
                                while(resultSet.next()) {
                                    Employee emp = new Employee(resultSet.getString("name"),resultSet.getString("surname"),resultSet.getString("ranks"),"",resultSet.getString("id_passport"),resultSet.getString("service_number"),resultSet.getString("salary"),"000");
                                    observableList.add(emp);
                                    employeesTable.setItems(observableList);
                                }

                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    });



                    addEmployee.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            addEmployee.setStyle("-fx-background-color: #085b96");
                        }
                    });
                    addEmployee.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            addEmployee.setStyle("-fx-background-color: #182E3E;");
                        }
                    });

                    searchFullEmployees.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            searchFullEmployees.setStyle("-fx-background-color: #085b96");
                        }
                    });
                    searchFullEmployees.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            searchFullEmployees.setStyle("-fx-background-color: #182E3E;");
                        }
                    });

                    addEmployee.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {

                /*TextField serviceNumberField = new TextField();
                serviceNumberField.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                serviceNumberField.setPromptText("Личный номер");
                serviceNumberField.setStyle("-fx-text-fill: #182E3E");
                serviceNumberField.setPrefSize(305,50)*/;

                            TextField passportField = new TextField();
                            passportField.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                            passportField.setPromptText("Паспорт");
                            passportField.setStyle("-fx-text-fill: #182E3E");
                            passportField.setPrefSize(305,50);

                            Tooltip tooltipPassport = new Tooltip("Введите серию и номер паспорта без пробела");
                            tooltipPassport.setStyle("-fx-font-weight: bold; -fx-text-fill: #182E3E; -fx-font-family: Helvetica; -fx-font-size: 25px; -fx-alignment: center; -fx-background-color: white");
                            passportField.setTooltip(tooltipPassport);

                            TextField surnameField = new TextField();
                            surnameField.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                            surnameField.setPromptText("Фамилия");
                            surnameField.setStyle("-fx-text-fill: #182E3E");
                            surnameField.setPrefSize(305,50);

                            TextField nameField = new TextField();
                            nameField.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                            nameField.setPromptText("Имя");
                            nameField.setStyle("-fx-text-fill: #182E3E");
                            nameField.setPrefSize(305,50);

                            TextField rankField = new TextField();
                            rankField.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                            rankField.setPromptText("Звание");
                            rankField.setStyle("-fx-text-fill: #182E3E");
                            rankField.setPrefSize(305,50);

                            TextField salaryField = new TextField();
                            salaryField.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                            salaryField.setPromptText("Оклад");
                            salaryField.setStyle("-fx-text-fill: #182E3E");
                            salaryField.setPrefSize(305,50);

                            TextField phoneField = new TextField();
                            phoneField.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                            phoneField.setPromptText("Телефон");
                            phoneField.setStyle("-fx-text-fill: #182E3E");
                            phoneField.setPrefSize(305,50);

                            TextField mailField = new TextField();
                            mailField.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                            mailField.setPromptText("Почта");
                            mailField.setStyle("-fx-text-fill: #182E3E");
                            mailField.setPrefSize(305,50);

                            Label addSurnameLabel = new Label("Фамилия");
                            addSurnameLabel.setStyle("-fx-text-fill: linear-gradient(to bottom, slategray, white);");
                            addSurnameLabel.setFont(Font.font("Helvetica", FontWeight.BOLD,25));

                            Label addNameLabel = new Label("Имя");
                            addNameLabel.setStyle("-fx-text-fill: linear-gradient(to bottom, slategray, white);");
                            addNameLabel.setFont(Font.font("Helvetica", FontWeight.BOLD,25));

                            Label addPassportLabel = new Label("Паспорт");
                            addPassportLabel.setStyle("-fx-text-fill: linear-gradient(to bottom, slategray, white);");
                            addPassportLabel.setFont(Font.font("Helvetica", FontWeight.BOLD,25));

                            Label addPhoneLabel = new Label("Телефон");
                            addPhoneLabel.setStyle("-fx-text-fill: #182E3E;");
                            addPhoneLabel.setFont(Font.font("Helvetica", FontWeight.BOLD,25));

                            Label addMailLabel = new Label("Почта");
                            addMailLabel.setStyle("-fx-text-fill: #182E3E;");
                            addMailLabel.setFont(Font.font("Helvetica", FontWeight.BOLD,25));

                            Label addRankLabel = new Label("Звание");
                            addRankLabel.setStyle("-fx-text-fill: #182E3E;");
                            addRankLabel.setFont(Font.font("Helvetica", FontWeight.BOLD,25));

                            Label addSalaryLabel = new Label("Оклад");
                            addSalaryLabel.setStyle("-fx-text-fill: #182E3E;");
                            addSalaryLabel.setFont(Font.font("Helvetica", FontWeight.BOLD,25));

                /*Label serviceNumberLabel = new Label("Личный номер");
                serviceNumberLabel.setStyle("-fx-text-fill: linear-gradient(to bottom, slategray, white);");
                serviceNumberLabel.setFont(Font.font("Helvetica", FontWeight.BOLD,25));*/

                            Button addButton = new Button("Добавить");
                            addButton.setStyle("-fx-background-color: #182E3E;");
                            addButton.setTextFill(Color.WHITE);
                            addButton.setPrefSize(305, 50);
                            addButton.setFont(Font.font("Helvetica", FontWeight.BOLD,25));

                            addButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent mouseEvent) {
                                    addButton.setStyle("-fx-background-color: #085b96");
                                }
                            });

                            addButton.setOnMouseExited(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent mouseEvent) {
                                    addButton.setStyle("-fx-background-color: #182E3E");
                                }
                            });

                            GridPane addEmployeeGrid = new GridPane();
                            addEmployeeGrid.setAlignment(Pos.CENTER);
                            addEmployeeGrid.setHgap(10);
                            addEmployeeGrid.setVgap(10);
                            addEmployeeGrid.setPadding(new Insets(10));
                            addEmployeeGrid.setStyle("-fx-background-color: linear-gradient(to bottom, #182E3E, white);");

                            //addEmployeeGrid.add(serviceNumberLabel,0,0);
                            //addEmployeeGrid.add(serviceNumberField,1, 0);

                            addEmployeeGrid.add(addSurnameLabel,0,1);
                            addEmployeeGrid.add(surnameField,1,1);

                            addEmployeeGrid.add(addNameLabel,0,2);
                            addEmployeeGrid.add(nameField,1,2);

                            addEmployeeGrid.add(addPassportLabel,0,3);
                            addEmployeeGrid.add(passportField,1,3);

                            addEmployeeGrid.add(addRankLabel,0,4);
                            addEmployeeGrid.add(rankField,1,4);

                            addEmployeeGrid.add(addSalaryLabel,0,5);
                            addEmployeeGrid.add(salaryField,1,5);

                            addEmployeeGrid.add(addPhoneLabel,0,6);
                            addEmployeeGrid.add(phoneField,1,6);

                            addEmployeeGrid.add(addMailLabel,0,7);
                            addEmployeeGrid.add(mailField,1,7);

                            addEmployeeGrid.add(addButton,1,8);

                            Scene addEmployeeScene = new Scene(addEmployeeGrid);

                            Stage addEmployeeStage = new Stage();

                            addButton.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent actionEvent) {
                                    String query = "INSERT INTO person(id_passport,surname,name) VALUES (?,?,?)";
                                    String query1 = "INSERT INTO employee(id_passport, ranks, salary) VALUES (?,?,?)";
                                    Connection connection = MySQLConnection.getInstance().getConnection();
                                    try {
                                        PreparedStatement preparedStatement = connection.prepareStatement(query);
                                        preparedStatement.setString(1,passportField.getText());
                                        preparedStatement.setString(2,surnameField.getText());
                                        preparedStatement.setString(3,nameField.getText());
                                        preparedStatement.executeUpdate();

                                        PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
                                        preparedStatement1.setString(1,passportField.getText());
                                        preparedStatement1.setString(2,rankField.getText());
                                        preparedStatement1.setString(3,salaryField.getText());
                                        preparedStatement1.executeUpdate();

                                    } catch (SQLException e) {
                                        throw new RuntimeException(e);
                                    }

                                    addEmployeeStage.close();
                                }
                            });
                            addEmployeeStage.setResizable(false);
                            addEmployeeStage.setTitle("Полиция");
                            addEmployeeStage.getIcons().add(new Image("file:C:/Users/zamur/Desktop/fast_project/src/main/resources/img/logo.png"));
                            addEmployeeStage.setScene(addEmployeeScene);
                            addEmployeeStage.show();
                        }
                    });

                    HBox menuEmployees = new HBox();
                    menuEmployees.setAlignment(Pos.TOP_CENTER);
                    menuEmployees.getChildren().addAll(employeesButtonList,gangsterButtonList,casesButtonList, profileButtonList, exitButtonList);
                    menuEmployees.setSpacing(10);
                    menuEmployees.setStyle("-fx-background-color: #7d7f7d");
                    menuEmployees.setPadding(new Insets(10));

                    TextField surnameField = new TextField();
                    surnameField.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                    surnameField.setPromptText("Фамилия");
                    surnameField.setStyle("-fx-text-fill: #182E3E");
                    surnameField.setPrefSize(305,50);

                    TextField nameField = new TextField();
                    nameField.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                    nameField.setPromptText("Имя");
                    nameField.setStyle("-fx-text-fill: #182E3E");
                    nameField.setPrefSize(305,50);

                    TextField rankField = new TextField();
                    rankField.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                    rankField.setPromptText("Звание");
                    rankField.setStyle("-fx-text-fill: #182E3E");
                    rankField.setPrefSize(305,50);

                    Button searchButton = new Button("Поиск");
                    searchButton.setStyle("-fx-background-color: #182E3E;");
                    searchButton.setTextFill(Color.WHITE);
                    searchButton.setPrefSize(305, 50);
                    searchButton.setFont(Font.font("Helvetica", FontWeight.BOLD,25));

                    searchButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            searchButton.setStyle("-fx-background-color: #085b96");
                        }
                    });
                    searchButton.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            searchButton.setStyle("-fx-background-color: #182E3E;");
                        }
                    });

                    searchButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                           /* ObservableList<Employee> items = employeesTable.getItems();
                            for (Employee item : items) {
                                if (item.getMyObservableValue().equals(valueToDelete)) {
                                    items.remove(item);
                                }
                            }*/
                        }
                    });

                    HBox editButtons = new HBox();
                    editButtons.getChildren().addAll(addEmployee,searchFullEmployees);
                    editButtons.setSpacing(10);
                    editButtons.setPadding(new Insets(10));
                    editButtons.setAlignment(Pos.CENTER);

                    HBox searchBox = new HBox();
                    searchBox.getChildren().addAll(surnameField,nameField,rankField,searchButton);
                    searchBox.setSpacing(10);
                    searchBox.setPadding(new Insets(0,10,10,10));
                    searchBox.setAlignment(Pos.CENTER);

                    VBox vb = new VBox();
                    vb.getChildren().addAll(menuEmployees, editButtons,searchBox);

                    BorderPane employeesPane = new BorderPane();
                    employeesPane.setCenter(employeesTable);
                    employeesPane.setTop(vb);

                    Scene employeesScene = new Scene(employeesPane,width,height);

                    employeesButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            stage.setScene(employeesScene);
                            //employeesButton.setOnM
                            stage.show();
                        }
                    });
                    employeesButtonList.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            stage.setScene(employeesScene);
                        }
                    });

                    TableView<String> gangstersTable = new TableView();
                    TableColumn<String,String> numberOfGangster = new TableColumn<String,String>("Серийный номер");
                    numberOfGangster.setPrefWidth(155);
                    TableColumn<String,String> passportGangster = new TableColumn<String,String>("Паспорт");
                    passportGangster.setPrefWidth(155);
                    TableColumn<String,String> surnameGangster = new TableColumn<String,String>("Фамилия");
                    surnameGangster.setPrefWidth(155);
                    TableColumn<String,String> nameGangster = new TableColumn<String,String>("Имя");
                    nameGangster.setPrefWidth(155);
                    TableColumn<String,String> crime = new TableColumn<String,String>("Преступление");
                    crime.setPrefWidth(155);
                    TableColumn<String,String> statusGangster = new TableColumn<String,String>("Статус");
                    statusGangster.setPrefWidth(155);

                    gangstersTable.getColumns().addAll(numberOfGangster,passportGangster,surnameGangster,
                            nameGangster,crime,statusGangster);
                    // кнопка "Список сотрудников"
                    Button employeesButtonList1 = new Button("Сотрудники");
                    employeesButtonList1.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                    employeesButtonList1.setTextFill(Color.WHITE);
                    employeesButtonList1.setTextAlignment(TextAlignment.CENTER);
                    employeesButtonList1.setStyle("-fx-background-color: #182E3E;");
                    employeesButtonList1.setPrefSize(300, 50);
                    employeesButtonList1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            employeesButtonList1.setStyle("-fx-background-color: #085b96");
                        }
                    });

                    employeesButtonList1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            employeesButtonList1.setStyle("-fx-background-color: #182E3E");
                        }
                    });

                    employeesButtonList1.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            stage.setScene(employeesScene);
                        }
                    });
                    // кнопка "Список преступников"
                    Button gangsterButtonList1 = new Button("Преступники");
                    gangsterButtonList1.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                    gangsterButtonList1.setTextFill(Color.WHITE);
                    gangsterButtonList1.setTextAlignment(TextAlignment.CENTER);
                    gangsterButtonList1.setStyle("-fx-background-color: #182E3E; ");
                    gangsterButtonList1.setPrefSize(300, 50);
                    gangsterButtonList1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            gangsterButtonList1.setStyle("-fx-background-color: #085b96");
                        }
                    });

                    gangsterButtonList1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            gangsterButtonList1.setStyle("-fx-background-color: #182E3E");
                        }
                    });

                    // кнопка "Профиль"
                    Button profileButtonList1 = new Button("Профиль");
                    profileButtonList1.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                    profileButtonList1.setTextFill(Color.WHITE);
                    profileButtonList1.setTextAlignment(TextAlignment.CENTER);
                    profileButtonList1.setStyle("-fx-background-color: #182E3E; ");
                    profileButtonList1.setPrefSize(300, 50);

                    profileButtonList1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            profileButtonList1.setStyle("-fx-background-color: #085b96");
                        }
                    });

                    profileButtonList1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            profileButtonList1.setStyle("-fx-background-color: #182E3E");
                        }
                    });

                    profileButtonList1.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            stage.setScene(profile); stage.show();
                        }
                    });

                    // кнопка "Выход"
                    Button exitButtonList1 = new Button("Выход");
                    exitButtonList1.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                    exitButtonList1.setTextFill(Color.WHITE);
                    exitButtonList1.setTextAlignment(TextAlignment.CENTER);
                    exitButtonList1.setStyle("-fx-background-color: #182E3E; ");
                    exitButtonList1.setPrefSize(300, 50);
                    exitButtonList1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            exitButtonList1.setStyle("-fx-background-color: #085b96");
                        }
                    });

                    exitButtonList1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            exitButtonList1.setStyle("-fx-background-color: #182E3E");
                        }
                    });

                    exitButtonList1.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            stage.close();
                        }
                    });

                    Button casesButtonList1 = new Button("Дела");
                    casesButtonList1.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                    casesButtonList1.setTextFill(Color.WHITE);
                    casesButtonList1.setTextAlignment(TextAlignment.CENTER);
                    casesButtonList1.setStyle("-fx-background-color: #182E3E; ");
                    casesButtonList1.setPrefSize(300, 50);
                    casesButtonList1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            casesButtonList1.setStyle("-fx-background-color: #085b96");
                        }
                    });


                    casesButtonList1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {casesButtonList1.setStyle("-fx-background-color: #182E3E");
                        }
                    });

                    Button addGangster = new Button("Добавить преступника");
                    addGangster.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                    addGangster.setTextFill(Color.WHITE);
                    addGangster.setTextAlignment(TextAlignment.CENTER);
                    addGangster.setStyle("-fx-background-color: #182E3E; ");
                    addGangster.setPrefSize(315, 50);

                    addGangster.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            addGangster.setStyle("-fx-background-color: #085b96");
                        }
                    });
                    addGangster.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            addGangster.setStyle("-fx-background-color: #182E3E;");
                        }
                    });

                    addGangster.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {

                            TextField serialNumberField = new TextField();
                            serialNumberField.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                            serialNumberField.setPromptText("Серийный номер");
                            serialNumberField.setStyle("-fx-text-fill: #182E3E");
                            serialNumberField.setPrefSize(305,50);

                            TextField passportField = new TextField();
                            passportField.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                            passportField.setPromptText("Паспорт");
                            passportField.setStyle("-fx-text-fill: #182E3E");
                            passportField.setPrefSize(305,50);

                            TextField surnameField = new TextField();
                            surnameField.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                            surnameField.setPromptText("Фамилия");
                            surnameField.setStyle("-fx-text-fill: #182E3E");
                            surnameField.setPrefSize(305,50);

                            TextField nameField = new TextField();
                            nameField.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                            nameField.setPromptText("Имя");
                            nameField.setStyle("-fx-text-fill: #182E3E");
                            nameField.setPrefSize(305,50);

                            TextField crimeField = new TextField();
                            crimeField.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                            crimeField.setPromptText("Преступление");
                            crimeField.setStyle("-fx-text-fill: #182E3E");
                            crimeField.setPrefSize(305,50);

                            TextField statusField = new TextField();
                            statusField.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                            statusField.setPromptText("Статус");
                            statusField.setStyle("-fx-text-fill: #182E3E");
                            statusField.setPrefSize(305,50);

                            TextField dateCrimeField = new TextField();
                            dateCrimeField.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                            dateCrimeField.setPromptText("Дата преступления");
                            dateCrimeField.setStyle("-fx-text-fill: #182E3E");
                            dateCrimeField.setPrefSize(305,50);

                            Label addSurnameLabel = new Label("Фамилия");
                            addSurnameLabel.setStyle("-fx-text-fill: linear-gradient(to bottom, slategray, white);");
                            addSurnameLabel.setFont(Font.font("Helvetica", FontWeight.BOLD,25));

                            Label addNameLabel = new Label("Имя");
                            addNameLabel.setStyle("-fx-text-fill: linear-gradient(to bottom, slategray, white);");
                            addNameLabel.setFont(Font.font("Helvetica", FontWeight.BOLD,25));

                            Label addPassportLabel = new Label("Паспорт");
                            addPassportLabel.setStyle("-fx-text-fill: #182E3E;");
                            addPassportLabel.setFont(Font.font("Helvetica", FontWeight.BOLD,25));

                            Label dateCrimeLabel = new Label("Дата преступления");
                            dateCrimeLabel.setStyle("-fx-text-fill: #182E3E;");
                            dateCrimeLabel.setFont(Font.font("Helvetica", FontWeight.BOLD,25));

                            Label crimeLabel = new Label("Преступление");
                            crimeLabel.setStyle("-fx-text-fill: #182E3E;");
                            crimeLabel.setFont(Font.font("Helvetica", FontWeight.BOLD,25));

                            Label serialNumberLabel = new Label("Серийный номер");
                            serialNumberLabel.setStyle("-fx-text-fill: linear-gradient(to bottom, slategray, white);");
                            serialNumberLabel.setFont(Font.font("Helvetica", FontWeight.BOLD,25));

                            Button addButton = new Button("Добавить");
                            addButton.setStyle("-fx-background-color: #182E3E;");
                            addButton.setTextFill(Color.WHITE);
                            addButton.setPrefSize(305, 50);
                            addButton.setFont(Font.font("Helvetica", FontWeight.BOLD,25));

                            addButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent mouseEvent) {
                                    addButton.setStyle("-fx-background-color: #085b96");
                                }
                            });

                            addButton.setOnMouseExited(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent mouseEvent) {
                                    addButton.setStyle("-fx-background-color: #182E3E");
                                }
                            });

                            GridPane addGangsterGrid = new GridPane();
                            addGangsterGrid.setAlignment(Pos.CENTER);
                            addGangsterGrid.setHgap(10);
                            addGangsterGrid.setVgap(10);
                            addGangsterGrid.setStyle("-fx-background-color: linear-gradient(to bottom, #182E3E, white);");
                            addGangsterGrid.setPadding(new Insets(10));

                            addGangsterGrid.add(serialNumberLabel,0,0);
                            addGangsterGrid.add(serialNumberField,1, 0);

                            addGangsterGrid.add(addSurnameLabel,0,1);
                            addGangsterGrid.add(surnameField,1,1);

                            addGangsterGrid.add(addNameLabel,0,2);
                            addGangsterGrid.add(nameField,1,2);

                            addGangsterGrid.add(addPassportLabel,0,3);
                            addGangsterGrid.add(passportField,1,3);

                            addGangsterGrid.add(crimeLabel,0,4);
                            addGangsterGrid.add(crimeField,1,4);

                            addGangsterGrid.add(dateCrimeLabel,0,5);
                            addGangsterGrid.add(dateCrimeField,1,5);

                            addGangsterGrid.add(addButton,1,6);

                            Scene addGangsterScene = new Scene(addGangsterGrid,width,height);

                            Stage addGangsterStage = new Stage();

                            addButton.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent actionEvent) {
                                    addGangsterStage.close();
                                }
                            });
                            addGangsterStage.setResizable(false);
                            addGangsterStage.setTitle("Полиция");
                            addGangsterStage.getIcons().add(new Image("file:C:/Users/zamur/Desktop/fast_project/src/main/resources/img/logo.png"));
                            addGangsterStage.setScene(addGangsterScene);
                            addGangsterStage.show();
                        }
                    });

                    HBox menuGangsters = new HBox();
                    menuGangsters.setAlignment(Pos.TOP_CENTER);
                    menuGangsters.getChildren().addAll(employeesButtonList1,gangsterButtonList1,casesButtonList1, profileButtonList1, exitButtonList1);
                    menuGangsters.setSpacing(10);
                    menuGangsters.setStyle("-fx-background-color: #7d7f7d");
                    menuGangsters.setPadding(new Insets(10));

                    TextField surnameField1 = new TextField();
                    surnameField1.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                    surnameField1.setPromptText("Фамилия");
                    surnameField1.setStyle("-fx-text-fill: #182E3E");
                    surnameField1.setPrefSize(315,50);

                    TextField nameField1 = new TextField();
                    nameField1.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                    nameField1.setPromptText("Имя");
                    nameField1.setStyle("-fx-text-fill: #182E3E");
                    nameField1.setPrefSize(315,50);

                    TextField crimeField = new TextField();
                    crimeField.setFont(Font.font("Helvetica", FontWeight.BOLD,25));
                    crimeField.setPromptText("Преступление");
                    crimeField.setStyle("-fx-text-fill: #182E3E");
                    crimeField.setPrefSize(315,50);

                    Button searchButton1 = new Button("Поиск");
                    searchButton1.setStyle("-fx-background-color: #182E3E;");
                    searchButton1.setTextFill(Color.WHITE);
                    searchButton1.setPrefSize(315, 50);
                    searchButton1.setFont(Font.font("Helvetica", FontWeight.BOLD,25));

                    searchButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            searchButton1.setStyle("-fx-background-color: #085b96");
                        }
                    });
                    searchButton1.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            searchButton1.setStyle("-fx-background-color: #182E3E;");
                        }
                    });

                    HBox editButtons1 = new HBox();
                    editButtons1.getChildren().addAll(addGangster);
                    editButtons1.setSpacing(10);
                    editButtons1.setPadding(new Insets(10));
                    editButtons1.setAlignment(Pos.CENTER);

                    HBox searchBox1 = new HBox();
                    searchBox1.getChildren().addAll(surnameField1,nameField1,crimeField,searchButton1);
                    searchBox1.setSpacing(10);
                    searchBox1.setPadding(new Insets(0,10,10,10));
                    searchBox1.setAlignment(Pos.CENTER);

                    VBox vb1 = new VBox();
                    vb1.getChildren().addAll(menuGangsters, editButtons1,searchBox1);

                    BorderPane gangstersPane = new BorderPane();
                    gangstersPane.setCenter(gangstersTable);
                    gangstersPane.setTop(vb1);

                    Scene gangstersScene = new Scene(gangstersPane,width,height);

                    gangsterButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            stage.setScene(gangstersScene);
                        }
                    });

                    gangsterButtonList.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            stage.setScene(gangstersScene);
                        }
                    });
                    gangsterButtonList1.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            stage.setScene(gangstersScene);
                        }
                    });

                    stage.setScene(profile);
                }
                else {
                    loginField.clear();
                    passwordField.clear();
                }
            }
        });
        stage.setScene(welcomeScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}