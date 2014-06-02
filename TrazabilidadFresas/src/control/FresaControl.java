/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.FresaDAO;
import java.util.List;
import modelo.Fresa;

/**
 *
 * @author fredy
 */
public class FresaControl {

    FresaDAO dao = new FresaDAO();

    public boolean crear(Fresa f) {
        return validar(f) && dao.create(f);
    }

    public boolean eliminar(Fresa f) {
        return dao.delete(f.getId());
    }

    public void actualizar(Fresa f) {
        if (validar(f)) {
            dao.update(f);
        }
    }

    public Fresa leer(long id) {
        return dao.read(id);
    }

    public List<Fresa> leerTodos() {
        return dao.readAll();
    }

    private boolean validar(Fresa f) {
        return true;
    }
}
