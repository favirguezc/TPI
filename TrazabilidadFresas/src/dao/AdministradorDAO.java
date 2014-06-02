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
import modelo.Administrador;

/**
 *
 * @author fredy
 */
public class AdministradorDAO {
    
    EntityManagerFactory emf = EntityManagerFactorySingleton.getEntityManagerFactory();
    
    public void create(Administrador f) {

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

    public Administrador read(long cedula) {

        EntityManager em = emf.createEntityManager();
        Administrador r = null;
        try {
            r = (Administrador) em.createQuery("SELECT f FROM Administrador f WHERE f.cedula = :cedula").setParameter("cedula", cedula).getSingleResult();
        } catch (NonUniqueResultException n) {
            r = (Administrador) em.createQuery("SELECT f FROM Administrador f WHERE f.cedula = :cedula").setParameter("cedula", cedula).getResultList().get(0);
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return r;
    }

    private Administrador readById(long id) {

        EntityManager em = emf.createEntityManager();
        Administrador r = null;
        try {
            r = (Administrador) em.createQuery("SELECT f FROM Administrador f WHERE f.id = :id").setParameter("id", id).getSingleResult();
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
            r = (ArrayList) em.createQuery("SELECT f FROM Administrador f",
                    Administrador.class).getResultList();
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return r;
    }


    public void update(Administrador i) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Administrador f = read(i.getCedula());
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
        Administrador r = read(cedula);
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
