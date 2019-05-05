/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import beans.Compras;
import ejb.ComprasFacade;
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
@Named(value = "comprasBean")
@RequestScoped
public class ComprasController {
    
    @EJB
    ComprasFacade comprasFacade;
    
    private List<Compras> comprasList;
    
    private Compras compras;

    /**
     * Creates a new instance of ComprasBean
     */
    public ComprasController() {
        compras = new Compras();
    }
    
    public String nuevaCompra(){
        comprasFacade.create(getCompras());
        return "registroCompras?faces-redirect=true";
    }
    
    public List<Compras> getComprasList() {
        return comprasFacade.findAll();
    }
    
    public String editarCompras(Compras c){
        compras = c;
        return "updateCompra";
    }
    
    public String modificarCompras(){
        comprasFacade.edit(compras);
        return "registroCompras?faces-redirect=true";
    }
    
    public void eliminarCompras(int id){
        int idcompra = id;
        Compras compraid = comprasFacade.find(idcompra);
        comprasFacade.remove(compraid);
        
        //Agrega un mensaje
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminada", "Compra Eliminada");
        FacesContext.getCurrentInstance().addMessage(null,message);
    }

    /**
     * @return the compras
     */
    public Compras getCompras() {
        return compras;
    }

    /**
     * @param compras the compras to set
     */
    public void setCompras(Compras compras) {
        this.compras = compras;
    }
    
}
