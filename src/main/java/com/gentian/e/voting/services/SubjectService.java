package com.gentian.e.voting.services;

import javax.ejb.Stateless;
import com.gentian.e.voting.entities.Subject;

/**
 *
 * @author Gentian
 */
@Stateless
public class SubjectService extends AbstractService<Subject> {
    
    public SubjectService() {
        super(Subject.class);
        System.out.println("ctor SubjectService");
    }
    
}
