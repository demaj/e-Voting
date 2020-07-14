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
@Table(name = "zgjedhjet_kandidatet")
public class ECandidate implements Serializable {

    private static final long serialVersionUID = 1L;
    
    // <editor-fold defaultstate="collapsed" desc="Property Id">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "zk_kandidati_id")
    private Long _id;

    public Long getId() {
        return _id;
    }

    public void setId(Long id) {
        _id = id;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Property Number">
    @Column(name = "zk_kandidati_numri")
    private Long _number;

    public Long getNumber() {
        return _number;
    }

    public void setNumber(Long number) {
        _number = number;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Property Subject Id">
    @Column(name = "zk_subjekti_id")
    private Long _candidateSubjectId;

    public Long getCandidateSubjectId() {
        return _candidateSubjectId;
    }

    public void setCandidateSubjectId(Long candidateSubjectId) {
        _candidateSubjectId = candidateSubjectId;
    }
    // </editor-fold>

    @Override
    public String toString() {
        return "ElectionCandidate[ Id=" + _id + ", Number=" + _number + " ]";
    }
    
}
