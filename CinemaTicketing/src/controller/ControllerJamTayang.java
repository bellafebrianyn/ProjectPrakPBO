/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.DAOJamTayang;
import interfaceFilm.InterfaceJamTayang;
import java.util.List;
import javax.swing.JOptionPane;
import model.JamTayang;
import model.TabelModelJamTayang;
import view.View_film;

/**
 *
 * @author Bella Febriany
 */
public class ControllerJamTayang {
    View_film viewJamTayang;
    InterfaceJamTayang iJamTayang;
    List<JamTayang> listJamTayang;

    public ControllerJamTayang(View_film viewJamTayang) {
        this.viewJamTayang = viewJamTayang;
        iJamTayang = new DAOJamTayang();
    }
    
    public void readDataJam() {
        listJamTayang = iJamTayang.getAll();
        TabelModelJamTayang tabelJamTayang = new TabelModelJamTayang(listJamTayang);
        viewJamTayang.getTableDataa().setModel(tabelJamTayang);
    }
    
    public void insertData() {
        JamTayang jt = new JamTayang();
        jt.setTime(viewJamTayang.getTime().getText());
        iJamTayang.insert(jt);
        JOptionPane.showMessageDialog(null, "Input Berhasil");
    }
    
    public void selectField(int row) {
        viewJamTayang.getId_JamTayang().setText(listJamTayang.get(row).getId_JamTayang().toString());
        viewJamTayang.getTime().setText(listJamTayang.get(row).getTime());
    }
    
    public void updateData() {
        JamTayang jt = new JamTayang();
        jt.setId_JamTayang(Integer.parseInt(viewJamTayang.getId_JamTayang().getText()));
        jt.setTime(viewJamTayang.getTime().getText());
        iJamTayang.update(jt);
        JOptionPane.showMessageDialog(null, "Update Berhasil");
    }
    
    public void deleteData() {
        JamTayang jt = new JamTayang();
        iJamTayang.delete(Integer.parseInt(viewJamTayang.getId_JamTayang().getText()));
        JOptionPane.showMessageDialog(null, "Delete Berhasil");
    }
    
    public void reset() {
        viewJamTayang.getId_JamTayang().setText("");
        viewJamTayang.getTime().setText("");
    }
}