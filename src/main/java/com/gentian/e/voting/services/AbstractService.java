package com.gentian.e.voting.services;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Gentian
 */
public abstract class AbstractService {
    
    @PersistenceContext(unitName = "VotingPU")
    private EntityManager _em;
    
    public AbstractService() {
    }
    
    public EntityManager getEntityManager() {
        return _em;
    }
    
    public <T> T create(T entity) {
        getEntityManager().persist(entity);
        return entity;
    }
    
    public <T> T read(Object id, Class<T> entityClass) {
        return getEntityManager().find(entityClass, id);
    }
    
    public <T> T update(T entity) {
        return getEntityManager().merge(entity);
    }
    
    public void delete(Object entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }
    
    /**
     * Convenience method to create or update automatically
     * 
     * @param <T>
     * @param entity
     * @return 
     */
    public <T> T save(T entity) {
        return update(entity);
    }
    
    public <T> T find(Class<T> entityClass, Object id) {
        return getEntityManager().find(entityClass, id);
    }
    
    public <T> List<T> findAll(Class<T> entityClass) {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }
    
    public <T> List<T> findRange(Class<T> entityClass, int[] range) {
        return findRange(entityClass, range[0], range[1]);
    }
    
    public <T> List<T> findRange(Class<T> entityClass, int from, int to) {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(to - from + 1);
        q.setFirstResult(from);
        return q.getResultList();
    }
    
    public <T> int count(Class<T> entityClass) {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
    public boolean isAttached(Object entity) {
        return getEntityManager().contains(entity);
    }
    
    public void clearCache() {
        getEntityManager().flush();
        getEntityManager().getEntityManagerFactory().getCache().evictAll();
    }
    
}
