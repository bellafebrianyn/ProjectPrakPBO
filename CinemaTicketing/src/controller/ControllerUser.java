/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.DAOUser;
import interfaceFilm.InterfaceUser;
import java.util.List;
import javax.swing.JOptionPane;
import model.User;
import model.TabelUser;
import view.View_register;

/**
 *
 * @author Bella Febriany
 */
public class ControllerUser {
    View_register viewUser;
    InterfaceUser iUser;
    List<User> listUser;

    public ControllerUser(View_register viewUser) {
        this.viewUser = viewUser;
        iUser = new DAOUser();
    }
    
    public void readData() {
        listUser = iUser.getAll();
        TabelUser tabelUser = new TabelUser(listUser);
        viewUser.getTableData3().setModel(tabelUser);
    }
    
     public void insertData() {
        User user = new User();
        user.setUsername(viewUser.getUsername().getText());
        user.setPassword(viewUser.getPassword().getText());
        user.setRole(viewUser.getRole());
        iUser.insert(user);
        JOptionPane.showMessageDialog(null, "Input Berhasil");
    }
     
     public void selectField(int row) {
        viewUser.getId_user().setText(listUser.get(row).getId_user().toString());
        viewUser.getUsername().setText(listUser.get(row).getUsername());
        viewUser.getPassword().setText(listUser.get(row).getPassword());
    }
     
    public void updateData() {
        User user = new User();
        user.setId_user(Integer.parseInt(viewUser.getId_user().getText()));
        user.setUsername(viewUser.getUsername().getText());
        user.setPassword(viewUser.getPassword().getText());
        user.setRole(viewUser.getRole());
        iUser.update(user);
        JOptionPane.showMessageDialog(null, "Update Berhasil");
    }
    
    public void deleteData() {
        User user = new User();
        iUser.delete(Integer.parseInt(viewUser.getId_user().getText()));
        JOptionPane.showMessageDialog(null, "Delete Berhasil");
    }
     
    public void reset() {
        viewUser.getId_user().setText("");
        viewUser.getUsername().setText("");
        viewUser.getPassword().setText("");
    }
}
