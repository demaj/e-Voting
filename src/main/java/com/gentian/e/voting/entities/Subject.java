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
@Table(name = "subjektet")
public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;
    
    // <editor-fold defaultstate="collapsed" desc="Property Id">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subjekti_id")
    private int _id;

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        _id = id;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Property Name">
    @Column(name = "subjekti_emri")
    private String _name;

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }
    // </editor-fold>

    /*
    // <editor-fold defaultstate="collapsed" desc="Property ESubject">
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "zs_subjekti_id", referencedColumnName = "subjekti_id")
    private ESubject _eSubject;

    public ESubject getESubject() {
        return _eSubject;
    }

    public void setESubject(ESubject eSubject) {
        _eSubject = eSubject;
    }
    // </editor-fold>
    */
    
    @Override
    public String toString() {
        return "Subjekti[ Id=" + _id + ", Emri=" + _name + " ]";
    }
    
}
