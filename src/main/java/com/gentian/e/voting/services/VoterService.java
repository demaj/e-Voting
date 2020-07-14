package com.gentian.e.voting.services;

import com.gentian.e.voting.entities.EVoter;
import com.gentian.e.voting.entities.LoginInfo;
import com.gentian.e.voting.entities.Voter;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Gentian
 */
@Stateless
public class VoterService extends AbstractService {

    public VoterService() {
        System.out.println("ctor VoterService");
    }
    
    public EVoter findEVoter(Integer voterPId, String password) {
        EVoter voter = null;
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<EVoter> query = cb.createQuery(EVoter.class);
        Root<EVoter> eVoter = query.from(EVoter.class);
        Root<LoginInfo> loginInfo = query.from(LoginInfo.class);
        Predicate p1 = cb.equal(eVoter.get("_pid"), loginInfo.get("_loginUser"));
        Predicate p2 = cb.equal(loginInfo.get("_loginUser"), voterPId);
        Predicate p3 = cb.equal(loginInfo.get("_password"), password);
        Predicate pFinal = cb.and(p1, p2, p3);
        query.select(eVoter);
        query.where(pFinal);
        TypedQuery<EVoter> tq = getEntityManager().createQuery(query);
        try {
            voter = tq.getSingleResult();
        } catch (Exception exception){
            System.out.println("No user found.");
            // No user found.
        }
        return voter;
    }
    
    public Voter find(Integer voterPId, String password) {
        Voter voter = null;
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Voter> query = cb.createQuery(Voter.class);
        Root<Voter> voters = query.from(Voter.class);
        Root<EVoter> eVoter = query.from(EVoter.class);
        Root<LoginInfo> loginInfo = query.from(LoginInfo.class);
        Predicate p1 = cb.equal(voters.get("_personalId"), eVoter.get("_pid"));
        Predicate p2 = cb.equal(voters.get("_personalId"), loginInfo.get("_loginUser"));
        Predicate p3 = cb.equal(voters.get("_personalId"), voterPId);
        Predicate p4 = cb.equal(loginInfo.get("_password"), password);
        Predicate pFinal = cb.and(p1, p2, p3, p4);
        query.select(voters);
        query.where(pFinal);
        TypedQuery<Voter> tq = getEntityManager().createQuery(query);
        try {
            voter = tq.getSingleResult();
        } catch (Exception exception){
            System.out.println("No user found.");
            // No user found.
        }
        return voter;
    }
}
