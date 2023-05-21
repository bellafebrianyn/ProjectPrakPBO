/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.User;
import database.Connector;
import interfaceFilm.InterfaceUser;
import java.sql.PreparedStatement;
import java.sql.Statement;
/**
 *
 * @author Bella Febriany
 */
public class DAOUser implements InterfaceUser {
     Connection connect;
    
    public DAOUser() {
        connect = Connector.getConnection();
    }
    
     @Override
    public List<User> getAll() {
        List<User> listUser = null;
        try {
            listUser = new ArrayList<User>();
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM user");
            while (rs.next()) {
                User us = new User();
                us.setId_user(rs.getInt("id"));
                us.setUsername(rs.getString("username"));
                us.setPassword(rs.getString("password"));
                us.setRole(rs.getString("role"));
                listUser.add(us);
            }
            
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }
        return listUser;
    }
    
     @Override
     public void insert(User user) {
        PreparedStatement statement = null;
     
        try {
            statement = connect.prepareStatement("INSERT INTO user (username, password, role) VALUES (?,?,?);");
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getRole());
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Input Gagal (" + e.getMessage() + ")");
        } finally {
            try {
                statement.close();
            } catch (SQLException exc) {
                System.out.println("Input Gagal");
            }
        }
    }
     
     @Override
     public void update(User update) {
        PreparedStatement statement = null;
     
        try {
            statement = connect.prepareStatement("UPDATE user set username=?, password=?, role=? WHERE id=?;");
            
            statement.setString(1, update.getUsername());
            statement.setString(2, update.getPassword());
            statement.setString(3, update.getRole());
            statement.setInt(4, update.getId_user());
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Update Gagal (" + e.getMessage() + ")");
        } finally {
            try {
                statement.close();
            } catch (SQLException exc) {
                System.out.println("Update Gagal");
            }
        }
    }
     
     public void delete(int id) {
        PreparedStatement statement = null;
     
        try {
            statement = connect.prepareStatement("DELETE FROM user WHERE id=?;");
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Delete Gagal (" + e.getMessage() + ")");
        } finally {
            try {
                statement.close();
            } catch (SQLException exc) {
                System.out.println("Delete Gagal");
            }
        }
    }
}
