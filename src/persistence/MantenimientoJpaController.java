/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Mantenimiento;
import persistence.exceptions.NonexistentEntityException;

/**
 *
 * @author monit
 */
public class MantenimientoJpaController implements Serializable {

    public MantenimientoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Mantenimiento mantenimiento) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(mantenimiento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Mantenimiento mantenimiento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            mantenimiento = em.merge(mantenimiento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = mantenimiento.getPk();
                if (findMantenimiento(id) == null) {
                    throw new NonexistentEntityException("The mantenimiento with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mantenimiento mantenimiento;
            try {
                mantenimiento = em.getReference(Mantenimiento.class, id);
                mantenimiento.getPk();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mantenimiento with id " + id + " no longer exists.", enfe);
            }
            em.remove(mantenimiento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Mantenimiento> findMantenimientoEntities() {
        return findMantenimientoEntities(true, -1, -1);
    }

    public List<Mantenimiento> findMantenimientoEntities(int maxResults, int firstResult) {
        return findMantenimientoEntities(false, maxResults, firstResult);
    }

    private List<Mantenimiento> findMantenimientoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Mantenimiento.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Mantenimiento findMantenimiento(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mantenimiento.class, id);
        } finally {
            em.close();
        }
    }

    public int getMantenimientoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Mantenimiento> rt = cq.from(Mantenimiento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
