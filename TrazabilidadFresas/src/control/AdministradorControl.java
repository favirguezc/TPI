/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.AdministradorDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Administrador;

/**
 *
 * @author fredy
 */
public class AdministradorControl {

    AdministradorDAO dao = new AdministradorDAO();

    public boolean crear(Administrador f) {
        return validar(f) && dao.create(f);
    }

    public boolean eliminar(Administrador f) {
        return dao.delete(f.getId());
    }

    public void actualizar(Administrador f) {
        if (validar(f)) {
            dao.update(f);
        }
    }

    public Administrador leer(long id) {
        Administrador f = dao.read(id);
        if (f == null) {
            for (Administrador i : leerTodos()) {
                if (i.getCedula() == id) {
                    f = i;
                    break;
                }
            }
        }
        return f;
    }

    public List<Administrador> leerTodos() {
        return dao.readAll();
    }

    private boolean validar(Administrador f) {
        if (f == null
                || f.getApellidos() == null
                || f.getApellidos().length() < 3
                || f.getCedula() < 0
                || f.getNombres() == null
                || f.getNombres().length() < 3
                || f.getFechadeNacimiento() == null
                || f.getFechadeNacimiento().after(new Date())
                || f.getClave() == null
                || f.getClave().length() < 3) {
            return false;
        }
        if (f.getAplicaciones() == null) {
            f.setAplicaciones(new ArrayList<>());
        }
        return true;
    }
}
