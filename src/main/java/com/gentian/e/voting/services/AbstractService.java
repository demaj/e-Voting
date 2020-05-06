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
 * @param <T>
 */
public abstract class AbstractService<T> {
    
    @PersistenceContext(unitName = "VotingPU")
    private EntityManager _em;
    private final Class<T> _entityClass;
    
    public AbstractService(Class<T> entityClass) {
        _entityClass = entityClass;
    }
    
    protected EntityManager getEntityManager() {
        return _em;
    }
    
    public T create(T entity) {
        getEntityManager().persist(entity);
        return entity;
    }
    
    public T read(Object id) {
        return getEntityManager().find(_entityClass, id);
    }
    
    public T update(T entity) {
        return getEntityManager().merge(entity);
    }
    
    public void delete(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }
    
    /**
     * Convenience method to create or update automatically
     * 
     * @param entity
     * @return 
     */
    public T save(T entity) {
        return update(entity);
    }
    
    public T find(Object id) {
        return getEntityManager().find(_entityClass, id);
    }
    
    public List<T> findAll() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(_entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }
    
    public List<T> findRange(int[] range) {
        return findRange(range[0], range[1]);
    }
    
    public List<T> findRange(int from, int to) {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(_entityClass));
        Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(to - from + 1);
        q.setFirstResult(from);
        return q.getResultList();
    }
    
    public int count() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        Root<T> rt = cq.from(_entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
    public boolean isAttached(T entity) {
        return getEntityManager().contains(entity);
    }
    
    public void clearCache() {
        getEntityManager().flush();
        getEntityManager().getEntityManagerFactory().getCache().evictAll();
    }
    
}
