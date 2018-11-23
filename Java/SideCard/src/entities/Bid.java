/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hikar
 */
@Entity
@Table(name = "BID")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bid.findAll", query = "SELECT b FROM Bid b")
    , @NamedQuery(name = "Bid.findByIdbid", query = "SELECT b FROM Bid b WHERE b.idbid = :idbid")})
public class Bid implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDBID")
    private Long idbid;
    @JoinColumn(name = "IDAUCTION", referencedColumnName = "IDAUCTION")
    @ManyToOne(optional = false)
    private Auction idauction;
    @JoinColumn(name = "IDSUPLIER", referencedColumnName = "IDSUPLIER")
    @ManyToOne(optional = false)
    private Suplier idsuplier;

    public Bid() {
    }

    public Bid(Long idbid) {
        this.idbid = idbid;
    }

    public Long getIdbid() {
        return idbid;
    }

    public void setIdbid(Long idbid) {
        this.idbid = idbid;
    }

    public Auction getIdauction() {
        return idauction;
    }

    public void setIdauction(Auction idauction) {
        this.idauction = idauction;
    }

    public Suplier getIdsuplier() {
        return idsuplier;
    }

    public void setIdsuplier(Suplier idsuplier) {
        this.idsuplier = idsuplier;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbid != null ? idbid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bid)) {
            return false;
        }
        Bid other = (Bid) object;
        if ((this.idbid == null && other.idbid != null) || (this.idbid != null && !this.idbid.equals(other.idbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Bid[ idbid=" + idbid + " ]";
    }
    
}
