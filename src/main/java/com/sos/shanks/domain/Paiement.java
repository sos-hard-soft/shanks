/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sos.shanks.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mab.salhi
 */
@Entity
@Table(name = "t_paiement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paiement.findAll", query = "SELECT c FROM Paiement c"),
    @NamedQuery(name = "Paiement.findByPaiementId", query = "SELECT c FROM Paiement c WHERE c.paiementId = :paiementId")})
public class Paiement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "paiement_id")
    private Integer paiementId;
    @Column(name = "numero")
    private String numero;
    @Column(name = "date_paiement")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datePaiement;
    @Size(max = 350)
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "paiement")
    private List<Cheque> chequeList;
    @OneToMany(mappedBy = "paiement")
    private List<Virement> virementList;
    @OneToMany(mappedBy = "paiement")
    private List<Caisse> reglementCaisseList;
    @JoinColumn(name = "facture", referencedColumnName = "facture_id")
    @ManyToOne
    private Facture facture;

    public Paiement() {
    }

    public Integer getPaiementId() {
        return paiementId;
    }

    public void setPaiementId(Integer paiementId) {
        this.paiementId = paiementId;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    public Date getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Cheque> getChequeList() {
        return chequeList;
    }

    public void setChequeList(List<Cheque> chequeList) {
        this.chequeList = chequeList;
    }

    public List<Virement> getVirementList() {
        return virementList;
    }

    public void setVirementList(List<Virement> virementList) {
        this.virementList = virementList;
    }

    public List<Caisse> getReglementCaisseList() {
        return reglementCaisseList;
    }

    public void setReglementCaisseList(List<Caisse> reglementCaisseList) {
        this.reglementCaisseList = reglementCaisseList;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.paiementId);
        hash = 17 * hash + Objects.hashCode(this.datePaiement);
        hash = 17 * hash + Objects.hashCode(this.numero);
        hash = 17 * hash + Objects.hashCode(this.description);
        hash = 17 * hash + Objects.hashCode(this.chequeList);
        hash = 17 * hash + Objects.hashCode(this.virementList);
        hash = 17 * hash + Objects.hashCode(this.reglementCaisseList);
        hash = 17 * hash + Objects.hashCode(this.facture);
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
        final Paiement other = (Paiement) obj;
        if (!Objects.equals(this.paiementId, other.paiementId)) {
            return false;
        }
        if (!Objects.equals(this.datePaiement, other.datePaiement)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.chequeList, other.chequeList)) {
            return false;
        }
        if (!Objects.equals(this.virementList, other.virementList)) {
            return false;
        }
        if (!Objects.equals(this.reglementCaisseList, other.reglementCaisseList)) {
            return false;
        }
        if (!Objects.equals(this.facture, other.facture)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Paiement{" + "datePaiement=" + datePaiement + ", facture=" + facture + '}';
    }
    
    
}