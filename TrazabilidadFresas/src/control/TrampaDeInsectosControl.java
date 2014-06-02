/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import dao.TrampaDeInsectosDAO;
import java.util.ArrayList;
import java.util.List;
import modelo.TrampaDeInsectos;

/**
 *
 * @author JohnFredy
 */
public class TrampaDeInsectosControl {
    
    TrampaDeInsectosDAO dao = new TrampaDeInsectosDAO();
    
    public boolean crear(TrampaDeInsectos t) {
        return validar(t) && dao.create(t);
    }
    
    public boolean eliminar(TrampaDeInsectos t) {
        return dao.delete(t.getId());
    }
    
    public void actualizar(TrampaDeInsectos t) {
        if (validar(t)) {
            dao.update(t);
        }
    }
    
    public TrampaDeInsectos leer(long id) {
        TrampaDeInsectos s = dao.read(id);
        if (s == null) {
            for (TrampaDeInsectos i : leerTodos()) {
                if (i.getId() == id) {
                    s = i;
                    break;
                }
            }
        }
        return s;
    }
    
    public List<TrampaDeInsectos> leerTodos() {
        return dao.readAll();
    }
    
    private boolean validar(TrampaDeInsectos t) {        
        if (t.getNombre() == null
                || t.getId() < 0
                || t.getDescripcion()== null) {
            return false;
        }
        if (t.getRegistros()== null) {
            t.setRegistros(new ArrayList<>());            
        }
        return true;
    }
}
