/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Integracion;

import Integracion.exceptions.NonexistentEntityException;
import Integracion.exceptions.PreexistingEntityException;
import Integracion.exceptions.RollbackFailureException;
import entities.Propiedad;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Renta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.UserTransaction;

/**
 *
 * @author andre
 */
public class PropiedadJpaController implements Serializable {

    public PropiedadJpaController() {
        this.utx = utx;
        this.emf =  Persistence.createEntityManagerFactory("LogicaOPRPU");
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Propiedad propiedad) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (propiedad.getRentaCollection() == null) {
            propiedad.setRentaCollection(new ArrayList<Renta>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Collection<Renta> attachedRentaCollection = new ArrayList<Renta>();
            for (Renta rentaCollectionRentaToAttach : propiedad.getRentaCollection()) {
                rentaCollectionRentaToAttach = em.getReference(rentaCollectionRentaToAttach.getClass(), rentaCollectionRentaToAttach.getId());
                attachedRentaCollection.add(rentaCollectionRentaToAttach);
            }
            propiedad.setRentaCollection(attachedRentaCollection);
            em.persist(propiedad);
            for (Renta rentaCollectionRenta : propiedad.getRentaCollection()) {
                Propiedad oldIdPropiedadOfRentaCollectionRenta = rentaCollectionRenta.getIdPropiedad();
                rentaCollectionRenta.setIdPropiedad(propiedad);
                rentaCollectionRenta = em.merge(rentaCollectionRenta);
                if (oldIdPropiedadOfRentaCollectionRenta != null) {
                    oldIdPropiedadOfRentaCollectionRenta.getRentaCollection().remove(rentaCollectionRenta);
                    oldIdPropiedadOfRentaCollectionRenta = em.merge(oldIdPropiedadOfRentaCollectionRenta);
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findPropiedad(propiedad.getId()) != null) {
                throw new PreexistingEntityException("Propiedad " + propiedad + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Propiedad propiedad) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Propiedad persistentPropiedad = em.find(Propiedad.class, propiedad.getId());
            Collection<Renta> rentaCollectionOld = persistentPropiedad.getRentaCollection();
            Collection<Renta> rentaCollectionNew = propiedad.getRentaCollection();
            Collection<Renta> attachedRentaCollectionNew = new ArrayList<Renta>();
            for (Renta rentaCollectionNewRentaToAttach : rentaCollectionNew) {
                rentaCollectionNewRentaToAttach = em.getReference(rentaCollectionNewRentaToAttach.getClass(), rentaCollectionNewRentaToAttach.getId());
                attachedRentaCollectionNew.add(rentaCollectionNewRentaToAttach);
            }
            rentaCollectionNew = attachedRentaCollectionNew;
            propiedad.setRentaCollection(rentaCollectionNew);
            propiedad = em.merge(propiedad);
            for (Renta rentaCollectionOldRenta : rentaCollectionOld) {
                if (!rentaCollectionNew.contains(rentaCollectionOldRenta)) {
                    rentaCollectionOldRenta.setIdPropiedad(null);
                    rentaCollectionOldRenta = em.merge(rentaCollectionOldRenta);
                }
            }
            for (Renta rentaCollectionNewRenta : rentaCollectionNew) {
                if (!rentaCollectionOld.contains(rentaCollectionNewRenta)) {
                    Propiedad oldIdPropiedadOfRentaCollectionNewRenta = rentaCollectionNewRenta.getIdPropiedad();
                    rentaCollectionNewRenta.setIdPropiedad(propiedad);
                    rentaCollectionNewRenta = em.merge(rentaCollectionNewRenta);
                    if (oldIdPropiedadOfRentaCollectionNewRenta != null && !oldIdPropiedadOfRentaCollectionNewRenta.equals(propiedad)) {
                        oldIdPropiedadOfRentaCollectionNewRenta.getRentaCollection().remove(rentaCollectionNewRenta);
                        oldIdPropiedadOfRentaCollectionNewRenta = em.merge(oldIdPropiedadOfRentaCollectionNewRenta);
                    }
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Short id = propiedad.getId();
                if (findPropiedad(id) == null) {
                    throw new NonexistentEntityException("The propiedad with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Short id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Propiedad propiedad;
            try {
                propiedad = em.getReference(Propiedad.class, id);
                propiedad.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The propiedad with id " + id + " no longer exists.", enfe);
            }
            Collection<Renta> rentaCollection = propiedad.getRentaCollection();
            for (Renta rentaCollectionRenta : rentaCollection) {
                rentaCollectionRenta.setIdPropiedad(null);
                rentaCollectionRenta = em.merge(rentaCollectionRenta);
            }
            em.remove(propiedad);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Propiedad> findPropiedadEntities() {
        return findPropiedadEntities(true, -1, -1);
    }

    public List<Propiedad> findPropiedadEntities(int maxResults, int firstResult) {
        return findPropiedadEntities(false, maxResults, firstResult);
    }

    private List<Propiedad> findPropiedadEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Propiedad.class));
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

    public Propiedad findPropiedad(Short id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Propiedad.class, id);
        } finally {
            em.close();
        }
    }

    public int getPropiedadCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Propiedad> rt = cq.from(Propiedad.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<Propiedad> getPropiedades()
    {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("Select e from Propiedad e");
        return (List<Propiedad>)query.getResultList();
    }
    public List<Propiedad> getPropiedadesxNombre(String nombre)
    {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("Select e from Propiedad e WHERE e.nombre LIKE '%"+nombre+"%'");
        List<Propiedad> list = query.getResultList();
        return list;
    }
    public List<Propiedad> getPropiedadesxCedula(BigDecimal cedula)
    {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("Select e from Propiedad e WHERE e.cedulaOwner LIKE '%"+cedula+"%'");
        List<Propiedad> list = query.getResultList();
        return list;
    }
    
}
