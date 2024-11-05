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

public class employeecontroller implements Initializable {

    public TextField iid;
    public TextField iname;
    public TextField iaddress;
    public TextField isalary;
    @FXML
    private TableView<employeeTable> tableView;
    @FXML
    private TableColumn<employeeTable, Integer> id;
    @FXML
    private TableColumn<employeeTable, String> name;
    @FXML
    private TableColumn<employeeTable, String> address;
    @FXML
    private TableColumn<employeeTable, String> salary;

    ObservableList<employeeTable> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new
                PropertyValueFactory<employeeTable, Integer>("id"));
        name.setCellValueFactory(new
                PropertyValueFactory<employeeTable, String>("name"));
        address.setCellValueFactory(new
                PropertyValueFactory<employeeTable, String>("address"));
        salary.setCellValueFactory(new
                PropertyValueFactory<employeeTable, String>("salary"));
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
            String query = "SELECT * FROM employeetable";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String salary = resultSet.getString("salary");
                tableView.getItems().add(new employeeTable(id, name, address,
                        salary));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void InsertData(ActionEvent actionEvent) {
        String getid = iid.getText();
        String getname = iname.getText();
        String getaddress = iaddress.getText();
        Double getsalary = Double.valueOf(isalary.getText());

        String Fsalary = String.valueOf(calculatesalary(getsalary));


        String jdbcUrl = "jdbc:mysql://localhost:3306/pc_lab3";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "INSERT INTO `employeetable`(`id`,`name`, `address`, `salary`) VALUES('" + getid + "', '"  + getname + "', '" + getaddress+ "', '" + Fsalary+ "')";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void UpdateData(ActionEvent actionEvent) {
        String getid = iid.getText();
        String getname = iname.getText();
        String getaddress = iaddress.getText();

        Double getsalary = Double.valueOf(isalary.getText());

        String Fsalary = String.valueOf(calculatesalary(getsalary));


        String jdbcUrl = "jdbc:mysql://localhost:3306/pc_lab3";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "UPDATE `employeetable` SET `name`='"+getname+"',`address`='"+getaddress+"',`salary`='"+Fsalary+"' WHERE `id` = '"+getid+"'";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void DeleteData(ActionEvent actionEvent) {
        String getid = iid.getText();


        String jdbcUrl = "jdbc:mysql://localhost:3306/pc_lab3";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "DELETE FROM employeetable WHERE `id`= '" + getid + "' ";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public void LoadData(ActionEvent actionEvent) {
        String getid = iid.getText();


        String jdbcUrl = "jdbc:mysql://localhost:3306/pc_lab3";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM employeetable WHERE `id`= '" + getid + "' ";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String salary = resultSet.getString("salary");
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
            Stage firstSceneStage = (Stage) iid.getScene().getWindow();
            firstSceneStage.close();


            secondStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Double calculatesalary(Double salary){
        Double yearly = 12*salary;
        return yearly;
    }
}