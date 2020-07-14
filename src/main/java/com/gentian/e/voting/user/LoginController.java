package com.gentian.e.voting.user;

import com.gentian.e.voting.entities.EVoter;
import com.gentian.e.voting.enums.Page;
import com.gentian.e.voting.helper.SessionTools;
import com.gentian.e.voting.services.VoterService;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Gentian
 */
@Named(value = "login")
@SessionScoped
public class LoginController implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger _logger = Logger.getLogger("LoginController");
    
    @Inject private SessionTools _sessionTools;
    @Inject private VoterService _voterService;
    
    // <editor-fold defaultstate="collapsed" desc="Property EVoter">
    private EVoter _voter;

    public EVoter getEVoter() {
        return _voter;
    }

    public void setEVoter(EVoter voter) {
        _voter = voter;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Property Personal Id">
    private Integer _userPId;

    public Integer getUserPId() {
        return _userPId;
    }

    public void setUserPId(Integer userPId) {
        _userPId = userPId;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Property Password">
    private String _password;
    
    public String getPassword() {
        return _password;
    }

    public void setPassword(String password) {
        _password = password;
    }
    // </editor-fold>
    
    /**
     * Creates a new instance of LoginController
     */
    public LoginController() {
    }
    
    public String login() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        _logger.log(Level.INFO, "Username: {0}", _userPId);
        _logger.log(Level.INFO, "Password: {0}", _password);
        _voter = _voterService.findEVoter(_userPId, _password);
        if (_voter == null) {
            facesContext.addMessage(null, new FacesMessage("Unknown login, try again!"));
            _userPId = null;
            _password = null;
            return Page.LoginError.getRedirectUrl();
        } else {
            boolean hasUserVoted = _voter.hasUserVoted();
            if (hasUserVoted) {
                facesContext.addMessage(null, new FacesMessage("You have voted already!"));
                return Page.UserHasVoted.getRedirectUrl();
            } else {
                facesContext.getExternalContext().getSessionMap().put("user", _voter);
                return Page.VoteSubject.getRedirectUrl();
            }
        }
    }
    
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return Page.ThankYou.getRedirectUrl();
    }
    
}
