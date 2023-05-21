/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import interfaceFilm.InterfaceOrder;
import model.Order;
import java.sql.*;
import database.Connector;

/**
 *
 * @author Bella Febriany
 */
public class DAOOrder implements InterfaceOrder {

    Connection connect;

    public DAOOrder() {
        connect = Connector.getConnection();
    }

    @Override
    public void insertOrder(Order order) {
        PreparedStatement statement = null;
        
        try {
            statement = connect.prepareStatement("INSERT INTO `order` (`film_title`, `genre`, `showtime`, `price`, `total_price`, `seat`) VALUES (?,?,?,?,?,?);");
            statement.setString(1, order.getFilm_title());
            statement.setString(2, order.getGenre());
            statement.setString(3, order.getShowtime());
            statement.setInt(4, order.getPrice());
            statement.setInt(5, order.getTotal_price());
            statement.setString(6, order.getSeat());
            statement.execute();
        } catch (Exception e) {
            
            System.out.println("Error : " + e.getMessage());
        }finally{
            try {
                statement.close();
            } catch (Exception e) {
                System.out.println("Erorr : " + e.getMessage());
            }
    }

    }

}
