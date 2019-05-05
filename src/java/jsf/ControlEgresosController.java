/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import beans.ControlEgresos;
import ejb.ControlEgresosFacade;
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
@Named(value = "controlEgresosController")
@RequestScoped
public class ControlEgresosController {
    
    @EJB
    ControlEgresosFacade controlEgresosFacade;
    
    private List<ControlEgresos> controlList;
    
    private ControlEgresos controlEgresos;

    /**
     * Creates a new instance of ControlEgresosController
     */
    public ControlEgresosController() {
        controlEgresos = new ControlEgresos();
    }
    
    public String nuevoEgreso(){
        controlEgresosFacade.create(getControlEgresos());
        return "registroEgresos?faces-redirect=true";
    }
    
    public List<ControlEgresos> getEgresosList() {
        return controlEgresosFacade.findAll();
    }
    
    public String editarEgreso(ControlEgresos e){
        controlEgresos = e;
        return "updateEgreso";
    }
    
    public String modificarEgreso(){
        controlEgresosFacade.edit(controlEgresos);
        return "registroEgresos?faces-redirect=true";
    }
    
    public void eliminarEgreso(int id){
        int idcontrolEgresos = id;
        ControlEgresos egresoid = controlEgresosFacade.find(idcontrolEgresos);
        controlEgresosFacade.remove(egresoid);
        
        //Agrega un mensaje
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado", "Egreso Eliminado");
        FacesContext.getCurrentInstance().addMessage(null,message);
    }

    /**
     * @return the controlEgresos
     */
    public ControlEgresos getControlEgresos() {
        return controlEgresos;
    }

    /**
     * @param controlEgresos the controlEgresos to set
     */
    public void setControlEgresos(ControlEgresos controlEgresos) {
        this.controlEgresos = controlEgresos;
    }
    
}
