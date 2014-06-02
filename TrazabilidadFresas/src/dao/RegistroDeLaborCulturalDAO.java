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
import modelo.RegistroDeLaborCultural;

/**
 *
 * @author JohnFredy
 */
public class RegistroDeLaborCulturalDAO {
    
    EntityManagerFactory emf = EntityManagerFactorySingleton.getEntityManagerFactory();

    public void create(RegistroDeLaborCultural rc) {

        if (read(rc.getId()) == null) {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            try {
                em.persist(rc);
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            } finally {
                em.close();
            }
        }
    }

    public RegistroDeLaborCultural read(long id) {

        EntityManager em = emf.createEntityManager();
        RegistroDeLaborCultural r = null;
        try {
            r = (RegistroDeLaborCultural) em.createQuery("SELECT rc FROM RegistroDeLaborCultural rc WHERE rc.id = :id").setParameter("id", id).getSingleResult();
        } catch (NonUniqueResultException n) {
            r = (RegistroDeLaborCultural) em.createQuery("SELECT rc FROM RegistroDeLaborCultural rc WHERE rc.id = :id").setParameter("id", id).getResultList().get(0);
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return r;
    }

    private RegistroDeLaborCultural readById(long id) {

        EntityManager em = emf.createEntityManager();
        RegistroDeLaborCultural r = null;
        try {
            r = (RegistroDeLaborCultural) em.createQuery("SELECT rc FROM RegistroDeLaborCultural rc WHERE rc.id = :id").setParameter("id", id).getSingleResult();
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
            r = (ArrayList) em.createQuery("SELECT rc FROM RegistroDeLaborCultural rp",
                    RegistroDeLaborCultural.class).getResultList();
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return r;
    }


    public void update(RegistroDeLaborCultural i) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        RegistroDeLaborCultural rc = read(i.getId());
        try {
            if (rc == null) {
                rc = readById(i.getId());
            }
            if (rc != null) {
                rc.setFecha(i.getFecha());
                rc.setFresicultor(i.getFresicultor());
                rc.setLaborCultural(i.getLaborCultural());
                rc.setObservaciones(i.getObservaciones());
                em.merge(rc);
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
        RegistroDeLaborCultural r = read(id);
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
