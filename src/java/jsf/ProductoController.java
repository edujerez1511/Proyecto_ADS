/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import beans.Producto;
import ejb.ProductoFacade;
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
@Named(value = "productoController")
@RequestScoped
public class ProductoController {
    
    @EJB
    ProductoFacade productoFacade;
    
    private List<Producto> productoList;
    
    private Producto producto;

    /**
     * Creates a new instance of ProductoController
     */
    public ProductoController() {
        producto = new Producto();
    }
    
    public String nuevoProducto(){
        productoFacade.create(getProducto());
        return "registroProductos?faces-redirect=true";
    }
    
    public List<Producto> getProductoList() {
        return productoFacade.findAll();
    }
    
    public String editarProducto(Producto p){
        setProducto(p);
        return "registroProductos?faces-redirect=true";
    }
    
    public String modificarProducto(){
        productoFacade.edit(getProducto());
        return "registroProductos?faces-redirect=true";
    }
    
    public void eliminarProducto(int id){
        int idproducto = id;
        Producto productoid = productoFacade.find(idproducto);
        productoFacade.remove(productoid);
        
        //Agrega un mensaje
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminada", "Categoría Eliminada");
        FacesContext.getCurrentInstance().addMessage(null,message);
    }

    /**
     * @return the producto
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    
    
}
