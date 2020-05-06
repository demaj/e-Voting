package com.gentian.e.voting.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * This entity provides information about users
 * 
 * @author Gentian
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    
    // <editor-fold defaultstate="collapsed" desc="Property Personal Id">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_pid")
    private Long _id;

    public Long getId() {
        return _id;
    }

    public void setId(Long id) {
        _id = id;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Property Password">
    @Column(name="user_password")
    private String _password;

    public String getPassword() {
        return _password;
    }

    public void setPassword(String password) {
        _password = password;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Property Name">
    @Column(name="user_name")
    private String _name = "";

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Property City">
    @Column(name="user_city")
    private String _city = "";

    public String getCity() {
        return _city;
    }

    public void setCity(String city) {
        this._city = city;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Property User Voted">
    @Column(name="user_voted")
    private boolean _userVoted;

    public boolean hasUserVoted() {
        return _userVoted;
    }

    public void setUserVoted(boolean _userVoted) {
        this._userVoted = _userVoted;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="hashcode / equals / toString">
    @Override
    public int hashCode() {
        int hash = 0;
        hash += _id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        return Objects.equals(other.getId(), this._id);
    }

    @Override
    public String toString() {
        return "com.gentian.e.voting.entities.User[ id=" + _id + " ]";
    }
    // </editor-fold>
    
}
