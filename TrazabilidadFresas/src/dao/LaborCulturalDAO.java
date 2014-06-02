/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.LaborCultural;

/**
 *
 * @author fredy
 */
public class LaborCulturalDAO {
    EntityManagerFactory emf = EntityManagerFactorySingleton.getEntityManagerFactory();
    
    public void create(LaborCultural a) {

        if (read(a.getId()) == null) {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            try {
                em.persist(a);
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            } finally {
                em.close();
            }
        }
    }

    public LaborCultural read(long id) {

        EntityManager em = emf.createEntityManager();
        LaborCultural r = null;
        try {
            r = (LaborCultural) em.createQuery("SELECT f FROM LaborCultural f WHERE f.id = :id").setParameter("id", id).getSingleResult();
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return r;
    }

    public List readAll() {

        EntityManager em = emf.createEntityManager();
        ArrayList r = new ArrayList();
        try {
            r = (ArrayList) em.createQuery("SELECT f FROM LaborCultural f",
                    LaborCultural.class).getResultList();
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return r;
    }


    public void update(LaborCultural i) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        LaborCultural f = read(i.getId());
        try {
            if (f != null) {
                f.setDescripcion(i.getDescripcion());
                f.setNombre(i.getNombre());
                f.setRegistros(i.getRegistros());
                em.merge(f);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void delete(long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        LaborCultural r = read(id);
        if (r != null) {
            try {
                r = em.merge(r);
                em.remove(r);
                em.getTransaction().commit();
            } catch (Exception e) {
            } finally {
                em.close();
            }
        }
    }
}
