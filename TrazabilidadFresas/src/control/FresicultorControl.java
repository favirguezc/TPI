/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.FresicultorDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Fresicultor;

/**
 *
 * @author fredy
 */
public class FresicultorControl {

    FresicultorDAO dao = new FresicultorDAO();

    public boolean crear(Fresicultor f) {
        return validar(f) && dao.create(f);
    }

    public boolean eliminar(Fresicultor f) {
        return dao.delete(f.getId());
    }

    public void actualizar(Fresicultor f) {
        if (validar(f)) {
            dao.update(f);
        }
    }

    public Fresicultor leer(long id) {
        Fresicultor f = dao.read(id);
        if (f == null) {
            for (Fresicultor i : leerTodos()) {
                if (i.getCedula() == id) {
                    f = i;
                    break;
                }
            }
        }
        return f;
    }

    public List<Fresicultor> leerTodos() {
        return dao.readAll();
    }

    private boolean validar(Fresicultor f) {
        if (f == null
                || f.getApellidos() == null
                || f.getApellidos().length() < 3
                || f.getCedula() < 0
                || f.getNombres() == null
                || f.getNombres().length() < 3
                || f.getFechadeNacimiento() == null
                || f.getFechadeNacimiento().after(new Date())) {
            return false;
        }
        if (f.getAplicaciones() == null) {
            f.setAplicaciones(new ArrayList<>());
        }
        if (f.getCosechas() == null) {
            f.setCosechas(new ArrayList<>());
        }
        return true;
    }
}
