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
import modelo.RegistroDeMonitoreoDePlagas;

/**
 *
 * @author JohnFredy
 */
public class RegistroDeMonitoreoDePlagasDAO {
    
    EntityManagerFactory emf = EntityManagerFactorySingleton.getEntityManagerFactory();

    public boolean create(RegistroDeMonitoreoDePlagas rp) {

        if (read(rp.getId()) == null) {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            boolean ret = false;
            try {
                em.persist(rp);
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

    public RegistroDeMonitoreoDePlagas read(long id) {

        EntityManager em = emf.createEntityManager();
        RegistroDeMonitoreoDePlagas r = null;
        try {
            r = (RegistroDeMonitoreoDePlagas) em.createQuery("SELECT rp FROM RegistroDeMonitoreoDePlagas rp WHERE rp.id = :id").setParameter("id", id).getSingleResult();
        } catch (NonUniqueResultException n) {
            r = (RegistroDeMonitoreoDePlagas) em.createQuery("SELECT rp FROM RegistroDeMonitoreoDePlagas rp WHERE rp.id = :id").setParameter("id", id).getResultList().get(0);
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return r;
    }

    private RegistroDeMonitoreoDePlagas readById(long id) {

        EntityManager em = emf.createEntityManager();
        RegistroDeMonitoreoDePlagas r = null;
        try {
            r = (RegistroDeMonitoreoDePlagas) em.createQuery("SELECT rp FROM RegistroDeMonitoreoDePlagas rp WHERE rp.id = :id").setParameter("id", id).getSingleResult();
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
            r = (ArrayList) em.createQuery("SELECT rp FROM RegistroDeMonitoreoDePlagas rp",
                    RegistroDeMonitoreoDePlagas.class).getResultList();
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return r;
    }


    public void update(RegistroDeMonitoreoDePlagas i) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        RegistroDeMonitoreoDePlagas rp = read(i.getId());
        try {
            if (rp == null) {
                rp = readById(i.getId());
            }
            if (rp != null) {
                rp.setMonitoreoDePlagas(i.getMonitoreoDePlagas());
                rp.setPlaga(i.getPlaga());
                rp.setValoracion(i.getValoracion());
                
                em.merge(rp);
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
        RegistroDeMonitoreoDePlagas r = read(id);
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
