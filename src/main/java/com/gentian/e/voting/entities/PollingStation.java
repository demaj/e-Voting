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
@Table(name = "vendvotimet")
public class PollingStation implements Serializable {

    private static final long serialVersionUID = 1L;

    // <editor-fold defaultstate="collapsed" desc="Property Id">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vendvotimi_id")

    private Long _id;

    public Long getId() {
        return _id;
    }

    public void setId(Long id) {
        _id = id;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Property Code">
    @Column(name = "vendvotimi_kodi")
    private String _code;

    public String getCode() {
        return _code;
    }

    public void setCode(String code) {
        _code = code;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Property City Id">
    @Column(name = "vendvotimi_qyteti_id")
    private int _cityId;

    public int getCityId() {
        return _cityId;
    }

    public void setCityId(int cityId) {
        _cityId = cityId;
    }
    // </editor-fold>

    @Override
    public String toString() {
        return "Vendvotimi[ id=" + _id + ", Kodi=" + _code +", Qyteti=" + _cityId +" ]";
    }
    
}
