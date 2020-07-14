package com.gentian.e.voting.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Gentian
 */
@Entity
@Table(name = "kandidatet")
public class Candidate implements Serializable {

    private static final long serialVersionUID = 1L;

    // <editor-fold defaultstate="collapsed" desc="Property Id">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kandidati_id")
    private int _id;

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        _id= id;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Property First Name">
    @Column(name = "kandidati_emri")
    private String _firstName;

    public String getFirstName() {
        return _firstName;
    }

    public void setFirstName(String firstName) {
        _firstName = firstName;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Property Last Name">
    @Column(name = "kandidati_mbiemri")
    private String _lastName;

    public String getLastName() {
        return _lastName;
    }

    public void setLastName(String lastName) {
        _lastName = lastName;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Property Birthday">
    @Column(name = "kandidati_datelindja")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date _birthday;

    public Date getBirthday() {
        return _birthday;
    }

    public void setBirthday(Date birthday) {
        _birthday = birthday;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Property Email">
    @Column(name = "kandidati_emaili")
    private String _email;

    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        _email = email;
    }
    // </editor-fold>
    
    @Override
    public String toString() {
        return "Kandidati[ Id=" + _id + ", "
                + "Emri=" + _firstName + ", "
                + "Mbiemri=" + _lastName + " ]";
    }
    
}
