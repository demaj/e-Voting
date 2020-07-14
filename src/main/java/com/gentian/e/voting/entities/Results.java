/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author genti
 */
@Entity
@Table(name = "rezultatet_subjektet")
public class Results implements Serializable {

    private static final long serialVersionUID = 14L;

    // <editor-fold defaultstate="collapsed" desc="Property Subject Id">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subjekti_id")
    private Long _id;

    public Long getId() {
        return _id;
    }

    public void setId(Long id) {
        _id = id;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Property Subject Number">
    @Column(name = "subjekti_numri")
    private Long _number;

    public Long getNumber() {
        return _number;
    }

    public void setNumber(Long number) {
        _number = number;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Property Subject Name">
    @Column(name = "subjekti_emri")
    private String _name;

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Property Subject Number of votes">
    @Column(name = "numri_i_votave")
    private Long _numberOfVotes;

    public Long getNumberOfVotes() {
        return _numberOfVotes;
    }

    public void setNumberOfVotes(Long numberOfVotes) {
        _numberOfVotes = numberOfVotes;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Property equals / hashCode / toString">
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (_id != null ? _id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Results)) {
            return false;
        }
        Results other = (Results) object;
        if ((_id == null && other.getId() != null) || (_id != null && !_id.equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Results[ id=" + _id + " ]";
    }
    // </editor-fold>
    
}
