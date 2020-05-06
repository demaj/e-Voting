package com.gentian.e.voting.user;

import com.gentian.e.voting.entities.User;
import com.gentian.e.voting.enums.Page;
import com.gentian.e.voting.helper.SessionTools;
import com.gentian.e.voting.services.UserService;
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
@Named(value = "login")
@SessionScoped
public class UserController implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private static final Logger _logger = Logger.getLogger("UserController");
    
    @Inject private SessionTools _sessionTools;
    @Inject private UserService _userService;

    // <editor-fold defaultstate="collapsed" desc="Property User">
    private User _user;

    public User getUser() {
        return _user;
    }

    public void setUser(User _user) {
        this._user = _user;
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
        this._password = password;
    }
    // </editor-fold>
    
    public String login() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        _logger.log(Level.INFO, "Username: {0}", _userPId);
        _logger.log(Level.INFO, "Password: {0}", _password);
        _user = _userService.find(_userPId, _password);
        if (_user == null) {
            facesContext.addMessage(null, new FacesMessage("Unknown login, try again!"));
            _userPId = null;
            _password = null;
            return Page.LoginError.getRedirectUrl();
        } else {
            boolean hasUserVoted = _user.hasUserVoted();
            if (hasUserVoted) {
                facesContext.addMessage(null, new FacesMessage("You have voted already!"));
                return Page.UserHasVoted.getRedirectUrl();
            } else {
                facesContext.getExternalContext().getSessionMap().put("user", _user);
                return Page.VoteSubject.getRedirectUrl();
            }
        }
    }
    
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return Page.ThankYou.getRedirectUrl();
    }
    
}
