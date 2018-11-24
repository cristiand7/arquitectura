/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sala a
 */
@Entity
@Table(name = "DETERMINEWINNERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Determinewinners.findAll", query = "SELECT d FROM Determinewinners d")
    , @NamedQuery(name = "Determinewinners.findById", query = "SELECT d FROM Determinewinners d WHERE d.id = :id")
    , @NamedQuery(name = "Determinewinners.findByOferta", query = "SELECT d FROM Determinewinners d WHERE d.oferta = :oferta")
    , @NamedQuery(name = "Determinewinners.findBySuplier", query = "SELECT d FROM Determinewinners d WHERE d.suplier = :suplier")
    , @NamedQuery(name = "Determinewinners.findByFecha", query = "SELECT d FROM Determinewinners d WHERE d.fecha = :fecha")})
public class Determinewinners implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "OFERTA")
    private Long oferta;
    @Size(max = 80)
    @Column(name = "SUPLIER")
    private String suplier;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    public Determinewinners() {
    }

    public Determinewinners(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Long getOferta() {
        return oferta;
    }

    public void setOferta(Long oferta) {
        this.oferta = oferta;
    }

    public String getSuplier() {
        return suplier;
    }

    public void setSuplier(String suplier) {
        this.suplier = suplier;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Determinewinners)) {
            return false;
        }
        Determinewinners other = (Determinewinners) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Determinewinners[ id=" + id + " ]";
    }
    
}
