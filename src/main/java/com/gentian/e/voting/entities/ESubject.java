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
@Table(name = "zgjedhjet_subjektet")
public class ESubject implements Serializable {

    private static final long serialVersionUID = 1L;
    
    // <editor-fold defaultstate="collapsed" desc="Property Id">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "zs_subjekti_id")
    private Long _id;

    public Long getId() {
        return _id;
    }

    public void setId(Long id) {
        _id = id;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Property Number">
    @Column(name = "zs_subjekti_numri")
    private Integer _number;

    public Integer getNumber() {
        return _number;
    }

    public void setNumber(Integer number) {
        _number = number;
    }
    // </editor-fold>

    @Override
    public String toString() {
        return "ElectionSubject[ Id=" + _id + ", Number=" + _number + " ]";
    }
    
}
