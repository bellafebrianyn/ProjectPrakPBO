/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bella Febriany
 */
public class TabelUser extends AbstractTableModel {

    List<User> listUser;
    public TabelUser(List<User> listUser) {
        this.listUser = listUser;
    }
    
    @Override
    public int getRowCount() {
        return this.listUser.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0 : return "ID";
            case 1 : return "Username";
            case 2 : return "Password";
            case 3 : return "Role";
            default : return null;
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 : return listUser.get(rowIndex).getId_user();
            case 1 : return listUser.get(rowIndex).getUsername();
            case 2 : return listUser.get(rowIndex).getPassword();
            case 3 : return listUser.get(rowIndex).getRole();
            default : return null;
       }
    }
}
