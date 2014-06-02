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
import javax.persistence.Persistence;
import modelo.Fresicultor;

/**
 *
 * @author fredy
 */
public class FresicultorDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrazabilidadFresaPU");

    public void create(Fresicultor f) {

        if (read(f.getCedula()) == null) {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            try {
                em.persist(f);
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            } finally {
                em.close();
            }
        }
    }

    public Fresicultor read(long cedula) {

        EntityManager em = emf.createEntityManager();
        Fresicultor r = null;
        try {
            r = (Fresicultor) em.createQuery("SELECT f FROM Fresicultor f WHERE f.cedula = :cedula").setParameter("cedula", cedula).getSingleResult();
        } catch (NonUniqueResultException n) {
            r = (Fresicultor) em.createQuery("SELECT f FROM Fresicultor f WHERE f.cedula = :cedula").setParameter("cedula", cedula).getResultList().get(0);
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return r;
    }

    private Fresicultor readById(long id) {

        EntityManager em = emf.createEntityManager();
        Fresicultor r = null;
        try {
            r = (Fresicultor) em.createQuery("SELECT f FROM Fresicultor f WHERE f.id = :id").setParameter("id", id).getSingleResult();
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
            r = (ArrayList) em.createQuery("SELECT f FROM Fresicultor f",
                    Fresicultor.class).getResultList();
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return r;
    }


    public void update(Fresicultor i) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Fresicultor f = read(i.getCedula());
        try {
            if (f == null) {
                f = readById(i.getId());
            }
            if (f != null) {
                f.setNombres(i.getNombres());
                f.setApellidos(i.getApellidos());
                f.setFecha_de_nacimiento(i.getFecha_de_nacimiento());
                em.merge(f);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void delete(long cedula) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Fresicultor r = read(cedula);
        if (r != null) {
            try {
                r = em.merge(r);
                em.remove(r);
                em.getTransaction().commit();
            } catch (Exception e) {
                System.out.println("Paila");
            } finally {
                em.close();
            }
        }
    }
}
