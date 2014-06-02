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
        if (read(f.getId()) == null) {
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

    public Administrador read(long id) {

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
        Administrador f = read(i.getId());
        try {
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

    public boolean delete(long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Administrador r = read(id);
        boolean ok = false; 
        if (r != null) {
            try {
                r = em.merge(r);
                em.remove(r);
                em.getTransaction().commit();
                ok = true;
            } catch (Exception e) {
                ok = false;
            } finally {
                em.close();
            }
        }
        return ok;
    }
}
