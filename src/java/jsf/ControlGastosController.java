/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import beans.ControlGastos;
import ejb.ControlGastosFacade;
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
@Named(value = "controlGastosController")
@RequestScoped
public class ControlGastosController {

    @EJB
    ControlGastosFacade controlGastosFacade;
    
    private List<ControlGastos> controlGastosList;
    
    private ControlGastos controlGasto;
    
    /**
     * Creates a new instance of ControlGastosController
     */
    public ControlGastosController() {
        controlGasto = new ControlGastos();
    }
    
    public String nuevoGasto(){
        controlGastosFacade.create(getControlGasto());
        return "registroGastos?faces-redirect=true";
    }
    
    public List<ControlGastos> getGastosList() {
        return controlGastosFacade.findAll();
    }
    
    public String editarGasto(ControlGastos g){
        controlGasto = g;
        return "updateGasto";
    }
    
    public String modificarGasto(){
        controlGastosFacade.edit(controlGasto);
        return "registroGastos?faces-redirect=true";
    }
    
    public void eliminarGasto(int id){
        int idgasto = id;
        ControlGastos gastoid = controlGastosFacade.find(idgasto);
        controlGastosFacade.remove(gastoid);
        
        //Agrega un mensaje
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado", "Gasto Eliminado");
        FacesContext.getCurrentInstance().addMessage(null,message);
    }

    /**
     * @return the controlGasto
     */
    public ControlGastos getControlGasto() {
        return controlGasto;
    }

    /**
     * @param controlGasto the controlGasto to set
     */
    public void setControlGasto(ControlGastos controlGasto) {
        this.controlGasto = controlGasto;
    }    

}