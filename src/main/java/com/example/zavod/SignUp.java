package com.example.zavod;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUp {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField login_field;
    @FXML
    private PasswordField password_field;
    @FXML
    private Button singUpButtton;
    @FXML
    private TextField signUpName;
    @FXML
    private TextField signUpLastName;
    @FXML
    private TextField signUpCountry;
    @FXML
    private CheckBox signUpCheckBoxMale;
    @FXML
    private CheckBox signUpCheckBoxFemale;

    @FXML
    private Button buttonBack;

    public SignUp() {
    }

    @FXML
    void initialize() {
      buttonBack.setOnAction(event -> {
          buttonBack.getScene().getWindow().hide();

          FXMLLoader loader =  new FXMLLoader();
          loader.setLocation(getClass().getResource("sample.fxml"));
      });

        this.singUpButtton.setOnAction((event) -> {
            this.signUpNewUser();
        });
    }

    private void openNewScene(String s) {
    }

    private void signUpNewUser() {
        Db dbHandler = new Db();
        String firstName = this.signUpName.getText();
        String lastName = this.signUpLastName.getText();
        String login = this.login_field.getText();
        String password = this.password_field.getText();
        String location = this.signUpCountry.getText();
        String gender = "";
        if (this.signUpCheckBoxMale.isSelected()) {
            gender = "Мужской";
        } else {
            gender = "Женский";
        }

        Users users = new Users(firstName, lastName, login, password, location, gender);
        dbHandler.signUpUser(users);
    }
}

