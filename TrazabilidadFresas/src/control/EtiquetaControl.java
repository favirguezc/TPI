/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.EtiquetaDAO;
import java.util.List;
import modelo.Etiqueta;

/**
 *
 * @author fredy
 */
public class EtiquetaControl {

    EtiquetaDAO dao = new EtiquetaDAO();

    public boolean crear(Etiqueta f) {
        return validar(f) && dao.create(f);
    }

    public boolean eliminar(Etiqueta f) {
        return dao.delete(f.getId());
    }

    public void actualizar(Etiqueta f) {
        if (validar(f)) {
            dao.update(f);
        }
    }

    public Etiqueta leer(long id) {
        return dao.read(id);
    }

    public List<Etiqueta> leerTodos() {
        return dao.readAll();
    }

    private boolean validar(Etiqueta f) {
        if (f == null
                || f.getLote() == null) {
            return false;
        }
        return true;
    }
}
