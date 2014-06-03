/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import dao.PlagaDAO;
import java.util.ArrayList;
import java.util.List;
import modelo.Plaga;

/**
 *
 * @author JohnFredy
 */
public class PlagaControl {
    
    PlagaDAO dao = new PlagaDAO();
    
    public boolean crear(Plaga p) {
        for(Plaga i:leerTodos()){
            if(i.getNombre().equals(p.getNombre())){
                return false;
            }
        }
        return validar(p) && dao.create(p);
    }
    
    public boolean eliminar(Plaga p) {
        return dao.delete(p.getId());
    }
    
    public void actualizar(Plaga p) {
        if (validar(p)) {
            dao.update(p);
        }
    }
    
    public Plaga leer(long id) {
        Plaga p = dao.read(id);
        return p;
    }
    
    public List<Plaga> leerTodos() {
        return dao.readAll();
    }
    
    private boolean validar(Plaga p) {        
        if (p.getNombre() == null
                || p.getNombre().length() < 3
                || p.getId() < 0
                || p.getMaxima_valoracion() < 0) {
            return false;
        }
        if (p.getRegistros() == null) {
            p.setRegistros(new ArrayList<>());            
        }
        return true;
    }
}
