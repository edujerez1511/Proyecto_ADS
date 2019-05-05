/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import beans.Movimiento;
import ejb.MovimientoFacade;
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
@Named(value = "movimientoController")
@RequestScoped
public class MovimientoController {
    
    @EJB
    MovimientoFacade movimientoFacade;
    
    private List<Movimiento> movimientoList;
    
    private Movimiento movimiento;

    /**
     * Creates a new instance of MovimientoController
     */
    public MovimientoController() {
        movimiento = new Movimiento();
    }
    
    public String nuevoMovimiento(){
        movimientoFacade.create(getMovimiento());
        return "registroMovimiento?faces-redirect=true";
    }
    
    public List<Movimiento> getMovimientoList(){
        return movimientoFacade.findAll();
    }
    
    public String editarMovimiento(Movimiento m){
        setMovimiento(m);
        return "registroMovimiento?faces-redirect=true";
    }
    
    public String modificarMovimiento(){
        movimientoFacade.edit(getMovimiento());
        return "registroMovimiento?faces-redirect=true";
    }
    
    public void eliminarMovimiento(int id){
        int idmovimiento = id;
        Movimiento movimientoid = movimientoFacade.find(idmovimiento);
        movimientoFacade.remove(movimientoid);
        
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminada", "Categoría Eliminada");
        FacesContext.getCurrentInstance().addMessage(null,message);
    }

    /**
     * @return the movimiento
     */
    public Movimiento getMovimiento() {
        return movimiento;
    }

    /**
     * @param movimiento the movimiento to set
     */
    public void setMovimiento(Movimiento movimiento) {
        this.movimiento = movimiento;
    }
    
}
