package com.gentian.e.voting.user;

import com.gentian.e.voting.entities.ECandidate;
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
    
    // <editor-fold defaultstate="collapsed" desc="Property Candidates List">
    private List<ECandidate> _candidates;

    public List<ECandidate> getCandidates() {
        return _candidates;
    }
    // </editor-fold>
    
    @PostConstruct
    private void init() {
        _sessionTools.setVotedCandidates(new ArrayList<>());
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> paramMap = fc.getExternalContext().getRequestParameterMap();
        Subject _subject = _sessionTools.getVotedSubject();
        int subjectId = _subject.getId();
        _candidates = _candidateService.findBySubjectId(subjectId);
    }
    
    public String vote() {
        return Page.ConfirmVote.getRedirectUrl();
    }
    
}
