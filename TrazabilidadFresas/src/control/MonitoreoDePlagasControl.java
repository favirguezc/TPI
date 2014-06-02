/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import dao.MonitoreoDePlagasDAO;
import java.util.ArrayList;
import java.util.List;
import modelo.MonitoreoDePlagas;

/**
 *
 * @author JohnFredy
 */
public class MonitoreoDePlagasControl {
    
    MonitoreoDePlagasDAO dao = new MonitoreoDePlagasDAO();
    
    public boolean crear(MonitoreoDePlagas m) {
        return validar(m) && dao.create(m);
    }
    
    public boolean eliminar(MonitoreoDePlagas m) {
        return dao.delete(m.getId());
    }
    
    public void actualizar(MonitoreoDePlagas m) {
        if (validar(m)) {
            dao.update(m);
        }
    }
    
    public MonitoreoDePlagas leer(long id) {
        MonitoreoDePlagas m = dao.read(id);
        if (m == null) {
            for (MonitoreoDePlagas i : leerTodos()) {
                if (i.getId() == id) {
                    m = i;
                    break;
                }
            }
        }
        return m;
    }
    
    public List<MonitoreoDePlagas> leerTodos() {
        return dao.readAll();
    }
    
    private boolean validar(MonitoreoDePlagas m) {        
        if (m.getId() < 0
                || m.getNumero_de_planta() < 0
                || m.getFecha() == null) {
            return false;
        }
        if (m.getRegistros() == null) {
            m.setRegistros(new ArrayList<>());            
        }
        return true;
    }
}
