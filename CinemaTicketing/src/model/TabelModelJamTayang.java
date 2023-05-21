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
public class TabelModelJamTayang extends AbstractTableModel {

    List<JamTayang> listJamTayang;
    public TabelModelJamTayang(List<JamTayang> listJamTayang) {
        this.listJamTayang = listJamTayang;
    }
    
    @Override
    public int getRowCount() {
      return this.listJamTayang.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0 : return "ID";
            case 1 : return "Time";
            default : return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       switch (columnIndex) {
            case 0 : return listJamTayang.get(rowIndex).getId_JamTayang();
            case 1 : return listJamTayang.get(rowIndex).getTime();
            default : return null;
       }
    }
}

