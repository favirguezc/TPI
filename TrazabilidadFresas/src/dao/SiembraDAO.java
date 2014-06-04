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
import modelo.Siembra;

/**
 *
 * @author JohnFredy
 */
public class SiembraDAO {
    
    EntityManagerFactory emf = EntityManagerFactorySingleton.getEntityManagerFactory();

    public boolean create(Siembra s) {

        if (read(s.getId()) == null) {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            boolean ret = false;
            try {
                em.persist(s);
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

    public Siembra read(long id) {

        EntityManager em = emf.createEntityManager();
        Siembra r = null;
        try {
            r = (Siembra) em.createQuery("SELECT s FROM Siembra s WHERE s.id = :id").setParameter("id", id).getSingleResult();
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
            r = (ArrayList) em.createQuery("SELECT s FROM Siembra s",
                    Siembra.class).getResultList();
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return r;
    }


    public void update(Siembra i) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Siembra s = read(i.getId());
        try {
            if (s != null) {
                s.setCosechas(i.getCosechas());
                s.setFecha(i.getFecha());
                s.setParcela(i.getParcela());
                s.setAplicaciones(i.getAplicaciones());
                em.merge(s);
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
        Siembra r = read(id);
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
