/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import beans.Factura;
import ejb.FacturaFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author eduje
 */
@Named(value = "facturaController")
@RequestScoped
public class FacturaController {
    
    @EJB
    FacturaFacade facturaFacade;
    
    private List<Factura> facturaList;
    
    private Factura factura;

    /**
     * Creates a new instance of FacturaController
     */
    public FacturaController() {
        factura = new Factura();
    }
    
    public String nuevaFactura(){
        facturaFacade.create(getFactura());
        return "registroFacturas?faces-redirect=true";
    }
    
    public List<Factura> getFacturaList() {
        return facturaFacade.findAll();
    }
    
     public String editarFactura(Factura f){
        factura = f;
        return "updateFactura";
    }
     
     public String modificarFactura(){
        facturaFacade.edit(getFactura());
        return "registroFacturas?faces-redirect=true";
    }
     
     public void eliminarFactura(int id){
        int id_factura = id;
        Factura facturaid = facturaFacade.find(id_factura);
        facturaFacade.remove(facturaid);
        
        //Agrega un mensaje
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminada", "Factura Eliminada");
        FacesContext.getCurrentInstance().addMessage(null,message);   
    }

    /**
     * @return the factura
     */
    public Factura getFactura() {
        return factura;
    }

    /**
     * @param factura the factura to set
     */
    public void setFactura(Factura factura) {
        this.factura = factura;
    }
     
}
