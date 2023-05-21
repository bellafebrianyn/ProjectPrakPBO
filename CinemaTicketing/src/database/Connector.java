/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
/**
 *
 * @author Bella Febriany
 */
public class Connector {
    public static Connection connect;
    public Statement statement;
    
    public static Connection getConnection() {
        if (connect == null) {
            MysqlDataSource db = new MysqlDataSource();
            db.setDatabaseName("bioskop_db");
            db.setUser("root");
            db.setPassword("");
            
            try {
                connect = db.getConnection();
                System.out.println("Connected");
            } catch (SQLException e) {
                System.out.println("Error" + e.getMessage());
            }
        }
        return connect;
    }
}
