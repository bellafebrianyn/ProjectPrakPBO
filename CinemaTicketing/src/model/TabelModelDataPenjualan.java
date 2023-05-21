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
public class TabelModelDataPenjualan extends AbstractTableModel {
    List<DataPenjualan> listData;

    public TabelModelDataPenjualan(List<DataPenjualan> listData) {
        this.listData = listData;
    }

    @Override
    public int getRowCount() {
        return this.listData.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0 : return "ID";
            case 1 : return "Judul Film";
            case 2 : return "Genre";
            case 3 : return "Price";
            case 4 : return "Showtime";
            case 5 : return "Total Price";
            case 6 : return "Seat";
            default : return null;
        }
 }
        
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 : return listData.get(rowIndex).getId_order();
            case 1 : return listData.get(rowIndex).getFilm_title();
            case 2 : return listData.get(rowIndex).getGenre();
            case 3 : return listData.get(rowIndex).getPrice();
            case 4 : return listData.get(rowIndex).getShowtime();
            case 5 : return listData.get(rowIndex).getTotal_price();
            case 6 : return listData.get(rowIndex).getSeat();
            default : return null;
       }
    }
}
