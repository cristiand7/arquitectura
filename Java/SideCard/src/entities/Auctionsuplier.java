/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hikar
 */
@Entity
@Table(name = "AUCTIONSUPLIER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auctionsuplier.findAll", query = "SELECT a FROM Auctionsuplier a")
    , @NamedQuery(name = "Auctionsuplier.findByIdauction", query = "SELECT a FROM Auctionsuplier a WHERE a.auctionsuplierPK.idauction = :idauction")
    , @NamedQuery(name = "Auctionsuplier.findByIdsuplier", query = "SELECT a FROM Auctionsuplier a WHERE a.auctionsuplierPK.idsuplier = :idsuplier")
    , @NamedQuery(name = "Auctionsuplier.findByOffer", query = "SELECT a FROM Auctionsuplier a WHERE a.offer = :offer")
    , @NamedQuery(name = "Auctionsuplier.findByWin", query = "SELECT a FROM Auctionsuplier a WHERE a.win = :win")})
public class Auctionsuplier implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AuctionsuplierPK auctionsuplierPK;
    @Size(max = 80)
    @Column(name = "OFFER")
    private String offer;
    @Column(name = "WIN")
    private Short win;
    @JoinColumn(name = "IDAUCTION", referencedColumnName = "IDAUCTION", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Auction auction;
    @JoinColumn(name = "IDSUPLIER", referencedColumnName = "IDSUPLIER", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Suplier suplier;

    public Auctionsuplier() {
    }

    public Auctionsuplier(AuctionsuplierPK auctionsuplierPK) {
        this.auctionsuplierPK = auctionsuplierPK;
    }

    public Auctionsuplier(long idauction, long idsuplier) {
        this.auctionsuplierPK = new AuctionsuplierPK(idauction, idsuplier);
    }

    public AuctionsuplierPK getAuctionsuplierPK() {
        return auctionsuplierPK;
    }

    public void setAuctionsuplierPK(AuctionsuplierPK auctionsuplierPK) {
        this.auctionsuplierPK = auctionsuplierPK;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public Short getWin() {
        return win;
    }

    public void setWin(Short win) {
        this.win = win;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public Suplier getSuplier() {
        return suplier;
    }

    public void setSuplier(Suplier suplier) {
        this.suplier = suplier;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (auctionsuplierPK != null ? auctionsuplierPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auctionsuplier)) {
            return false;
        }
        Auctionsuplier other = (Auctionsuplier) object;
        if ((this.auctionsuplierPK == null && other.auctionsuplierPK != null) || (this.auctionsuplierPK != null && !this.auctionsuplierPK.equals(other.auctionsuplierPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Auctionsuplier[ auctionsuplierPK=" + auctionsuplierPK + " ]";
    }
    
}
