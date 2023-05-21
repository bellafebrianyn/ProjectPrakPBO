/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaceFilm;

import java.util.List;
import model.Film;
/**
 *
 * @author Bella Febriany
 */
public interface InterfaceFilm {
    public List<Film> getAll();
    
    public void insert(Film film);
    
    public void update(Film update);
            
    public void delete(int id);
    
}
