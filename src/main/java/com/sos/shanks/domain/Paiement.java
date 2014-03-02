/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sos.shanks.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
    
}