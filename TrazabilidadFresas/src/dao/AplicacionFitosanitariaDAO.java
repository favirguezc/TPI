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
import modelo.AplicacionFitosanitaria;

/**
 *
 * @author fredy
 */
public class AplicacionFitosanitariaDAO {
    EntityManagerFactory emf = EntityManagerFactorySingleton.getEntityManagerFactory();
    
    public void create(AplicacionFitosanitaria a) {

        if (read(a.getId()) == null) {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            try {
                em.persist(a);
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            } finally {
                em.close();
            }
        }
    }

    public AplicacionFitosanitaria read(long id) {

        EntityManager em = emf.createEntityManager();
        AplicacionFitosanitaria r = null;
        try {
            r = (AplicacionFitosanitaria) em.createQuery("SELECT f FROM AplicacionFitosanitaria f WHERE f.id = :id").setParameter("id", id).getSingleResult();
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
            r = (ArrayList) em.createQuery("SELECT f FROM AplicacionFitosanitaria f",
                    AplicacionFitosanitaria.class).getResultList();
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return r;
    }


    public void update(AplicacionFitosanitaria i) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        AplicacionFitosanitaria f = read(i.getId());
        try {
            if (f != null) {
                f.setAdministrador(i.getAdministrador());
                f.setCantidadAplicada(i.getCantidadAplicada());
                f.setEquipoDeAplicacionFitosanitaria(i.getEquipoDeAplicacionFitosanitaria());
                f.setFecha(i.getFecha());
                f.setFresicultor(i.getFresicultor());
                f.setJornales(i.getJornales());
                f.setLitrosDeAguaUtilizada(i.getLitrosDeAguaUtilizada());
                f.setMotivo(i.getMotivo());
                f.setObservaciones(i.getObservaciones());
                f.setPc(i.getPc());
                f.setProductoFitosanitario(i.getProductoFitosanitario());
                f.setSiembra(i.getSiembra());
                f.setTr(i.getTr());
                em.merge(f);
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
        AplicacionFitosanitaria r = read(id);
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
