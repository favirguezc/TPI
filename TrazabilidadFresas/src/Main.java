
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
        
        Plaga p = new Plaga();
        p.setMaxima_valoracion(1);
        p.setNombre("Mildeo polvoso");
        new PlagaControl().crear(p);
    }
}
