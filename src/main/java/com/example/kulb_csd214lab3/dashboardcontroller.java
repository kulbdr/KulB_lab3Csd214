package com.example.kulb_csd214lab3;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class dashboardcontroller {

    public Label welcomeText;

    public void logoutbutton(ActionEvent actionEvent) {
        try {
            Parent secondScene = FXMLLoader.load(getClass().getResource("hello-view.fxml"));

            Stage secondStage = new Stage();
            secondStage.setTitle("LogIn");
            secondStage.setScene(new Scene(secondScene));
            Stage firstSceneStage = (Stage) welcomeText.getScene().getWindow();
            firstSceneStage.close();


            secondStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void useronclick(ActionEvent actionEvent) {
        try {
            Parent secondScene = FXMLLoader.load(getClass().getResource("crud.fxml"));

            Stage secondStage = new Stage();
            secondStage.setTitle("Admin");
            secondStage.setScene(new Scene(secondScene));
            Stage firstSceneStage = (Stage) welcomeText.getScene().getWindow();
            firstSceneStage.close();


            secondStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Employeebutton(ActionEvent actionEvent) {
        try {
            Parent secondScene = FXMLLoader.load(getClass().getResource("employee.fxml"));

            Stage secondStage = new Stage();
            secondStage.setTitle("Employee");
            secondStage.setScene(new Scene(secondScene));
            Stage firstSceneStage = (Stage) welcomeText.getScene().getWindow();
            firstSceneStage.close();


            secondStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Exitbutton(ActionEvent actionEvent) {
        System.exit(0);
    }
}