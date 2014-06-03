/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import dao.LoteDAO;
import java.util.ArrayList;
import java.util.List;
import modelo.Lote;

/**
 *
 * @author JohnFredy
 */
public class LoteControl {
    
    LoteDAO dao = new LoteDAO();
    
    public boolean crear(Lote l) {
        return validar(l) && dao.create(l);
    }
    
    public boolean eliminar(Lote l) {
        return dao.delete(l.getId());
    }
    
    public void actualizar(Lote l) {
        if (validar(l)) {
            dao.update(l);
        }
    }
    
    public Lote leer(long id) {
        Lote l = dao.read(id);
        return l;
    }
    
    public List<Lote> leerTodos() {
        return dao.readAll();
    }
    
    private boolean validar(Lote l) {        
        if (l.getId() < 0) {
            return false;
        }
        if (l.getCosechas() == null) {
            l.setCosechas(new ArrayList<>());            
        }
        if (l.getCosechas() == null) {
            l.setCosechas(new ArrayList<>());            
        }
        return true;
    }
}
