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
@Table(name = "zgjedhjet_votuesit")
public class EVoter implements Serializable {

    private static final long serialVersionUID = 1L;

    // <editor-fold defaultstate="collapsed" desc="Property Personal Id">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "zv_pid")
    private Long _pid;

    public Long getPId() {
        return _pid;
    }

    public void setPId(Long pid) {
        _pid = pid;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Property User Voted">
    @Column(name="zv_ka_votuar")
    private boolean _userVoted;

    public boolean hasUserVoted() {
        return _userVoted;
    }

    public void setUserVoted(boolean userVoted) {
        _userVoted = userVoted;
    }
    // </editor-fold>

    @Override
    public String toString() {
        return "EVoter[ id=" + _pid + ",  ]";
    }
    
}
