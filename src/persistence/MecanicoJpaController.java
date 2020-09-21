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
import modelo.Mecanico;
import persistence.exceptions.NonexistentEntityException;
import persistence.exceptions.PreexistingEntityException;

/**
 *
 * @author Grajales
 */
public class MecanicoJpaController implements Serializable {

    public MecanicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Mecanico mecanico) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(mecanico);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMecanico(mecanico.getNuip()) != null) {
                throw new PreexistingEntityException("Mecanico " + mecanico + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Mecanico mecanico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            mecanico = em.merge(mecanico);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = mecanico.getNuip();
                if (findMecanico(id) == null) {
                    throw new NonexistentEntityException("The mecanico with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mecanico mecanico;
            try {
                mecanico = em.getReference(Mecanico.class, id);
                mecanico.getNuip();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mecanico with id " + id + " no longer exists.", enfe);
            }
            em.remove(mecanico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Mecanico> findMecanicoEntities() {
        return findMecanicoEntities(true, -1, -1);
    }

    public List<Mecanico> findMecanicoEntities(int maxResults, int firstResult) {
        return findMecanicoEntities(false, maxResults, firstResult);
    }

    private List<Mecanico> findMecanicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Mecanico.class));
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

    public Mecanico findMecanico(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mecanico.class, id);
        } finally {
            em.close();
        }
    }

    public int getMecanicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Mecanico> rt = cq.from(Mecanico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
