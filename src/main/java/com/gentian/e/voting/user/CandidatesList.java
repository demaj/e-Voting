package com.gentian.e.voting.user;

import com.gentian.e.voting.entities.Candidate;
import com.gentian.e.voting.entities.Subject;
import com.gentian.e.voting.enums.Page;
import com.gentian.e.voting.helper.SessionTools;
import com.gentian.e.voting.services.CandidateService;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Gentian
 */
@Named(value = "candidatesList")
@SessionScoped
public class CandidatesList implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger _logger = Logger.getLogger("CandidatesList");
    
    @Inject private SessionTools _sessionTools;
    @Inject private CandidateService _candidateService;
    private Subject _subject;
    
    // <editor-fold defaultstate="collapsed" desc="Property Candidates List">
    private List<Candidate> _candidates;

    public List<Candidate> getCandidates() {
        return _candidates;
    }
    // </editor-fold>
    
    @PostConstruct
    private void init() {
        _sessionTools.setVotedCandidates(new ArrayList<>());
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> paramMap = fc.getExternalContext().getRequestParameterMap();
        _subject = _sessionTools.getVotedSubject();
        int subjectId = _subject.getSubjectNumber();
        _candidates = _candidateService.findBySubject(subjectId);
    }
    
    public String vote() {
        return Page.ConfirmVote.getRedirectUrl();
    }
    
}
