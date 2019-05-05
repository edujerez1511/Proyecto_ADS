/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import beans.Ventas;
import ejb.VentasFacade;
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
@Named(value = "ventasController")
@RequestScoped
public class VentasController {
    
    @EJB
    VentasFacade ventasFacade;
    
    private List<Ventas> ventasList;
    
    private Ventas ventas;

    /**
     * Creates a new instance of VentasController
     */
    public VentasController() {
        ventas = new Ventas();
    }
    
    public String nuevaVenta(){
        ventasFacade.create(getVentas());
        return "registroVentas?faces-redirect=true";
    }
    
    public List<Ventas> getVentasList() {
        return ventasFacade.findAll();
    }
    
    public String editarVentas(Ventas v){
        ventas = v;
        return "updateVenta";
    }
    
    public String findById(Ventas v){
        ventas = ventasFacade.find(v.getIdventa());
        return "updateVenta";
    }
    
    public String modificarVentas(){
        ventasFacade.edit(ventas);
        return "registroVentas?faces-redirect=true";
    }
    
    public void eliminarVentas(int id){
        int idVenta = id;
        Ventas ventaid = ventasFacade.find(idVenta);
        ventasFacade.remove(ventaid);
        
        //Agrega un mensaje
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminada", "Categoría Eliminada");
        FacesContext.getCurrentInstance().addMessage(null,message);
    }

    /**
     * @return the ventas
     */
    public Ventas getVentas() {
        return ventas;
    }

    /**
     * @param ventas the ventas to set
     */
    public void setVentas(Ventas ventas) {
        this.ventas = ventas;
    }
    
    
}
