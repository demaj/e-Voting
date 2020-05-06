package com.gentian.e.voting.services;

import com.gentian.e.voting.entities.Candidate;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Gentian
 */
@Stateless
public class CandidateService extends AbstractService<Candidate> {

    public CandidateService() {
        super(Candidate.class);
        System.out.println("ctor CandidateService");
    }
    
    public List<Candidate> findBySubject(int field) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Candidate> cq = cb.createQuery(Candidate.class);
        Root<Candidate> request = cq.from(Candidate.class);
        cq.select(request).where(cb.equal(request.get("_candidateSubjectNumber"), field)).orderBy(cb.asc(request.get("_id")));
        return getEntityManager().createQuery(cq).getResultList();
    }
    
    public void addVote(int candidate) {
        StoredProcedureQuery storedProcedure = getEntityManager().createStoredProcedureQuery("add_vote");
        storedProcedure.registerStoredProcedureParameter(0, Integer.class, ParameterMode.IN);
        storedProcedure.setParameter(0, candidate);
        storedProcedure.executeUpdate();
    }
    
    public void addVotes(String votedCandidates) {
        StoredProcedureQuery storedProcedure = getEntityManager().createStoredProcedureQuery("add_votes_str");
        storedProcedure.registerStoredProcedureParameter(0, String.class, ParameterMode.IN);
        storedProcedure.setParameter(0, votedCandidates);
        storedProcedure.execute();
    }
    
}
