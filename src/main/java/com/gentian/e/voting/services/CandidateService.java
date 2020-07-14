package com.gentian.e.voting.services;

import com.gentian.e.voting.entities.Candidate;
import com.gentian.e.voting.entities.ECandidate;
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
public class CandidateService extends AbstractService {

    public CandidateService() {
        System.out.println("ctor CandidateService");
    }
    
    public List<ECandidate> findBySubjectId(int field) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<ECandidate> cq = cb.createQuery(ECandidate.class);
        Root<ECandidate> candidate = cq.from(ECandidate.class);
        cq.select(candidate).where(cb.equal(candidate.get("_candidateSubjectId"), field)).orderBy(cb.asc(candidate.get("_id")));
        return getEntityManager().createQuery(cq).getResultList();
    }
    
    public List<Candidate> findBySubject(int field) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Candidate> cq = cb.createQuery(Candidate.class);
        Root<Candidate> candidate = cq.from(Candidate.class);
        cq.select(candidate).where(cb.equal(candidate.get("_id"), field)).orderBy(cb.asc(candidate.get("_id")));
        return getEntityManager().createQuery(cq).getResultList();
    }
    
    public void addVote(int candidate) {
        StoredProcedureQuery storedProcedure = getEntityManager().createStoredProcedureQuery("add_vote");
        storedProcedure.registerStoredProcedureParameter(0, Integer.class, ParameterMode.IN);
        storedProcedure.setParameter(0, candidate);
        storedProcedure.executeUpdate();
    }
    
    public void addVotes2(int subject, String votedCandidates) {
        StoredProcedureQuery storedProcedure = getEntityManager().createStoredProcedureQuery("voto");
        // Add subject as the first parameter
        storedProcedure.registerStoredProcedureParameter(0, Integer.class, ParameterMode.IN);
        storedProcedure.setParameter(0, subject);
        // Add candidates as the second parameter
        storedProcedure.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        storedProcedure.setParameter(1, votedCandidates);
        // Execute the query
        storedProcedure.execute();
        clearCache();
    }
    
    public void addVotes(int subject, String votedCandidates) {
        StoredProcedureQuery storedProcedure = getEntityManager()
                .createStoredProcedureQuery("voto");
        // Shto ID-në e subjektit si parametrin e parë
        storedProcedure.registerStoredProcedureParameter(0, Integer.class, 
                ParameterMode.IN);
        storedProcedure.setParameter(0, subject);
        // Shto kandidatët si parametrin e dytë
        storedProcedure.registerStoredProcedureParameter(1, String.class, 
                ParameterMode.IN);
        storedProcedure.setParameter(1, votedCandidates);
        // Ekzekuto query-in
        storedProcedure.execute();
        clearCache();
    }
    
}
