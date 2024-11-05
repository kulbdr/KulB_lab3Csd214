package com.example.kulb_csd214lab3;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class HelloController {
    public TextField username;
    public PasswordField password;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        String uname = username.getText();
        String pword = password.getText();

        if (uname.isEmpty() || pword.isEmpty()) {
            welcomeText.setText("Please Provide Username or Password.");
        } else if (uname.equals("kulbdr047@gmail.com") && pword.equals("kul123")) {


            try {
                Parent secondScene = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

                Stage secondStage = new Stage();
                secondStage.setTitle("Dashboard");
                secondStage.setScene(new Scene(secondScene));
                Stage firstSceneStage = (Stage) username.getScene().getWindow();
                firstSceneStage.close();


                secondStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            welcomeText.setText("Sorry, Invalid Username or Password.");
        }

    }


}