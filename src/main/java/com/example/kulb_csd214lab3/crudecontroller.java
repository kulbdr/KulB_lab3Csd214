package com.example.kulb_csd214lab3;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
public class crudecontroller implements Initializable {

    public TextField iadminId;
    public TextField iname;
    public TextField iusername;
    public TextField ipassword;
    @FXML
    private TableView<adminTable> tableView;
    @FXML
    private TableColumn<adminTable, Integer> adminId;
    @FXML
    private TableColumn<adminTable, String> name;
    @FXML
    private TableColumn<adminTable, String> username;
    @FXML
    private TableColumn<adminTable, String> password;

    ObservableList<adminTable> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        adminId.setCellValueFactory(new
                PropertyValueFactory<adminTable, Integer>("adminId"));
        name.setCellValueFactory(new
                PropertyValueFactory<adminTable, String>("name"));
        username.setCellValueFactory(new
                PropertyValueFactory<adminTable, String>("username"));
        password.setCellValueFactory(new
                PropertyValueFactory<adminTable, String>("password"));
        tableView.setItems(list);
    }

    public void Hellobutton(ActionEvent actionEvent) {
        list.clear();
        tableView.setItems(list);
        populateTable();
    }

    public void populateTable() {
        // Establish a database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/pc_lab3";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM admintable";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int adminId = resultSet.getInt("adminId");
                String name = resultSet.getString("name");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                tableView.getItems().add(new adminTable(adminId, name, username,
                        password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void InsertData(ActionEvent actionEvent) {
        String getadminId = iadminId.getText();
        String getname = iname.getText();
        String getusername = iusername.getText();
        String getpassword = ipassword.getText();


        String jdbcUrl = "jdbc:mysql://localhost:3306/pc_lab3";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "INSERT INTO `admintable`(`name`, `username`, `password`) VALUES ('" + getname+ "','" + getusername + "','" + getpassword + "')";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void UpdateData(ActionEvent actionEvent) {
        String getadminId = iadminId.getText();
        String getname = iname.getText();
        String getusername = iusername.getText();
        String getpassword = ipassword.getText();


        String jdbcUrl = "jdbc:mysql://localhost:3306/pc_lab3";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database

            String query = "UPDATE `admintable` SET `name`='" + getname + "',``='" + getusername + "',`password`='" + password + "' WHERE `adminId` = '" + getadminId + "'";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void DeleteData(ActionEvent actionEvent) {
        String getadminId = iadminId.getText();


        String jdbcUrl = "jdbc:mysql://localhost:3306/pc_lab3";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "DELETE FROM admintable WHERE `adminId`= '" + getadminId + "' ";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public void LoadData(ActionEvent actionEvent) {
        String getadminId = iadminId.getText();


        String jdbcUrl = "jdbc:mysql://localhost:3306/pc_lab3";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM admintable WHERE `adminId`= '" + getadminId + "' ";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int adminId = resultSet.getInt("adminId");
                String name = resultSet.getString("name");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void BackButton(ActionEvent actionEvent) {
        try {
            Parent secondScene = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

            Stage secondStage = new Stage();
            secondStage.setTitle("Back");
            secondStage.setScene(new Scene(secondScene));
            Stage firstSceneStage = (Stage) iadminId.getScene().getWindow();
            firstSceneStage.close();


            secondStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}