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

    public void create(Parcela p) {

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

    public Parcela read(long id) {

        EntityManager em = emf.createEntityManager();
        Parcela r = null;
        try {
            r = (Parcela) em.createQuery("SELECT p FROM Parcela p WHERE p.id = :id").setParameter("id", id).getSingleResult();
        } catch (NonUniqueResultException n) {
            r = (Parcela) em.createQuery("SELECT p FROM Parcela p WHERE p.id = :id").setParameter("id", id).getResultList().get(0);
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return r;
    }

    private Parcela readById(long id) {

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
            if (p == null) {
                p = readById(i.getId());
            }
            if (p != null) {
                p.setActiva(i.isActiva());
                p.setArea(i.getArea());
                p.setSiembras(i.getSiembras());
                p.setTipo_de_suelo(i.getTipo_de_suelo());
                p.setUbicacion_en_la_finca(i.getUbicacion_en_la_finca());
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
        Parcela r = read(id);
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
