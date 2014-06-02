/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.FresicultorDAO;
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
    
    public Fresicultor leer(long id){
        Fresicultor f = dao.read(id);
        if(f==null){
            for(Fresicultor i:leerTodos()){
                if(i.getCedula() == id){
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
        return true;
    }
}
