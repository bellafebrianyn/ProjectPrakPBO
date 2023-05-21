/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.DAOOrder;
import view.View_employee;
import interfaceFilm.InterfaceOrder;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import model.Order;

/**
 *
 * @author Bella Febriany
 */
public class ControllerOrder {
    View_employee viewEmployee;
    InterfaceOrder iOrder;

    public ControllerOrder(View_employee viewEmployee) {
        this.viewEmployee = viewEmployee;
        iOrder = new DAOOrder();
    }
    
    public void insertOrder(){
        Order order = new Order();
        order.setFilm_title(viewEmployee.getFieldFilm().getText());
        order.setGenre(viewEmployee.getFieldGenre().getText());
        order.setShowtime(viewEmployee.getShowtime());
        order.setPrice(Integer.parseInt(viewEmployee.getFieldPrice().getText()));
        order.setTotal_price(Integer.parseInt(viewEmployee.getFieldTotal().getText()));
        order.setSeat(viewEmployee.selectSeat().getText());
        iOrder.insertOrder(order);
        JOptionPane.showMessageDialog(null, "Insert Order Berhasil");
    }
    
    
}
