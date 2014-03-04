/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sos.shanks.web;

import com.sos.exception.CatchException;
import com.sos.shanks.domain.Paiement;
import com.sos.shanks.service.PaiementFacade;
import com.sos.util.Loggable;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author mab.salhi
 */
@Named
@SessionScoped
@Loggable
@CatchException
public class PaiementController extends Controller implements Serializable {

    // ======================================
    // = Attributes =
    // ======================================
    @Inject
    private PaiementFacade paiementService;

    private Paiement current;
    private Paiement newPaiement;
    private List<Paiement> listPaiement;

    /**
     * Creates a new instance of PaiementController
     */
    public PaiementController() {
    }
    // ======================================
    // = Navigation Methods =
    // ======================================
    public String showList(){
        return "/paiement/list?faces-redirect=true";
    }
    public String showCreate(){
        newPaiement = new Paiement();
        return "/paiement/add?faces-redirect=true";
    }
    // ======================================
    // = Public Methods =
    // ======================================

    public List<Paiement> getAll() {
        return paiementService.findAll();
    }
    
    public String doCreate(){
        paiementService.create(newPaiement);
        return showList();
    }

    // ======================================
    // = Getters & setters =
    // ======================================
    public Paiement getCurrent() {
        return current;
    }

    public void setCurrent(Paiement current) {
        this.current = current;
    }

    public Paiement getNewPaiement() {
        return newPaiement;
    }

    public void setNewPaiement(Paiement newPaiement) {
        this.newPaiement = newPaiement;
    }
    
    // ======================================
    // = Converter =
    // ======================================
    public Paiement getPaiement(java.lang.Integer id) {
        return paiementService.find(id);
    }

    @FacesConverter(forClass = Paiement.class)
    public static class PaiementControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PaiementController controller = (PaiementController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "paiementController");
            return controller.getPaiement(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Paiement) {
                Paiement o = (Paiement) object;
                return getStringKey(o.getPaiementId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Paiement.class.getName());
            }
        }

    }
}
