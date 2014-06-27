/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.InventarioDeProductosFitosanitariosDAO;
import java.util.Date;
import java.util.List;
import modelo.InventarioDeProductosFitosanitarios;

/**
 *
 * @author fredy
 */
public class InventarioDeProductosFitosanitariosControl {

    InventarioDeProductosFitosanitariosDAO dao = new InventarioDeProductosFitosanitariosDAO();

    public boolean crear(InventarioDeProductosFitosanitarios f) {
        return validar(f) && dao.create(f);
    }

    public boolean eliminar(InventarioDeProductosFitosanitarios f) {
        return dao.delete(f.getId());
    }

    public void actualizar(InventarioDeProductosFitosanitarios f) {
        if (validar(f)) {
            dao.update(f);
        }
    }

    public InventarioDeProductosFitosanitarios leer(long id) {
        return dao.read(id);
    }

    public List<InventarioDeProductosFitosanitarios> leerTodos() {
        return dao.readAll();
    }

    private boolean validar(InventarioDeProductosFitosanitarios f) {
        if (f == null
                || f.getCantidad() <= 0
                || f.getProductoFitosanitario() == null
                || f.getFechaDeCompra().after(new Date())) {
            return false;
        }
        return true;
    }
}
