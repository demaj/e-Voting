package com.gentian.e.voting.admin;

import com.gentian.e.voting.entities.Subject;
import com.gentian.e.voting.helper.SessionTools;
import com.gentian.e.voting.services.SubjectService;
import javax.inject.Named;
import javax.enterprise.context.ConversationScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.inject.Inject;

/**
 *
 * @author Gentian
 */
@Named(value = "subjectEditor")
@ConversationScoped
public class SubjectEditor implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private static final Logger _logger = Logger.getLogger("SubjectEditor");
    @Inject private SubjectService _subjectService;
    @Inject Conversation _conversation;
    @Inject SessionTools _sessionTools;
    
    private List<Subject> _subjects;
    
    @PostConstruct
    private void init() {
        _logger.log(Level.INFO, "init in SubjectEditor");
        _subjects = _subjectService.findAll();
    }
    
}
