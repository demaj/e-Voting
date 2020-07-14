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
@Table(name = "adresat")
public class Address implements Serializable {

    private static final long serialVersionUID = 42L;

    // <editor-fold defaultstate="collapsed" desc="Property Id">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adresa_id")
    private Long _id;

    public Long getId() {
        return _id;
    }

    public void setId(Long id) {
        _id = id;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Property Name">
    @Column(name = "adresa_emri")
    private String _name;

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Property City Id">
    @Column(name = "adresa_qyteti_id")
    private Long _cityId;

    public Long getCityId() {
        return _cityId;
    }

    public void setCityId(Long cityId) {
        _cityId = cityId;
    }
    // </editor-fold>

    @Override
    public String toString() {
        return "Adresat[ id=" + _id + ", Emri=" + _name + ", QytetiId=" + _cityId + " ]";
    }
    
}
