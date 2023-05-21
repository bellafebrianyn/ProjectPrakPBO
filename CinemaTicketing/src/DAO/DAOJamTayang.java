/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import database.Connector;
import interfaceFilm.InterfaceJamTayang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Film;
import model.JamTayang;

/**
 *
 * @author Bella Febriany
 */
public class DAOJamTayang implements InterfaceJamTayang {

    Connection connect;
    
    public DAOJamTayang() {
        connect = Connector.getConnection();
    }
    
    @Override
    public List<JamTayang> getAll() {
        List<JamTayang> listJamTayang = null;
        try {
            listJamTayang = new ArrayList<JamTayang>();
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM showtimes");
            while (rs.next()) {
                JamTayang jt = new JamTayang();
                jt.setId_JamTayang(rs.getInt("id"));
                jt.setTime(rs.getString("time"));
                listJamTayang.add(jt);
            }
            
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }
        return listJamTayang;
    }
    
    @Override
    public void insert(JamTayang jt) {
        PreparedStatement statement = null;
     
        try {
            statement = connect.prepareStatement("INSERT INTO showtimes (time) VALUES (?);");
            statement.setString(1, jt.getTime());
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
    public void update(JamTayang update) {
        PreparedStatement statement = null;
     
        try {
            statement = connect.prepareStatement("UPDATE showtimes set time=? WHERE id=?;");
            statement.setString(1, update.getTime());
            statement.setInt(2, update.getId_JamTayang());
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

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
     
        try {
            statement = connect.prepareStatement("DELETE FROM showtimes WHERE id=?;");
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
   
