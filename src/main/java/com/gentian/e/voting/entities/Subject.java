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
@Table(name = "subjects")
public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;
    
    // <editor-fold defaultstate="collapsed" desc="Property Id">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Long _id;

    public Long getId() {
        return _id;
    }

    public void setId(Long id) {
        _id = id;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Property Subject Name">
    @Column(name = "subject_name")
    private String _subjectName = "";

    public String getSubjectName() {
        return _subjectName;
    }

    public void setSubjectName(String subjectName) {
        this._subjectName = subjectName;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Property Subject Number">
    @Column(name = "subject_number")
    private int _subjectNumber = -1;

    public int getSubjectNumber() {
        return _subjectNumber;
    }

    public void setSubjectNumber(int subjectNumber) {
        this._subjectNumber = subjectNumber;
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
        if (!(object instanceof Subject)) {
            return false;
        }
        Subject other = (Subject) object;
        return Objects.equals(this._id, other.getId());
    }

    @Override
    public String toString() {
        return "com.gentian.e.voting.entities.Subjects[ id=" + _id + " ]";
    }
    // </editor-fold>
    
}
