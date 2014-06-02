/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import dao.ProductoFitosanitarioDAO;
import java.util.ArrayList;
import java.util.List;
import modelo.ProductoFitosanitario;

/**
 *
 * @author JohnFredy
 */
public class ProductoFitosanitarioControl {
    
    ProductoFitosanitarioDAO dao = new ProductoFitosanitarioDAO();
    
    public boolean crear(ProductoFitosanitario p) {
        return validar(p) && dao.create(p);
    }
    
    public boolean eliminar(ProductoFitosanitario p) {
        return dao.delete(p.getId());
    }
    
    public void actualizar(ProductoFitosanitario p) {
        if (validar(p)) {
            dao.update(p);
        }
    }
    
    public ProductoFitosanitario leer(long id) {
        ProductoFitosanitario p = dao.read(id);
        if (p == null) {
            for (ProductoFitosanitario i : leerTodos()) {
                if (i.getId() == id) {
                    p = i;
                    break;
                }
            }
        }
        return p;
    }
    
    public List<ProductoFitosanitario> leerTodos() {
        return dao.readAll();
    }
    
    private boolean validar(ProductoFitosanitario p) {        
        if (p.getNombre()== null
                || p.getId() < 0
                || p.getIngrediente_activo()== null) {
            return false;
        }
        if (p.getAplicaciones() == null) {
            p.setAplicaciones(new ArrayList<>());            
        }
        if (p.getInventario() == null) {
            p.setInventario(new ArrayList<>());            
        }
        return true;
    }
}
