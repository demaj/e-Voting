package com.gentian.e.voting.services;

import com.gentian.e.voting.entities.Results;
import javax.ejb.Stateless;

/**
 *
 * @author Gentian
 */
@Stateless
public class ResultsService extends AbstractService<Results> {
    
    public ResultsService() {
        super(Results.class);
        System.out.println("ctor ResultsService");
    }
    
}
