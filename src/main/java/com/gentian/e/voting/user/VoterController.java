package com.gentian.e.voting.user;

import com.gentian.e.voting.entities.EVoter;
import com.gentian.e.voting.entities.LoginInfo;
import com.gentian.e.voting.entities.Voter;
import com.gentian.e.voting.enums.Page;
import com.gentian.e.voting.helper.SessionTools;
import com.gentian.e.voting.services.VoterService;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Gentian
 */
@Named(value = "voter")
@SessionScoped
public class VoterController implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private static final Logger _logger = Logger.getLogger("VoterController");
    
    @Inject private SessionTools _sessionTools;
    @Inject private VoterService _voterService;

    // <editor-fold defaultstate="collapsed" desc="Property Voter">
    private Voter _voter;

    public Voter getVoter() {
        return _voter;
    }

    public void setVoter(Voter voter) {
        _voter = voter;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Property EVoter">
    private EVoter _eVoter;

    public EVoter getEVoter() {
        return _eVoter;
    }

    public void setEVoter(EVoter eVoter) {
        _eVoter = eVoter;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Property LoginInfo">
    private LoginInfo _loginUser;
    

    public LoginInfo getLoginUser() {
        return _loginUser;
    }

    public void setLoginUser(LoginInfo loginUser) {
        _loginUser = loginUser;
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
    
    public String login() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        _logger.log(Level.INFO, "Username: {0}", _userPId);
        _logger.log(Level.INFO, "Password: {0}", _password);
        _eVoter = _voterService.findEVoter(_userPId, _password);
        if (_eVoter == null) {
            facesContext.addMessage(null, new FacesMessage("Unknown login, try again!"));
            _userPId = null;
            _password = null;
            return Page.LoginError.getRedirectUrl();
        } else {
            boolean hasUserVoted = _eVoter.hasUserVoted();
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
