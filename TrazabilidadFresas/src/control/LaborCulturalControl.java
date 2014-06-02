/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.LaborCulturalDAO;
import java.util.List;
import modelo.LaborCultural;

/**
 *
 * @author fredy
 */
public class LaborCulturalControl {

    LaborCulturalDAO dao = new LaborCulturalDAO();

    public boolean crear(LaborCultural f) {
        return validar(f) && dao.create(f);
    }

    public boolean eliminar(LaborCultural f) {
        return dao.delete(f.getId());
    }

    public void actualizar(LaborCultural f) {
        if (validar(f)) {
            dao.update(f);
        }
    }

    public LaborCultural leer(long id) {
        return dao.read(id);
    }

    public List<LaborCultural> leerTodos() {
        return dao.readAll();
    }

    private boolean validar(LaborCultural f) {
        if (f == null
                || f.getNombre() == null
                || f.getNombre().length() < 5) {
            return false;
        }
        if (f.getDescripcion() == null) {
            f.setDescripcion("");
        }
        return true;
    }
}
