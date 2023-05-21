/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaceFilm;

import java.util.List;
import model.JamTayang;
import model.User;

/**
 *
 * @author Bella Febriany
 */
public interface InterfaceUser {
    public List<User> getAll();
    
    public void insert(User user);
    
    public void update(User update);
    
    public void delete(int id);
}
