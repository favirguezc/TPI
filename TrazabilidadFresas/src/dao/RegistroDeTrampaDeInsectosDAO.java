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
import modelo.RegistroDeTrampaDeInsectos;


/**
 *
 * @author JohnFredy
 */
public class RegistroDeTrampaDeInsectosDAO {
    
    EntityManagerFactory emf = EntityManagerFactorySingleton.getEntityManagerFactory();

    public void create(RegistroDeTrampaDeInsectos ri) {

        if (read(ri.getId()) == null) {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            try {
                em.persist(ri);
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            } finally {
                em.close();
            }
        }
    }

    public RegistroDeTrampaDeInsectos read(long id) {

        EntityManager em = emf.createEntityManager();
        RegistroDeTrampaDeInsectos r = null;
        try {
            r = (RegistroDeTrampaDeInsectos) em.createQuery("SELECT ri FROM RegistroDeTrampaDeInsectos ri WHERE ri.id = :id").setParameter("id", id).getSingleResult();
        } catch (NonUniqueResultException n) {
            r = (RegistroDeTrampaDeInsectos) em.createQuery("SELECT ri FROM RegistroDeTrampaDeInsectos ri WHERE ri.id = :id").setParameter("id", id).getResultList().get(0);
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return r;
    }

    private RegistroDeTrampaDeInsectos readById(long id) {

        EntityManager em = emf.createEntityManager();
        RegistroDeTrampaDeInsectos r = null;
        try {
            r = (RegistroDeTrampaDeInsectos) em.createQuery("SELECT ri FROM RegistroDeTrampaDeInsectos ri WHERE ri.id = :id").setParameter("id", id).getSingleResult();
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
            r = (ArrayList) em.createQuery("SELECT ri FROM RegistroDeTrampaDeInsectos ri",
                    RegistroDeTrampaDeInsectos.class).getResultList();
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return r;
    }


    public void update(RegistroDeTrampaDeInsectos i) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        RegistroDeTrampaDeInsectos ri = read(i.getId());
        try {
            if (ri == null) {
                ri = readById(i.getId());
            }
            if (ri != null) {
                ri.setNumero_de_individuos(i.getNumero_de_individuos());
                ri.setFecha(i.getFecha());
                ri.setEspecies_encontradas(i.getEspecies_encontradas());
                ri.setObservaciones(i.getObservaciones());
                ri.setPegante(i.isPegante());
                ri.setTrampaDeInsectos(i.getTrampaDeInsectos());
                em.merge(ri);
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
        RegistroDeTrampaDeInsectos r = read(id);
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