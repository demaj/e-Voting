package com.gentian.e.voting.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Gentian
 */
@Entity
@Table(name = "login_info")
public class LoginInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    // <editor-fold defaultstate="collapsed" desc="Property Login User">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "login_user")
    private int _loginUser;

    public int getLoginUser() {
        return _loginUser;
    }

    public void setLoginUser(int loginUser) {
        _loginUser = loginUser;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Property Login Password">
    @Column(name="login_password")
    private String _password;

    public String getPassword() {
        return _password;
    }

    public void setPassword(String password) {
        _password = password;
    }
    // </editor-fold>

    @Override
    public String toString() {
        return "LoginInfo[ login_user=" + _loginUser + " ]";
    }
    
}
