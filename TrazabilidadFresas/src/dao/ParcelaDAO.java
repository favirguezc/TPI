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
import modelo.Parcela;

/**
 *
 * @author JohnFredy
 */
public class ParcelaDAO {
    
    EntityManagerFactory emf = EntityManagerFactorySingleton.getEntityManagerFactory();

    public boolean create(Parcela p) {

        if (read(p.getId()) == null) {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            boolean ret = false;
            try {
                em.persist(p);
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

    public Parcela read(long id) {

        EntityManager em = emf.createEntityManager();
        Parcela r = null;
        try {
            r = (Parcela) em.createQuery("SELECT p FROM Parcela p WHERE p.id = :id").setParameter("id", id).getSingleResult();
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
            r = (ArrayList) em.createQuery("SELECT p FROM Parcela p",
                    Parcela.class).getResultList();
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return r;
    }


    public void update(Parcela i) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Parcela p = read(i.getId());
        try {
            if (p != null) {
                p.setActiva(i.isActiva());
                p.setArea(i.getArea());
                p.setSiembras(i.getSiembras());
                p.setTipoDeSuelo(i.getTipoDeSuelo());
                p.setUbicacionEnLaFinca(i.getUbicacionEnLaFinca());
                em.merge(p);
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
        Parcela r = read(id);
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
