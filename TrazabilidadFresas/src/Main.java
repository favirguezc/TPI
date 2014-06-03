
import control.*;
import java.util.Date;
import modelo.*;

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
        
//        MonitoreoDePlagas mp = new MonitoreoDePlagasControl().leer(2);
        Plaga p = new PlagaControl().leer(1);
//        RegistroDeMonitoreoDePlagas rmp = new RegistroDeMonitoreoDePlagas();
//        rmp.setMonitoreoDePlagas(mp);
//        rmp.setPlaga(p);
//        rmp.setValoracion(0);
//        System.out.println(new RegistroDeMonitoreoDePlagasControl().crear(rmp));
        new PlagaControl().eliminar(p);
        
    }
}
