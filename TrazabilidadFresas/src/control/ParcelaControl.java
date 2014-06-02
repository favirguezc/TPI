/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import dao.ParcelaDAO;
import java.util.ArrayList;
import java.util.List;
import modelo.Parcela;

/**
 *
 * @author JohnFredy
 */
public class ParcelaControl {
    
    ParcelaDAO dao = new ParcelaDAO();
    
    public boolean crear(Parcela p) {
        return validar(p) && dao.create(p);
    }
    
    public boolean eliminar(Parcela p) {
        return dao.delete(p.getId());
    }
    
    public void actualizar(Parcela p) {
        if (validar(p)) {
            dao.update(p);
        }
    }
    
    public Parcela leer(long id) {
        Parcela p = dao.read(id);
        if (p == null) {
            for (Parcela i : leerTodos()) {
                if (i.getId() == id) {
                    p = i;
                    break;
                }
            }
        }
        return p;
    }
    
    public List<Parcela> leerTodos() {
        return dao.readAll();
    }
    
    private boolean validar(Parcela p) {        
        if (p.getId() < 0
                || p.getArea()< 0.0
                || p.getTipo_de_suelo() == null
                || p.getUbicacion_en_la_finca() == null) {
            return false;
        }
        if (p.getSiembras() == null) {
            p.setSiembras(new ArrayList<>());            
        }
        return true;
    }
}
