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
import modelo.Plaga;

/**
 *
 * @author JohnFredy
 */
public class PlagaDAO {
    
    EntityManagerFactory emf = EntityManagerFactorySingleton.getEntityManagerFactory();

    public void create(Plaga p) {

        if (read(p.getId()) == null) {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            try {
                em.persist(p);
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            } finally {
                em.close();
            }
        }
    }

    public Plaga read(long id) {

        EntityManager em = emf.createEntityManager();
        Plaga r = null;
        try {
            r = (Plaga) em.createQuery("SELECT p FROM Plaga p WHERE p.id = :id").setParameter("id", id).getSingleResult();
        } catch (NonUniqueResultException n) {
            r = (Plaga) em.createQuery("SELECT p FROM Plaga p WHERE p.id = :id").setParameter("id", id).getResultList().get(0);
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return r;
    }

    private Plaga readById(long id) {

        EntityManager em = emf.createEntityManager();
        Plaga r = null;
        try {
            r = (Plaga) em.createQuery("SELECT p FROM Plaga p WHERE p.id = :id").setParameter("id", id).getSingleResult();
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
            r = (ArrayList) em.createQuery("SELECT p FROM Plaga p",
                    Plaga.class).getResultList();
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return r;
    }


    public void update(Plaga i) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Plaga p = read(i.getId());
        try {
            if (p == null) {
                p = readById(i.getId());
            }
            if (p != null) {
                p.setMaxima_valoracion(i.getMaxima_valoracion());
                p.setRegistros(i.getRegistros());               
                em.merge(p);
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
        Plaga r = read(id);
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
