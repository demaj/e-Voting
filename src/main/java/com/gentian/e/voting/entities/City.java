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
@Table(name = "qytetet")
public class City implements Serializable {

    private static final long serialVersionUID = 1L;
    
    // <editor-fold defaultstate="collapsed" desc="Property Id">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qyteti_id")
    private Long _id;

    public Long getId() {
        return _id;
    }

    public void setId(Long id) {
        _id = id;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Property Name">
    @Column(name = "qyteti_emri")
    private String _name;

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }
    // </editor-fold>

    @Override
    public String toString() {
        return "Qyteti[ Id=" + _id + ", Emri=" + _name +" ]";
    }
    
}
