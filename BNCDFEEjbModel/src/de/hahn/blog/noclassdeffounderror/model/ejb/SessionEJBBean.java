package de.hahn.blog.noclassdeffounderror.model.ejb;

import java.util.List;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless(name="SessionEJB", mappedName = "BNCDFEEjbModelSessionEJB")
public class SessionEJBBean implements SessionEJBLocal {
    @PersistenceContext(unitName="BNCDFEEjbModel")
    private EntityManager em;

    public SessionEJBBean() {
    }

    public Object queryByRange(String jpqlStmt, int firstResult, int maxResults) {
        Query query = em.createQuery(jpqlStmt);
        if (firstResult > 0) {
            query = query.setFirstResult(firstResult);
        }
        if (maxResults > 0) {
            query = query.setMaxResults(maxResults);
        }
        return query.getResultList();
    }

    public Regions persistRegions(Regions regions) {
        em.persist(regions);
        return regions;
    }

    public Regions mergeRegions(Regions regions) {
        return em.merge(regions);
    }

    public void removeRegions(Regions regions) {
        regions = em.find(Regions.class, regions.getRegionId());
        em.remove(regions);
    }

    /** <code>select o from Regions o</code> */
    public List<Regions> getRegionsFindAll() {
        return em.createNamedQuery("Regions.findAll").getResultList();
    }

    /** <code>select o from Regions o where o.id = :bindRegionId</code> */
    public List<Regions> getRegionsFindById(Object bindRegionId) {
        return em.createNamedQuery("Regions.findById").setParameter("bindRegionId", bindRegionId).getResultList();
    }
}
