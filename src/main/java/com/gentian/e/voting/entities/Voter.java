package com.gentian.e.voting.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Gentian
 */
@Entity
@Table(name = "votuesit")
public class Voter implements Serializable {

    private static final long serialVersionUID = 1L;
        
    // <editor-fold defaultstate="collapsed" desc="Property Personal Id">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "votuesi_pid")
    private int _personalId;

    public int getPersonalId() {
        return _personalId;
    }

    public void setPersonalId(int personalId) {
        _personalId = personalId;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Property First Name">
    @Column(name = "votuesi_emri")
    private String _firstName;

    public String getFirstName() {
        return _firstName;
    }

    public void setFirstName(String firstName) {
        _firstName = firstName;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Property Last Name">
    @Column(name = "votuesi_mbiemri")
    private String _lastName;

    public String getLastName() {
        return _lastName;
    }

    public void setLastName(String lastName) {
        _lastName = lastName;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Property Email">
    @Column(name = "votuesi_emaili")
    private String _email;

    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        _email = email;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Property City Id">
    @Column(name = "votuesi_qyteti_id")
    private Long _cityId;

    public Long getCityId() {
        return _cityId;
    }

    public void setCityId(Long cityId) {
        _cityId = cityId;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Property Address Id">
    @Column(name = "votuesi_adresa_id")
    private Long _addressId;

    public Long getAddressId() {
        return _addressId;
    }

    public void setAddressId(Long addressId) {
        _addressId = addressId;
    }
    // </editor-fold>

    /*
    // <editor-fold defaultstate="collapsed" desc="Property LoginInfo">
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "login_user", referencedColumnName = "votuesi_pid")
    private LoginInfo _loginInfo;

    public LoginInfo getLoginInfo() {
        return _loginInfo;
    }

    public void setLoginInfo(LoginInfo loginInfo) {
        _loginInfo = loginInfo;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Property EVoter">
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "zv_pid", referencedColumnName = "votuesi_pid")
    private EVoter _eVoter;

    public EVoter getEVoter() {
        return _eVoter;
    }

    public void setEVoter(EVoter eVoter) {
        _eVoter = eVoter;
    }
    // </editor-fold>
    */

    @Override
    public String toString() {
        return "Votuesi[ id=" + _personalId + ", Emri=" + _firstName + ", Mbiemri=" + _lastName +" ]";
    }
    
}
