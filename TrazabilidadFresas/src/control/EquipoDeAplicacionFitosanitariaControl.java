/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.EquipoDeAplicacionFitosanitariaDAO;
import java.util.List;
import modelo.EquipoDeAplicacionFitosanitaria;

/**
 *
 * @author fredy
 */
public class EquipoDeAplicacionFitosanitariaControl {

    EquipoDeAplicacionFitosanitariaDAO dao = new EquipoDeAplicacionFitosanitariaDAO();

    public boolean crear(EquipoDeAplicacionFitosanitaria f) {
        return validar(f) && dao.create(f);
    }

    public boolean eliminar(EquipoDeAplicacionFitosanitaria f) {
        return dao.delete(f.getId());
    }

    public void actualizar(EquipoDeAplicacionFitosanitaria f) {
        if (validar(f)) {
            dao.update(f);
        }
    }

    public EquipoDeAplicacionFitosanitaria leer(long id) {
        return dao.read(id);
    }

    public List<EquipoDeAplicacionFitosanitaria> leerTodos() {
        return dao.readAll();
    }

    private boolean validar(EquipoDeAplicacionFitosanitaria f) {
        return true;
    }
}
