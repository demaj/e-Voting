package com.gentian.e.voting.helper;

import com.gentian.e.voting.entities.Subject;
import com.gentian.e.voting.enums.Page;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.el.ELContextEvent;
import javax.enterprise.context.Conversation;
import javax.faces.context.FacesContext;

/**
 *
 * @author Gentian
 */
@Named(value = "sessionTools")
@SessionScoped
public class SessionTools implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private static final Logger _logger = Logger.getLogger("SessionController");

    
    public SessionTools() {
        _logger.log(Level.INFO, "SessionTools started");
        System.out.println("SessionTools started");
    }
    
    @PostConstruct
    public void init() {
        FacesContext.getCurrentInstance().getApplication().addELContextListener((ELContextEvent event) -> {
            event.getELContext().getImportHandler().importPackage("com.gentian.e.voting.enums.*");
        });
        FacesContext.getCurrentInstance().getApplication().addELContextListener((ELContextEvent event) -> {
            event.getELContext().getImportHandler().importClass("com.gentian.e.voting.enums.Page");
        });
    }
    
    public Map<String, String> getPages() {
        return Page.getPages();
    }
    
    public String navigate(Page page) {
        _logger.log(Level.WARNING, "Navigate to {0}", page.getUrl());
        endAllConversations();
        return page.getRedirectUrl();
    }
    
    public String beginConversation(Conversation conversation) {
        if (conversation.isTransient()) {
            int minutes = 15;
            conversation.setTimeout(minutes * 60000);
            conversation.begin(UUID.randomUUID().toString());
            _logger.log(Level.WARNING, "Conversation started: {0}", conversation.getId());
            return conversation.getId();
        }
        else {
            _logger.log(Level.WARNING, "Conversation still running: {0}", conversation.getId());
            return conversation.getId();
        }
    }
    
    public void endConversation(Conversation conversation) {
        if (!conversation.isTransient()) {
            _logger.log(Level.WARNING, "Converstion stopping: {0}", conversation.getId());
            conversation.end();
        }
    }
    
    public void endAllConversations() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Map<String, Object> map = facesContext.getExternalContext().getSessionMap();
        Map<String, Conversation> conversations = (Map<String, Conversation>) map.get("org.jboss.weld.context.ConversationContext.conversations");
        conversations.values().forEach((conversation) -> {
            endConversation(conversation);
        });
    }
    
    // <editor-fold defaultstate="collapsed" desc="Property Voted Subject">
    private Subject _votedSubject;

    public Subject getVotedSubject() {
        return _votedSubject;
    }

    public void setVotedSubject(Subject votedSubject) {
        _votedSubject = votedSubject;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Property Voted Candidates">
    private List<Integer> _votedCandidates;

    public List<Integer> getVotedCandidates() {
        return _votedCandidates;
    }

    public void setVotedCandidates(List<Integer> votedCandidates) {
        _votedCandidates = votedCandidates;
    }
    
    public void addVotedCandidate(Integer candidate) {
        _logger.log(Level.INFO, "Voted Candidate: {0}", candidate);
        if (_votedCandidates.contains(candidate)) {
            _votedCandidates.remove(candidate);
        }
        else if (_votedCandidates.size() < 5) {
            _votedCandidates.add(candidate);
        }
        else {
            _logger.log(Level.INFO, "");
        }
        _logger.log(Level.INFO, "List of voted candidates: {0}", _votedCandidates);
    }
    // </editor-fold>
    
}
