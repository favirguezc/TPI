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
import modelo.MonitoreoDePlagas;

/**
 *
 * @author JohnFredy
 */
public class MonitoreoDePlagasDAO {
    
    EntityManagerFactory emf = EntityManagerFactorySingleton.getEntityManagerFactory();

    public boolean create(MonitoreoDePlagas m) {

        if (read(m.getId()) == null) {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            boolean ret = false;
            try {
                em.persist(m);
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

    public MonitoreoDePlagas read(long id) {

        EntityManager em = emf.createEntityManager();
        MonitoreoDePlagas r = null;
        try {
            r = (MonitoreoDePlagas) em.createQuery("SELECT m FROM MonitoreoDePlagas m WHERE m.id = :id").setParameter("id", id).getSingleResult();
        } catch (NonUniqueResultException n) {
            r = (MonitoreoDePlagas) em.createQuery("SELECT m FROM MonitoreoDePlagas m WHERE m.id = :id").setParameter("id", id).getResultList().get(0);
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return r;
    }

    private MonitoreoDePlagas readById(long id) {

        EntityManager em = emf.createEntityManager();
        MonitoreoDePlagas r = null;
        try {
            r = (MonitoreoDePlagas) em.createQuery("SELECT m FROM MonitoreoDePlagas m WHERE m.id = :id").setParameter("id", id).getSingleResult();
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
            r = (ArrayList) em.createQuery("SELECT m FROM MonitoreoDePlagas m",
                    MonitoreoDePlagas.class).getResultList();
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return r;
    }


    public void update(MonitoreoDePlagas i) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        MonitoreoDePlagas m = read(i.getId());
        try {
            if (m == null) {
                m = readById(i.getId());
            }
            if (m != null) {
                m.setFecha(i.getFecha());
                m.setNumero_de_planta(i.getNumero_de_planta());
                m.setRegistros(i.getRegistros());
                em.merge(m);
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
        MonitoreoDePlagas r = read(id);
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
