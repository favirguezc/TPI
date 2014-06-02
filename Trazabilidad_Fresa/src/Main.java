
import dao.FresicultorDAO;
import java.util.Date;
import modelo.Fresicultor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fredy
 */
public class Main {
    public static void main(String[] args){
        
//        Fresicultor f = new Fresicultor();
//        f.setNombres("Fredy");
//        f.setApellidos("Virguez");
//        f.setCedula(1020794235);
//        f.setFecha_de_nacimiento(new Date(1994, 7, 2));
//        new FresicultorDAO().create(f);
        //new FresicultorDAO().delete(1020794235);
        System.out.println(new FresicultorDAO().read(1020794235).getNombres());
    }
}
