/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import dao.SiembraDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Siembra;

/**
 *
 * @author JohnFredy
 */
public class SiembraControl {
    
    SiembraDAO dao = new SiembraDAO();
    
    public boolean crear(Siembra s) {
        return validar(s) && dao.create(s);
    }
    
    public boolean eliminar(Siembra s) {
        return dao.delete(s.getId());
    }
    
    public void actualizar(Siembra s) {
        if (validar(s)) {
            dao.update(s);
        }
    }
    
    public Siembra leer(long id) {
        Siembra s = dao.read(id);
        return s;
    }
    
    public List<Siembra> leerTodos() {
        return dao.readAll();
    }
    
    private boolean validar(Siembra s) {        
        if (s.getParcela() == null
                || s.getId() < 0
                || s.getFecha().after(new Date())) {
            return false;
        }
        if (s.getAplicaciones() == null) {
            s.setAplicaciones(new ArrayList<>());            
        }
        if (s.getCosechas() == null) {
            s.setCosechas(new ArrayList<>());            
        }
        return true;
    }
}
