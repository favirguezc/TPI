/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author fredy
 */
public class EntityManagerFactorySingleton {
    
    private static EntityManagerFactory emf;

    private EntityManagerFactorySingleton() {
    }
    
    public static EntityManagerFactory getEntityManagerFactory(){
        if(emf == null){
            emf  = Persistence.createEntityManagerFactory("TrazabilidadFresaPU");
        }
        return emf;
    }
    
}
