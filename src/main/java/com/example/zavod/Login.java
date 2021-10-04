package com.example.zavod;

import com.example.zavod.anim.Anim;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Login {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField login_field;
    @FXML
    private PasswordField password_field;
    @FXML
    private Button authSigInButton;
    @FXML
    private Button loginSignUpButton;

    public Login() {
    }

    @FXML
    void initialize() {
        this.authSigInButton.setOnAction((event) -> {
            String loginText = this.login_field.getText().trim();
            String loginPassword = this.password_field.getText().trim();
            if (!loginText.equals("") && !loginPassword.equals("")) {
                this.loginUser(loginText, loginPassword);
            } else {
                System.out.println("Error");
            }

        });
        this.loginSignUpButton.setOnAction((event) -> {
            this.openNewScene("signUp.fxml");
        });
    }

    private void loginUser(String loginText, String loginPassword) {
        Db dbHandler = new Db();
        Users users = new Users();
        users.setUserName(loginText);
        users.setPassword(loginPassword);
        ResultSet result = dbHandler.getUser(users);
        int counter = 0;

        try {
            while(result.next()) {
                ++counter;
            }
        } catch (SQLException var9) {
            var9.printStackTrace();
        }

        if (counter >= 1) {
            this.openNewScene("app.fxml");
        } else {
            Anim userLoginAnim = new Anim(this.login_field);
            Anim userPassAnim = new Anim(this.password_field);
            userLoginAnim.playAnim();
            userPassAnim.playAnim();
        }

    }

    public void openNewScene(String window) {
        this.loginSignUpButton.getScene().getWindow()/*.hide*()*/;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource(window));

        try {
            loader.load();
        } catch (IOException var5) {
            var5.printStackTrace();
        }

        Parent root = (Parent)loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
}