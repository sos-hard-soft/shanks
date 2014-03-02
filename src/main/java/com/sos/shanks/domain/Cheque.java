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
@Table(name = "t_cheque")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cheque.findAll", query = "SELECT c FROM Cheque c"),
    @NamedQuery(name = "Cheque.findByChequeId", query = "SELECT c FROM Cheque c WHERE c.chequeId = :chequeId")})
public class Cheque implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cheque_id")
    private Integer chequeId;
    @Column(name = "date_cheque")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCheque;
    @Size(max = 350)
    @Column(name = "numero_cheque")
    private String numeroCheque;
    @Size(max = 350)
    @Column(name = "numero_compte")
    private String numeroCompte;
    @Column(name = "montant_cheque")
    private double montantCheque;
    @Size(max = 350)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "paiement", referencedColumnName = "paiement_id")
    @ManyToOne
    private Paiement paiement;

    public Cheque() {
    }

    public Integer getChequeId() {
        return chequeId;
    }

    public void setChequeId(Integer chequeId) {
        this.chequeId = chequeId;
    }

    public Date getDateCheque() {
        return dateCheque;
    }

    public void setDateCheque(Date dateCheque) {
        this.dateCheque = dateCheque;
    }

    public String getNumeroCheque() {
        return numeroCheque;
    }

    public void setNumeroCheque(String numeroCheque) {
        this.numeroCheque = numeroCheque;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public double getMontantCheque() {
        return montantCheque;
    }

    public void setMontantCheque(double montantCheque) {
        this.montantCheque = montantCheque;
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
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.chequeId);
        hash = 29 * hash + Objects.hashCode(this.dateCheque);
        hash = 29 * hash + Objects.hashCode(this.numeroCheque);
        hash = 29 * hash + Objects.hashCode(this.numeroCompte);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.montantCheque) ^ (Double.doubleToLongBits(this.montantCheque) >>> 32));
        hash = 29 * hash + Objects.hashCode(this.description);
        hash = 29 * hash + Objects.hashCode(this.paiement);
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
        final Cheque other = (Cheque) obj;
        if (!Objects.equals(this.chequeId, other.chequeId)) {
            return false;
        }
        if (!Objects.equals(this.dateCheque, other.dateCheque)) {
            return false;
        }
        if (!Objects.equals(this.numeroCheque, other.numeroCheque)) {
            return false;
        }
        if (!Objects.equals(this.numeroCompte, other.numeroCompte)) {
            return false;
        }
        if (Double.doubleToLongBits(this.montantCheque) != Double.doubleToLongBits(other.montantCheque)) {
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
        return "Cheque{" + "numeroCheque=" + numeroCheque + ", numeroCompte=" + numeroCompte + ", montantCheque=" + montantCheque + '}';
    }
    
    
}