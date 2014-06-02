/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import dao.AplicacionFitosanitariaDAO;
import java.util.List;
import modelo.AplicacionFitosanitaria;

/**
 *
 * @author fredy
 */
public class AplicacionFitosanitariaControl {
 
    AplicacionFitosanitariaDAO dao = new AplicacionFitosanitariaDAO();
    
    public boolean crear(AplicacionFitosanitaria f) {
        return validar(f) && dao.create(f);
    }

    public boolean eliminar(AplicacionFitosanitaria f) {
        return dao.delete(f.getId());
    }

    public void actualizar(AplicacionFitosanitaria f) {
        if (validar(f)) {
            dao.update(f);
        }
    }
    
    public AplicacionFitosanitaria leer(long id){
        return dao.read(id);
    }

    public List<AplicacionFitosanitaria> leerTodos() {
        return dao.readAll();
    }

    private boolean validar(AplicacionFitosanitaria f) {
        return true;
    }
}
