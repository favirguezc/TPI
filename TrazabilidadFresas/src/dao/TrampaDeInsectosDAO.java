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
import javax.persistence.NonUniqueResultException;
import modelo.TrampaDeInsectos;


/**
 *
 * @author JohnFredy
 */
public class TrampaDeInsectosDAO {
    
    EntityManagerFactory emf = EntityManagerFactorySingleton.getEntityManagerFactory();

    public boolean create(TrampaDeInsectos t) {

        if (read(t.getId()) == null) {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            boolean ret = false;
            try {
                em.persist(t);
                em.getTransaction().commit();
                ret = true;
            } catch (Exception e) {
                em.getTransaction().rollback();
            } finally {
                em.close();
                return ret;
            }
        }
        return false;
    }

    public TrampaDeInsectos read(long id) {

        EntityManager em = emf.createEntityManager();
        TrampaDeInsectos r = null;
        try {
            r = (TrampaDeInsectos) em.createQuery("SELECT t FROM TrampaDeInsectos t WHERE t.id = :id").setParameter("id", id).getSingleResult();
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
            r = (ArrayList) em.createQuery("SELECT t FROM TrampaDeInsectos t",
                    TrampaDeInsectos.class).getResultList();
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return r;
    }


    public void update(TrampaDeInsectos i) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TrampaDeInsectos r = read(i.getId());
        try {
            if (r != null) {
                r.setNombre(i.getNombre());
                r.setDescripcion(i.getDescripcion());
                r.setRegistros(i.getRegistros());
                em.merge(r);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public boolean delete(long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        TrampaDeInsectos r = read(id);
        if (r != null) {
            try {
                r = em.merge(r);
                em.remove(r);
                em.getTransaction().commit();
                ret = true;
            } catch (Exception e) {
            } finally {
                em.close();
                return ret;
            }
        }
        return ret;
    }
}
