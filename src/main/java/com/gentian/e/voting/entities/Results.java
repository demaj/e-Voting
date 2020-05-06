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
@Table(name = "voting_results")
public class Results implements Serializable {

    private static final long serialVersionUID = 1L;
    
    // <editor-fold defaultstate="collapsed" desc="Property Subject Number">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_number")
    private Long _subjectNumber;

    public Long getSubjectNumber() {
        return _subjectNumber;
    }

    public void setSubjectNumber(Long _subjectNumber) {
        this._subjectNumber = _subjectNumber;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Property Subject Name">
    @Column(name = "subject_name")
    private String _subjectName;

    public String getSubjectName() {
        return _subjectName;
    }

    public void setSubjectName(String subjectName) {
        _subjectName = subjectName;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Property Subject Votes">
    @Column(name = "subject_votes")
    private int _subjectVotes;

    public int getSubjectVotes() {
        return _subjectVotes;
    }

    public void setSubjectVotes(int _subjectVotes) {
        this._subjectVotes = _subjectVotes;
    }
    // </editor-fold>
    
}
