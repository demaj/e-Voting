package com.gentian.e.voting.admin;

import com.gentian.e.voting.entities.Results;
import com.gentian.e.voting.services.ResultsService;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Gentian
 */
@Named(value = "votingResults")
@RequestScoped
public class VotingResults implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private static final Logger _logger = Logger.getLogger("VotingResults");
    
    @Inject private ResultsService _resultsService;
        
    @PostConstruct
    private void init() {
        _logger.log(Level.INFO, "init in VotingResults");
    }
    
    // <editor-fold defaultstate="collapsed" desc="Property Results List">
    private List<Results> _results;

    public List<Results> getResults() {
        _results = _resultsService.findAll(Results.class);
        return _results;
    }
    // </editor-fold>
   
}
