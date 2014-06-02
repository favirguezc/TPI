/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.CosechaDAO;
import java.util.List;
import modelo.Cosecha;

/**
 *
 * @author fredy
 */
public class CosechaControl {

    CosechaDAO dao = new CosechaDAO();

    public boolean crear(Cosecha f) {
        return validar(f) && dao.create(f);
    }

    public boolean eliminar(Cosecha f) {
        return dao.delete(f.getId());
    }

    public void actualizar(Cosecha f) {
        if (validar(f)) {
            dao.update(f);
        }
    }

    public Cosecha leer(long id) {
        return dao.read(id);
    }

    public List<Cosecha> leerTodos() {
        return dao.readAll();
    }

    private boolean validar(Cosecha f) {
        if (f == null
                || f.getFresa() == null
                || f.getFresicultor() == null
                || f.getLote() == null
                || f.getSiembra() == null
                || f.getTipo() < 0
                || f.getCantidad() < 0) {
            return false;
        }
        return true;
    }
}
