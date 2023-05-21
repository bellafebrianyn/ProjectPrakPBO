/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaceFilm;

import java.util.List;
import model.JamTayang;

/**
 *
 * @author Bella Febriany
 */
public interface InterfaceJamTayang {
    public List<JamTayang> getAll();
    
    public void insert(JamTayang jt);
    
    public void update(JamTayang update);
    
    public void delete(int id);
}
