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
 * @author Gentian
 */
@Entity
@Table(name = "candidates")
public class Candidate implements Serializable {

    private static final long serialVersionUID = 1L;
    
    // <editor-fold defaultstate="collapsed" desc="Property Id">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidate_id")
    private Long _id;

    public Long getId() {
        return _id;
    }

    public void setId(Long id) {
        _id = id;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Property Candidate Name">
    @Column(name = "candidate_name")
    private String _candidateName = "";

    public String getCandidateName() {
        return _candidateName;
    }

    public void setCandidateName(String _candidateName) {
        this._candidateName = _candidateName;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Property Candidate Number">
    @Column(name = "candidate_number")
    private int _candidateNumber = -1;
    
    public int getCandidateNumber() {
        return _candidateNumber;
    }

    public void setCandidateNumber(int candidateNumber) {
        this._candidateNumber = candidateNumber;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Property Candidate Subject Number">
    @Column(name = "candidate_subject_number")
    private int _candidateSubjectNumber = -1;

    public int getCandidateSubjectNumber() {
        return _candidateSubjectNumber;
    }

    public void setCandidateSubjectNumber(int candidateSubjectNumber) {
        this._candidateSubjectNumber = candidateSubjectNumber;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Property Candidate Number Of Votes">
    @Column(name = "candidate_number_of_votes")
    private long _candidateNumberOfVotes;

    public long getCandidateNumberOfVotes() {
        return _candidateNumberOfVotes;
    }

    public void setCandidateNumberOfVotes(long candidateNumberOfVotes) {
        _candidateNumberOfVotes = candidateNumberOfVotes;
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
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Candidate)) {
            return false;
        }
        Candidate other = (Candidate) object;
        return Objects.equals(_id, other.getId());
    }

    @Override
    public String toString() {
        return "com.gentian.e.voting.entities.Candidates[ id=" + _id + " ]";
    }
    // </editor-fold>
    
}
