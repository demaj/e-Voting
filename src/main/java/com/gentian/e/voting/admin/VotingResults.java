package com.gentian.e.voting.admin;

import com.gentian.e.voting.entities.Results;
import com.gentian.e.voting.services.ResultsService;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.inject.Inject;

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
        _resultsService.clearCache();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Property Results List">
    private List<Results> _results;

    public List<Results> getResults() {
        _results = _resultsService.findAll();
        return _results;
    }

    public void setResults(List<Results> results) {
        _results = results;
    }
    // </editor-fold>
    
}
