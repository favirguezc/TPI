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
import modelo.ProductoFitosanitario;

/**
 *
 * @author JohnFredy
 */
public class ProductoFitosanitarioDAO {
    
    EntityManagerFactory emf = EntityManagerFactorySingleton.getEntityManagerFactory();

    public void create(ProductoFitosanitario pf) {

        if (read(pf.getId()) == null) {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            try {
                em.persist(pf);
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            } finally {
                em.close();
            }
        }
    }

    public ProductoFitosanitario read(long id) {

        EntityManager em = emf.createEntityManager();
        ProductoFitosanitario r = null;
        try {
            r = (ProductoFitosanitario) em.createQuery("SELECT pf FROM ProductoFitosanitario pf WHERE pf.id = :id").setParameter("id", id).getSingleResult();
        } catch (NonUniqueResultException n) {
            r = (ProductoFitosanitario) em.createQuery("SELECT pf FROM ProductoFitosanitario pf WHERE pf.id = :id").setParameter("id", id).getResultList().get(0);
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return r;
    }

    private ProductoFitosanitario readById(long id) {

        EntityManager em = emf.createEntityManager();
        ProductoFitosanitario r = null;
        try {
            r = (ProductoFitosanitario) em.createQuery("SELECT pf FROM ProductoFitosanitario pf WHERE pf.id = :id").setParameter("id", id).getSingleResult();
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
            r = (ArrayList) em.createQuery("SELECT pf FROM ProductoFitosanitario pf",
                    ProductoFitosanitario.class).getResultList();
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return r;
    }


    public void update(ProductoFitosanitario i) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        ProductoFitosanitario pf = read(i.getId());
        try {
            if (pf == null) {
                pf = readById(i.getId());
            }
            if (pf != null) {
                pf.setAplicaciones(i.getAplicaciones());
                pf.setIngrediente_activo(i.getIngrediente_activo());
                pf.setInventario(i.getInventario());
                pf.setNombre(i.getNombre());
                em.merge(pf);
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
        ProductoFitosanitario r = read(id);
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
