package com.gentian.e.voting.services;

import com.gentian.e.voting.entities.ESubject;
import com.gentian.e.voting.entities.Subject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.Tuple;
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
public class SubjectService extends AbstractService {
    
    public SubjectService() {
        System.out.println("ctor SubjectService");
    }
    
    public Map<ESubject, Subject> findSubjects() {
        Map<ESubject, Subject> subjectsMap = new HashMap<>();
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Object[]> query = cb.createQuery(Object[].class);
        Root<ESubject> eSubject = query.from(ESubject.class);
        Root<Subject> subject = query.from(Subject.class);
        Predicate p1 = cb.equal(eSubject.get("_id"), subject.get("_id"));
        query.multiselect(eSubject, subject);
        query.where(p1);
        query.orderBy(cb.asc(subject.get("_id")));
        List<Object[]> resultList = getEntityManager().createQuery(query).getResultList();
        resultList.forEach((tuple) -> {
            ESubject esub = (ESubject) tuple[0];
            Subject sub = (Subject) tuple[1];
            System.out.println(esub);
            System.out.println(sub);
            subjectsMap.put(esub, sub);
        });
        return subjectsMap;
    }
    
    public Map<Integer, String> findESubjects() {
        Map<Integer, String> subjectsMap = new HashMap<>();
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Tuple> query = cb.createTupleQuery();
        Root<ESubject> eSubject = query.from(ESubject.class);
        Root<Subject> subject = query.from(Subject.class);
        Predicate p1 = cb.equal(eSubject.get("_id"), subject.get("_id"));
        query.select(cb.tuple(eSubject.get("_number"), subject.get("_name")));
        query.where(p1);
        TypedQuery<Tuple> tq = getEntityManager().createQuery(query);
        try {
            List<Tuple> resultList = tq.getResultList();
            resultList.forEach((tuple) -> {
                int number = (int) tuple.get(0);
                String name = (String) tuple.get(1);
                subjectsMap.put(number, name);
            });
        } catch (Exception exception){
            System.out.println("ERROR: No subjects found.");
            // No subjects found.
        }
        return subjectsMap;
    }
    
}
