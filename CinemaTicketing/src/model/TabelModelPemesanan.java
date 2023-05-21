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
public class TabelModelPemesanan extends AbstractTableModel {

    List<Film> listFilm;

    public TabelModelPemesanan(List<Film> listFilm) {
        this.listFilm = listFilm;
    }

    @Override
    public int getRowCount() {
        return this.listFilm.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {

            case 0:
                return "Judul";
            case 1:
                return "Genre";
            case 2:
                return "Price";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {

            case 0:
                return listFilm.get(rowIndex).getTittle();
            case 1:
                return listFilm.get(rowIndex).getGenre();
            case 2:
                return listFilm.get(rowIndex).getPrice();
            default:
                return null;
        }
    }
}
