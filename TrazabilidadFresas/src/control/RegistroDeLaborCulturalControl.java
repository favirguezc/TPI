/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import dao.RegistroDeLaborCulturalDAO;
import java.util.List;
import modelo.RegistroDeLaborCultural;

/**
 *
 * @author JohnFredy
 */
public class RegistroDeLaborCulturalControl {
    
    RegistroDeLaborCulturalDAO dao = new RegistroDeLaborCulturalDAO();
    
    public boolean crear(RegistroDeLaborCultural r) {
        return validar(r) && dao.create(r);
    }
    
    public boolean eliminar(RegistroDeLaborCultural r) {
        return dao.delete(r.getId());
    }
    
    public void actualizar(RegistroDeLaborCultural r) {
        if (validar(r)) {
            dao.update(r);
        }
    }
    
    public RegistroDeLaborCultural leer(long id) {
        RegistroDeLaborCultural r = dao.read(id);
        if (r == null) {
            for (RegistroDeLaborCultural i : leerTodos()) {
                if (i.getId() == id) {
                    r = i;
                    break;
                }
            }
        }
        return r;
    }
    
    public List<RegistroDeLaborCultural> leerTodos() {
        return dao.readAll();
    }
    
    private boolean validar(RegistroDeLaborCultural r) {        
        if (r.getFecha() == null
                || r.getId() < 0
                || r.getFresicultor() == null
                || r.getLaborCultural() == null
                || r.getObservaciones() == null) {
            return false;
        }
        return true;
    }
}
