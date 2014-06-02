/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import dao.RegistroDeTrampaDeInsectosDAO;
import java.util.List;
import modelo.RegistroDeTrampaDeInsectos;

/**
 *
 * @author JohnFredy
 */
public class RegistroDeTrampaDeInsectosControl {
    
    RegistroDeTrampaDeInsectosDAO dao = new RegistroDeTrampaDeInsectosDAO();
    
    public boolean crear(RegistroDeTrampaDeInsectos r) {
        return validar(r) && dao.create(r);
    }
    
    public boolean eliminar(RegistroDeTrampaDeInsectos r) {
        return dao.delete(r.getId());
    }
    
    public void actualizar(RegistroDeTrampaDeInsectos r) {
        if (validar(r)) {
            dao.update(r);
        }
    }
    
    public RegistroDeTrampaDeInsectos leer(long id) {
        RegistroDeTrampaDeInsectos r = dao.read(id);
        if (r == null) {
            for (RegistroDeTrampaDeInsectos i : leerTodos()) {
                if (i.getId() == id) {
                    r = i;
                    break;
                }
            }
        }
        return r;
    }
    
    public List<RegistroDeTrampaDeInsectos> leerTodos() {
        return dao.readAll();
    }
    
    private boolean validar(RegistroDeTrampaDeInsectos r) {        
        if (r.getId() < 0
                || r.getEspecies_encontradas() < 0
                || r.getFecha()< 0
                || r.getNumero_de_individuos()< 0
                || r.getObservaciones() == null
                || r.getTrampaDeInsectos() == null) {
            return false;
        }
        return true;
    }
}
