/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import database.Connector;
import java.sql.*;
import view.View_employee;

/**
 *
 * @author Bella Febriany
 */
public class ControllerShowtime {

    Connection connection;
    View_employee viewEmployee;

    public ControllerShowtime(View_employee viewEmployee) {
        this.viewEmployee = viewEmployee;
        connection = Connector.getConnection();

    }

    public void readShowTime() {
        try {
            Statement st = connection.createStatement();
            String query = "Select * from showtimes;";
            ResultSet result = st.executeQuery(query);
            while (result.next()) {
                viewEmployee.getCBshowtime().addItem(result.getString("time"));
            }
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
        }
    }

}
