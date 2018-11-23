/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hikar
 */
@Entity
@Table(name = "SUPLIER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Suplier.findAll", query = "SELECT s FROM Suplier s")
    , @NamedQuery(name = "Suplier.findByIdsuplier", query = "SELECT s FROM Suplier s WHERE s.idsuplier = :idsuplier")
    , @NamedQuery(name = "Suplier.findByName", query = "SELECT s FROM Suplier s WHERE s.name = :name")
    , @NamedQuery(name = "Suplier.findByEmail", query = "SELECT s FROM Suplier s WHERE s.email = :email")})
public class Suplier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDSUPLIER")
    private Long idsuplier;
    @Size(max = 80)
    @Column(name = "NAME")
    private String name;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 250)
    @Column(name = "EMAIL")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "suplier")
    private List<Auctionsuplier> auctionsuplierList;
    @JoinColumn(name = "IDUSER", referencedColumnName = "IDUSER")
    @ManyToOne
    private Usuario iduser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsuplier")
    private List<Bid> bidList;

    public Suplier() {
    }

    public Suplier(Long idsuplier) {
        this.idsuplier = idsuplier;
    }

    public Long getIdsuplier() {
        return idsuplier;
    }

    public void setIdsuplier(Long idsuplier) {
        this.idsuplier = idsuplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public List<Auctionsuplier> getAuctionsuplierList() {
        return auctionsuplierList;
    }

    public void setAuctionsuplierList(List<Auctionsuplier> auctionsuplierList) {
        this.auctionsuplierList = auctionsuplierList;
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
        hash += (idsuplier != null ? idsuplier.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Suplier)) {
            return false;
        }
        Suplier other = (Suplier) object;
        if ((this.idsuplier == null && other.idsuplier != null) || (this.idsuplier != null && !this.idsuplier.equals(other.idsuplier))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Suplier[ idsuplier=" + idsuplier + " ]";
    }
    
}
