/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import dao.RegistroDeMonitoreoDePlagasDAO;
import java.util.List;
import modelo.RegistroDeMonitoreoDePlagas;

/**
 *
 * @author JohnFredy
 */
public class RegistroDeMonitoreoDePlagasControl {
    
    RegistroDeMonitoreoDePlagasDAO dao = new RegistroDeMonitoreoDePlagasDAO();
    
    public boolean crear(RegistroDeMonitoreoDePlagas r) {
        return validar(r) && dao.create(r);
    }
    
    public boolean eliminar(RegistroDeMonitoreoDePlagas r) {
        return dao.delete(r.getId());
    }
    
    public void actualizar(RegistroDeMonitoreoDePlagas r) {
        if (validar(r)) {
            dao.update(r);
        }
    }
    
    public RegistroDeMonitoreoDePlagas leer(long id) {
        RegistroDeMonitoreoDePlagas r = dao.read(id);
        if (r == null) {
            for (RegistroDeMonitoreoDePlagas i : leerTodos()) {
                if (i.getId() == id) {
                    r = i;
                    break;
                }
            }
        }
        return r;
    }
    
    public List<RegistroDeMonitoreoDePlagas> leerTodos() {
        return dao.readAll();
    }
    
    private boolean validar(RegistroDeMonitoreoDePlagas r) {        
        if (r.getMonitoreoDePlagas() == null
                || r.getValoracion()< 0 //no se si valorizacion puede ser menor que cero
                || r.getId() < 0
                || r.getPlaga() == null) {
            return false;
        }
        return true;
    }
}
