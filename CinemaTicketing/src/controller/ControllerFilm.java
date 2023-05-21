/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.DAOFilm;
import interfaceFilm.InterfaceFilm;
import java.util.List;
import javax.swing.JOptionPane;
import model.Film;
import model.TabelModelFilm;
import view.View_film;

/**
 *
 * @author Bella Febriany
 */
public class ControllerFilm {
    View_film viewFilm;
    InterfaceFilm iFilm;
    List<Film> listFilm;

    public ControllerFilm(View_film viewFilm) {
        this.viewFilm = viewFilm;
        iFilm = new DAOFilm();
    }
    
    public void readData() {
        listFilm = iFilm.getAll();
        TabelModelFilm tabelFilm = new TabelModelFilm(listFilm);
        viewFilm.getTableData().setModel(tabelFilm);
    }
    
    public void insertData() {
        Film film = new Film();
        film.setTittle(viewFilm.getTittle().getText());
        film.setGenre(viewFilm.getGenre().getText());
        film.setPrice(Integer.parseInt(viewFilm.getPrice().getText()));
        iFilm.insert(film);
        JOptionPane.showMessageDialog(null, "Input Berhasil");
    }
    
    public void selectField(int row) {
        viewFilm.getId_film().setText(listFilm.get(row).getId_film().toString());
        viewFilm.getTittle().setText(listFilm.get(row).getTittle());
        viewFilm.getGenre().setText(listFilm.get(row).getGenre());
        viewFilm.getPrice().setText(listFilm.get(row).getPrice().toString());
    }
    
    public void updateData() {
        Film film = new Film();
        film.setId_film(Integer.parseInt(viewFilm.getId_film().getText()));
        film.setTittle(viewFilm.getTittle().getText());
        film.setGenre(viewFilm.getGenre().getText());
        film.setPrice(Integer.parseInt(viewFilm.getPrice().getText()));
        iFilm.update(film);
        JOptionPane.showMessageDialog(null, "Update Berhasil");
    }
    
    public void deleteData() {
        Film fl = new Film();
        iFilm.delete(Integer.parseInt(viewFilm.getId_film().getText()));
        JOptionPane.showMessageDialog(null, "Delete Berhasil");
    }
    
    public void reset() {
        viewFilm.getId_film().setText("");
        viewFilm.getTittle().setText("");
        viewFilm.getGenre().setText("");
        viewFilm.getPrice().setText("");
    }
}
