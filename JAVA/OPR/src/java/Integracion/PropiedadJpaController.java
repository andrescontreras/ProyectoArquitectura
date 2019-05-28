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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
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
        this.emf =  Persistence.createEntityManagerFactory("LogicaOPRPU");
    }
    @Resource
    private UserTransaction utx;

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Propiedad propiedad) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(propiedad);
            em.getTransaction().commit();
        } catch (Exception ex) {
            try {
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
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
    /*------------------------------------------ CONSULTAS DE PROPIEDAD --------------------------------------*/
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
    /*------------------------------------------ CONSULTAS DE RENTA --------------------------------------*/
    public void agregarRenta(Renta renta){
        
        EntityManager em = getEntityManager();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date today = new Date();
        String fechaHoy = dateFormat.format(today.getTime());
        //Query query = em.createQuery("INSERT INTO RENTA"
	//			+ "(CEDULA_USUARIO, ID_PROPIEDAD, EMAIL,PRECIO_RENTA,FECHA, ESTADO,FECHA_RENTA) " + "VALUES"
	//			+ "(1,'mkyong','system', " + "to_date('"
	//			+ getCurrentTimeStamp() + "', 'yyyy/mm/dd hh24:mi:ss'))");
        
    //INSERT INTO renta (cedula_usuario, id_propiedad, email, precio_renta, fecha, estado,fecha_renta) 
    //VALUES (2345, 2, 'ASHGG', 4000, TO_DATE('2019/05/24 00:02:44', 'yyyy/mm/dd hh24:mi:ss'), 0,TO_DATE('2019/05/24 00:02:44', 'yyyy/mm/dd hh24:mi:ss'));
        String consulta = "INSERT INTO RENTA"
				+ "(CEDULA_USUARIO, ID_PROPIEDAD, EMAIL,PRECIO_RENTA,FECHA, ESTADO,FECHA_RENTA) " + "VALUES"
				+ "( "+renta.getCedulaUsuario()+",2,'"+renta.getEmail()+"',"+renta.getPrecioRenta()+","+"to_date('"+ fechaHoy + "', 'yyyy/mm/dd hh24:mi:ss'),"+renta.getEstado()+","+"to_date('"+ fechaHoy + "', 'yyyy/mm/dd hh24:mi:ss')"+")";
//        Query query = em.createQuery("INSERT INTO RENTA"
//				+ "(CEDULA_USUARIO, ID_PROPIEDAD, EMAIL,PRECIO_RENTA,FECHA, ESTADO,FECHA_RENTA) " + "VALUES"
//				+ "( "+renta.getCedulaUsuario()+",2,'"+renta.getEmail()+"',"+renta.getPrecioRenta()+","+"to_date('"+ fechaHoy + "', 'yyyy/mm/dd hh24:mi:ss'),"+renta.getEstado()+","+"to_date('"+ fechaHoy + "', 'yyyy/mm/dd hh24:mi:ss')"+")");
        
        System.out.println("Esta es la consulta ---> "+consulta);
  //      query.getSingleResult();
    }
}
