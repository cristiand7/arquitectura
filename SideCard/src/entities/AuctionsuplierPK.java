/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author hikar
 */
@Embeddable
public class AuctionsuplierPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "IDAUCTION")
    private long idauction;
    @Basic(optional = false)
    @Column(name = "IDSUPLIER")
    private long idsuplier;

    public AuctionsuplierPK() {
    }

    public AuctionsuplierPK(long idauction, long idsuplier) {
        this.idauction = idauction;
        this.idsuplier = idsuplier;
    }

    public long getIdauction() {
        return idauction;
    }

    public void setIdauction(long idauction) {
        this.idauction = idauction;
    }

    public long getIdsuplier() {
        return idsuplier;
    }

    public void setIdsuplier(long idsuplier) {
        this.idsuplier = idsuplier;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idauction;
        hash += (int) idsuplier;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuctionsuplierPK)) {
            return false;
        }
        AuctionsuplierPK other = (AuctionsuplierPK) object;
        if (this.idauction != other.idauction) {
            return false;
        }
        if (this.idsuplier != other.idsuplier) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AuctionsuplierPK[ idauction=" + idauction + ", idsuplier=" + idsuplier + " ]";
    }
    
}
