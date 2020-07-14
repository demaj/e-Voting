package com.gentian.e.voting.user;

import com.gentian.e.voting.entities.ESubject;
import com.gentian.e.voting.entities.Subject;
import com.gentian.e.voting.enums.Page;
import com.gentian.e.voting.helper.SessionTools;
import com.gentian.e.voting.services.SubjectService;
import java.io.Serializable;
import java.util.HashMap;
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

    // <editor-fold defaultstate="collapsed" desc="Property Subjects Map">
    private Map<ESubject, Subject> _subjectsMap = new HashMap<>();

    public Map<ESubject, Subject> getSubjectsMap() {
        return _subjectsMap;
    }

    public void setSubjectsMap(Map<ESubject, Subject> subjectMap) {
        _subjectsMap = subjectMap;
    }
    
    public void addSubjectMap(ESubject key, Subject value) {
        _subjectsMap.put(key, value);
    }
    //</editor-fold>
    
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
        _subjects = _subjectService.findAll(Subject.class);
        _subjectsMap = _subjectService.findSubjects();
    }
    
    public String voteSubject(Subject subject) {
        _logger.log(Level.INFO, "Subject Number Voted: {0}", subject);
        _sessionTools.setVotedSubject(subject);
        return Page.VoteCandidate.getRedirectUrl();
    }
    
    public String voteESubject(Subject subject) {
        _logger.log(Level.INFO, "Subject Number Voted: {0}", subject);
        _sessionTools.setVotedSubject(subject);
        return Page.VoteCandidate.getRedirectUrl();
    }
    
}
