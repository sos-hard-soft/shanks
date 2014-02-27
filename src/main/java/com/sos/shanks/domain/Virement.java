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
@Table(name = "t_virement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Virement.findAll", query = "SELECT c FROM Virement c"),
    @NamedQuery(name = "Virement.findByVirementId", query = "SELECT c FROM Virement c WHERE c.virementId = :virementId")})
public class Virement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "virement_id")
    private Integer virementId;
    @Column(name = "date_virement")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateVirement;
    @Size(max = 350)
    @Column(name = "numero_virement")
    private String numeroVirement;
    @Size(max = 350)
    @Column(name = "numero_compte")
    private String numeroCompte;
    @Column(name = "montant_virement")
    private double montantVirement;
    @Size(max = 350)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "paiement", referencedColumnName = "paiement_id")
    @ManyToOne
    private Paiement paiement;

    public Virement() {
    }

    public Integer getVirementId() {
        return virementId;
    }

    public void setVirementId(Integer virementId) {
        this.virementId = virementId;
    }

    public Date getDateVirement() {
        return dateVirement;
    }

    public void setDateVirement(Date dateVirement) {
        this.dateVirement = dateVirement;
    }

    public String getNumeroVirement() {
        return numeroVirement;
    }

    public void setNumeroVirement(String numeroVirement) {
        this.numeroVirement = numeroVirement;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public double getMontantVirement() {
        return montantVirement;
    }

    public void setMontantVirement(double montantVirement) {
        this.montantVirement = montantVirement;
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
        hash = 97 * hash + Objects.hashCode(this.virementId);
        hash = 97 * hash + Objects.hashCode(this.dateVirement);
        hash = 97 * hash + Objects.hashCode(this.numeroVirement);
        hash = 97 * hash + Objects.hashCode(this.numeroCompte);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.montantVirement) ^ (Double.doubleToLongBits(this.montantVirement) >>> 32));
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
        final Virement other = (Virement) obj;
        if (!Objects.equals(this.virementId, other.virementId)) {
            return false;
        }
        if (!Objects.equals(this.dateVirement, other.dateVirement)) {
            return false;
        }
        if (!Objects.equals(this.numeroVirement, other.numeroVirement)) {
            return false;
        }
        if (!Objects.equals(this.numeroCompte, other.numeroCompte)) {
            return false;
        }
        if (Double.doubleToLongBits(this.montantVirement) != Double.doubleToLongBits(other.montantVirement)) {
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
        return "Virement{" + "numeroVirement=" + numeroVirement + ", numeroCompte=" + numeroCompte + ", montantVirement=" + montantVirement + '}';
    }
    
    
}