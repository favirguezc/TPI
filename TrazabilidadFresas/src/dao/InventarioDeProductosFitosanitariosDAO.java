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
import modelo.InventarioDeProductosFitosanitarios;

/**
 *
 * @author fredy
 */
public class InventarioDeProductosFitosanitariosDAO {

    EntityManagerFactory emf = EntityManagerFactorySingleton.getEntityManagerFactory();

    public boolean create(InventarioDeProductosFitosanitarios a) {

        if (read(a.getId()) == null) {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            boolean ok = false;
            try {
                em.persist(a);
                em.getTransaction().commit();
                ok = true;
            } catch (Exception e) {
                em.getTransaction().rollback();
                ok = false;
            } finally {
                em.close();
            }
            return ok;
        }
        return false;
    }

    public InventarioDeProductosFitosanitarios read(long id) {

        EntityManager em = emf.createEntityManager();
        InventarioDeProductosFitosanitarios r = null;
        try {
            r = (InventarioDeProductosFitosanitarios) em.createQuery("SELECT f FROM InventarioDeProductosFitosanitarios f WHERE f.id = :id").setParameter("id", id).getSingleResult();
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
            r = (ArrayList) em.createQuery("SELECT f FROM InventarioDeProductosFitosanitarios f",
                    InventarioDeProductosFitosanitarios.class).getResultList();
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return r;
    }

    public void update(InventarioDeProductosFitosanitarios i) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        InventarioDeProductosFitosanitarios f = read(i.getId());
        try {
            if (f != null) {
                f.setCantidad(i.getCantidad());
                f.setFechaDeCompra(i.getFechaDeCompra());
                f.setPrecio(i.getPrecio());
                f.setProductoFitosanitario(i.getProductoFitosanitario());
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
        InventarioDeProductosFitosanitarios r = read(id);
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
