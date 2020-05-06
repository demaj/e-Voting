package com.gentian.e.voting.user;

import com.gentian.e.voting.entities.Subject;
import com.gentian.e.voting.enums.Page;
import com.gentian.e.voting.helper.SessionTools;
import com.gentian.e.voting.services.SubjectService;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Gentian
 */
@Named(value = "subjectsList")
@SessionScoped
public class SubjectsList implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private static final Logger _logger = Logger.getLogger("SubjectsList");
    
    @Inject private SessionTools _sessionTools;
    @Inject private SubjectService _subjectService;

    // <editor-fold defaultstate="collapsed" desc="Property Subjects List">
    private List<Subject> _subjects;

    public List<Subject> getSubjects() {
        return _subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        _subjects = subjects;
    }
    // </editor-fold>

    @PostConstruct
    private void init() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Map<String, String> paramMap = facesContext.getExternalContext().getRequestParameterMap();
        _subjects = _subjectService.findAll();
    }
    
    public String voteSubject(Subject subject) {
        _logger.log(Level.INFO, "Subject Number Voted: {0}", subject);
        _sessionTools.setVotedSubject(subject);
        return Page.VoteCandidate.getRedirectUrl();
    }
    
}
