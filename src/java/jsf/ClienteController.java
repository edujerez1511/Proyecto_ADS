/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import beans.Cliente;
import ejb.ClienteFacade;
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
@Named(value = "clienteController")
@RequestScoped
public class ClienteController {
    
    @EJB
    ClienteFacade clienteFacade;
    
    private List<Cliente> clienteList;
    
    private Cliente cliente;

    /**
     * Creates a new instance of ClienteController
     */
    public ClienteController() {
        cliente = new Cliente();
    }
    
    public String nuevoCliente(){
        clienteFacade.create(getCliente());
        return "registroClientes?faces-redirect=true";
    }
    
    public List<Cliente> getClienteList() {
        return clienteFacade.findAll();
    }
    
    public String editarCliente(Cliente c){
        cliente = c;
        return "updateCliente";
    }
    
    public String modificarCliente(){
        clienteFacade.edit(cliente);
        return "registroClientes?faces-redirect=true";
    }
    
    public void eliminarCliente(int id){
        int idCliente = id;
        Cliente clienteid = clienteFacade.find(idCliente);
        clienteFacade.remove(clienteid);
        
        //Agrega un mensaje
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado", "Cliente Eliminado");
        FacesContext.getCurrentInstance().addMessage(null,message);
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
