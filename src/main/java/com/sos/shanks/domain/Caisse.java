/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sos.shanks.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mab.salhi
 */
@Entity
@Table(name = "t_caisse")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caisse.findAll", query = "SELECT c FROM Caisse c"),
    @NamedQuery(name = "Caisse.findByCaisseId", query = "SELECT c FROM Caisse c WHERE c.caisseId = :caisseId")})
public class Caisse implements Serializable {
    // ======================================
    // = Attributes =
    // ======================================
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "caisse_id")
    private Integer caisseId;
    @Column(name = "date_retrait_caisse")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateRetraitCaisse;
    @Column(name = "montant")
    private double montant;
    @Size(max = 350)
    @Column(name = "realisateur")
    private String realisateur;
    @Size(max = 350)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "paiement", referencedColumnName = "paiement_id")
    @ManyToOne
    private Paiement paiement;
    
    // ======================================
    // = Constuctor =
    // ======================================
    public Caisse() {
    }

    public Integer getCaisseId() {
        return caisseId;
    }

    public void setCaisseId(Integer caisseId) {
        this.caisseId = caisseId;
    }

    public Date getDateRetraitCaisse() {
        return dateRetraitCaisse;
    }

    public void setDateRetraitCaisse(Date dateRetraitCaisse) {
        this.dateRetraitCaisse = dateRetraitCaisse;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Paiement getPaiement() {
        return paiement;
    }

    public void setPaiement(Paiement paiement) {
        this.paiement = paiement;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.caisseId);
        hash = 97 * hash + Objects.hashCode(this.dateRetraitCaisse);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.montant) ^ (Double.doubleToLongBits(this.montant) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.realisateur);
        hash = 97 * hash + Objects.hashCode(this.description);
        hash = 97 * hash + Objects.hashCode(this.paiement);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Caisse other = (Caisse) obj;
        if (!Objects.equals(this.caisseId, other.caisseId)) {
            return false;
        }
        if (!Objects.equals(this.dateRetraitCaisse, other.dateRetraitCaisse)) {
            return false;
        }
        if (Double.doubleToLongBits(this.montant) != Double.doubleToLongBits(other.montant)) {
            return false;
        }
        if (!Objects.equals(this.realisateur, other.realisateur)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.paiement, other.paiement)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Caisse{" + "montant=" + montant + ", realisateur=" + realisateur + '}';
    }
    
    
}
