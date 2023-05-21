/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cinematicketing;

import database.Connector;
import view.View_login;

/**
 *
 * @author Bella Febriany
 */
public class CinemaTicketing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connector.getConnection();
        View_login viewlogin = new View_login();
        viewlogin.setVisible(true);
        viewlogin.setLocationRelativeTo(null);
    }
}
