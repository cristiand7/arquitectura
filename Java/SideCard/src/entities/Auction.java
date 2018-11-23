/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hikar
 */
@Entity
@Table(name = "AUCTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auction.findAll", query = "SELECT a FROM Auction a")
    , @NamedQuery(name = "Auction.findByIdauction", query = "SELECT a FROM Auction a WHERE a.idauction = :idauction")
    , @NamedQuery(name = "Auction.findByStartdate", query = "SELECT a FROM Auction a WHERE a.startdate = :startdate")
    , @NamedQuery(name = "Auction.findByClosedate", query = "SELECT a FROM Auction a WHERE a.closedate = :closedate")})
public class Auction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDAUCTION")
    private Long idauction;
    @Column(name = "STARTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdate;
    @Column(name = "CLOSEDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date closedate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "auction")
    private List<Auctionsuplier> auctionsuplierList;
    @OneToMany(mappedBy = "idauction")
    private List<Product> productList;
    @JoinColumn(name = "IDUSER", referencedColumnName = "IDUSER")
    @ManyToOne
    private Usuario iduser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idauction")
    private List<Bid> bidList;

    public Auction() {
    }

    public Auction(Long idauction) {
        this.idauction = idauction;
    }

    public Long getIdauction() {
        return idauction;
    }

    public void setIdauction(Long idauction) {
        this.idauction = idauction;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getClosedate() {
        return closedate;
    }

    public void setClosedate(Date closedate) {
        this.closedate = closedate;
    }

    @XmlTransient
    public List<Auctionsuplier> getAuctionsuplierList() {
        return auctionsuplierList;
    }

    public void setAuctionsuplierList(List<Auctionsuplier> auctionsuplierList) {
        this.auctionsuplierList = auctionsuplierList;
    }

    @XmlTransient
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Usuario getIduser() {
        return iduser;
    }

    public void setIduser(Usuario iduser) {
        this.iduser = iduser;
    }

    @XmlTransient
    public List<Bid> getBidList() {
        return bidList;
    }

    public void setBidList(List<Bid> bidList) {
        this.bidList = bidList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idauction != null ? idauction.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auction)) {
            return false;
        }
        Auction other = (Auction) object;
        if ((this.idauction == null && other.idauction != null) || (this.idauction != null && !this.idauction.equals(other.idauction))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Auction[ idauction=" + idauction + " ]";
    }
    
}
