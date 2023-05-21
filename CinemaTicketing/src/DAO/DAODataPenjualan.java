/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import database.Connector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.DataPenjualan;
import interfaceFilm.InterfaceDataPenjualan;

/**
 *
 * @author Bella Febriany
 */
public class DAODataPenjualan implements InterfaceDataPenjualan {
    Connection connect; 
    
    public DAODataPenjualan() {
        connect = Connector.getConnection();
    }

    @Override
    public List<DataPenjualan> getAll() {
        List<DataPenjualan> listData = null;
        
        try {
            listData = new ArrayList<DataPenjualan>();
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM `order`;");
            while (rs.next()) {
                DataPenjualan dp = new DataPenjualan();
                dp.setId_order(rs.getInt("id_order"));
                dp.setFilm_title(rs.getString("film_title"));
                dp.setGenre(rs.getString("genre"));
                dp.setPrice(rs.getInt("price"));
                dp.setShowtime(rs.getString("showtime"));
                dp.setTotal_price(rs.getInt("total_price"));
                dp.setSeat(rs.getString("seat"));
                listData.add(dp);
            }
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        return listData;
    }
}
