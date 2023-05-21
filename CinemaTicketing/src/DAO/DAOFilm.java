/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import interfaceFilm.InterfaceFilm;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Film;
import database.Connector;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author Bella Febriany
 */
public class DAOFilm implements InterfaceFilm {

    Connection connect;
    
    public DAOFilm() {
        connect = Connector.getConnection();
    }
    
    @Override
    public List<Film> getAll() {
        List<Film> listFilm = null;
        try {
            listFilm = new ArrayList<Film>();
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM film");
            while (rs.next()) {
                Film fl = new Film();
                fl.setId_film(rs.getInt("id"));
                fl.setTittle(rs.getString("tittle"));
                fl.setGenre(rs.getString("genre"));
                fl.setPrice(rs.getInt("price"));
                listFilm.add(fl);
            }
            
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }
        return listFilm;
    }
    
    @Override
    public void insert(Film fl) {
        PreparedStatement statement = null;
     
        try {
            statement = connect.prepareStatement("INSERT INTO film (tittle, genre, price) VALUES (?,?,?);");
            statement.setString(1, fl.getTittle());
            statement.setString(2, fl.getGenre());
            statement.setInt(3, fl.getPrice());
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
        public void update(Film update) {
        PreparedStatement statement = null;
     
        try {
            statement = connect.prepareStatement("UPDATE film set tittle=?, genre=?, price=? WHERE id=?;");
            statement.setString(1, update.getTittle());
            statement.setString(2, update.getGenre());
            statement.setInt(3, update.getPrice());
            statement.setInt(4, update.getId_film());
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
            statement = connect.prepareStatement("DELETE FROM film WHERE id=?;");
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
