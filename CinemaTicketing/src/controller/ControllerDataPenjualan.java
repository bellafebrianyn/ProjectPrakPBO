/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
/**
 *
 * @author Bella Febriany
 */
import DAO.DAODataPenjualan;
import interfaceFilm.InterfaceDataPenjualan;
import java.util.List;
import model.DataPenjualan;
import model.TabelModelDataPenjualan;
import view.View_historyOrder;


public class ControllerDataPenjualan {
    View_historyOrder viewData;
    InterfaceDataPenjualan iData;
    List<DataPenjualan> listData;

    public ControllerDataPenjualan(View_historyOrder viewData) {
        this.viewData = viewData;
        iData = new DAODataPenjualan();
    }
    
    public void readData() {
        listData = iData.getAll();
        TabelModelDataPenjualan tabelData = new TabelModelDataPenjualan(listData);
        viewData.getTableData().setModel(tabelData);
    }
}
