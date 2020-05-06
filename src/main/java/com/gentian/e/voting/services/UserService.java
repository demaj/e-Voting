package com.gentian.e.voting.services;

import javax.ejb.Stateless;
import com.gentian.e.voting.entities.User;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Gentian
 */
@Stateless
public class UserService extends AbstractService<User> {
    
    public UserService() {
        super(User.class);
        System.out.println("ctor UserService");
    }
    
    public User find(Integer userPId, String password) {
        User user = null;
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> request = query.from(User.class);
        query.select(request).where(cb.and(
                cb.equal(request.get("_id"), userPId),
                cb.equal(request.get("_password"), password)
        ));
        TypedQuery<User> q = getEntityManager().createQuery(query);
        try {
            user = q.getSingleResult();
        } catch (Exception ex){
            // No user found.
        }
        return user;
    }
    
}
