/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.DAOFilm;
import interfaceFilm.InterfaceFilm;
import java.util.List;
import model.Film;
import model.TabelModelPemesanan;
import view.View_employee;

/**
 *
 * @author Bella Febriany
 */
public class ControllerPemesanan {
    
    View_employee viewEmployee;
    InterfaceFilm iFilm;
    List<Film> listFilm;
    
    public ControllerPemesanan(View_employee viewEmployee) {
        this.viewEmployee = viewEmployee;
        iFilm = new DAOFilm();
    }

    public void readData() {
        listFilm = iFilm.getAll();
        TabelModelPemesanan tabelPemesanan = new TabelModelPemesanan(listFilm);
        viewEmployee.getTableData().setModel(tabelPemesanan);
    }

    public void selectField(int row) {
        
        viewEmployee.getFieldFilm().setText(listFilm.get(row).getTittle());
        viewEmployee.getFieldGenre().setText(listFilm.get(row).getGenre());
        viewEmployee.getFieldPrice().setText(listFilm.get(row).getPrice().toString());
        viewEmployee.getA1().setEnabled(true);
        viewEmployee.getA1().setSelected(false);
        viewEmployee.getA2().setEnabled(true);
        viewEmployee.getA2().setSelected(false);
        viewEmployee.getA3().setEnabled(true);
        viewEmployee.getA3().setSelected(false);
        viewEmployee.getA4().setEnabled(true);
        viewEmployee.getA4().setSelected(false);
        viewEmployee.getA5().setEnabled(true);
        viewEmployee.getA5().setSelected(false);
        viewEmployee.getB1().setEnabled(true);
        viewEmployee.getB1().setSelected(false);
        viewEmployee.getB2().setEnabled(true);
        viewEmployee.getB2().setSelected(false);
        viewEmployee.getB3().setEnabled(true);
        viewEmployee.getB3().setSelected(false);
        viewEmployee.getB4().setEnabled(true);
        viewEmployee.getB4().setSelected(false);
        viewEmployee.getB5().setEnabled(true);
        viewEmployee.getB5().setSelected(false);
        viewEmployee.getC1().setEnabled(true);
        viewEmployee.getC1().setSelected(false);
        viewEmployee.getC2().setEnabled(true);
        viewEmployee.getC2().setSelected(false);
        viewEmployee.getC3().setEnabled(true);
        viewEmployee.getC3().setSelected(false);
        viewEmployee.getC4().setEnabled(true);
        viewEmployee.getC4().setSelected(false);
        viewEmployee.getC5().setEnabled(true);
        viewEmployee.getC5().setSelected(false);
    }
}
