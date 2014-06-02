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
import modelo.Cosecha;

/**
 *
 * @author fredy
 */
public class CosechaDAO {
    
    EntityManagerFactory emf = EntityManagerFactorySingleton.getEntityManagerFactory();
    
    public void create(Cosecha a) {

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

    public Cosecha read(long id) {

        EntityManager em = emf.createEntityManager();
        Cosecha r = null;
        try {
            r = (Cosecha) em.createQuery("SELECT f FROM Cosecha f WHERE f.id = :id").setParameter("id", id).getSingleResult();
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
            r = (ArrayList) em.createQuery("SELECT f FROM Cosecha f",
                    Cosecha.class).getResultList();
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return r;
    }


    public void update(Cosecha i) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Cosecha f = read(i.getId());
        try {
            if (f != null) {
                f.setCantidad(i.getCantidad());
                f.setFresa(i.getFresa());
                f.setFresicultor(i.getFresicultor());
                f.setLote(i.getLote());
                f.setSiembra(i.getSiembra());
                f.setTipo(i.getTipo());                
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
        Cosecha r = read(id);
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
