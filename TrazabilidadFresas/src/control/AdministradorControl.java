/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import dao.AdministradorDAO;
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
    
    public Administrador leer(long id){
        Administrador f = dao.read(id);
        if(f==null){
            for(Administrador i:leerTodos()){
                if(i.getCedula() == id){
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
        return true;
    }
}
