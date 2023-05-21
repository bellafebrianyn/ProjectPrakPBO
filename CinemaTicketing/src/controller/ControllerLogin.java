/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import database.Connector;
import java.sql.*;
import javax.swing.JOptionPane;
import view.View_employee;
import view.View_login;
import view.View_menuAdmin;

/**
 *
 * @author Bella Febriany
 */
public class ControllerLogin {

    View_login viewLogin;
    Connection connection;

    public ControllerLogin(View_login viewLogin) {
        this.viewLogin = viewLogin;
        connection = Connector.getConnection();
    }

    public void login() {
        String username = viewLogin.getjUsername().getText();
        String password = viewLogin.getjPassword().getText();

        String checkUser = null;
        String checkPass = null;
        String roles = null;

        try {
            Statement st = connection.createStatement();
            String query = "SELECT * FROM user WHERE username = '" + username + "' AND password = '" + password + "'";
            ResultSet result = st.executeQuery(query);
            while (result.next()) {
                checkUser = result.getString("username");
                checkPass = result.getString("password");
                roles = result.getString("role");

            }
            result.close();
            st.close();

        } catch (Exception e) {
            System.out.println("Login Gagal!");
        }
        if (checkUser == null && checkPass == null) {
            JOptionPane.showMessageDialog(null, "Username atau Password salah");
            viewLogin.setjUsername(null);
            viewLogin.setjPassword(null);
        } else {
            switch (roles) {
                case "Admin":
                    JOptionPane.showMessageDialog(null, "Login Berhasil [Admin]");
                    View_menuAdmin menuAdmin = new View_menuAdmin();
                    menuAdmin.setVisible(true);
                    menuAdmin.setLocationRelativeTo(null);
                    viewLogin.dispose();
                    break;
                    
                case "Employee":
                    JOptionPane.showMessageDialog(null, "Login Berhasil [Employee]");
                    View_employee employee = new View_employee();
                    employee.setVisible(true);
                    employee.setLocationRelativeTo(null);
                    viewLogin.dispose();
                    break;
            }
        }

    }
}
