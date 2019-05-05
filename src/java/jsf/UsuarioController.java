/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import beans.Usuario;
import ejb.UsuarioFacade;
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
@Named(value = "usuarioController")
@RequestScoped
public class UsuarioController {
    
    @EJB
    UsuarioFacade usuarioFacade;
    
    private List<Usuario> usuarioList;
    
    private Usuario usuario;

    /**
     * Creates a new instance of usuarioController
     */
    public UsuarioController() {
        usuario = new Usuario();
    }
    
    public String nuevoUsuario(){
        usuarioFacade.create(getUsuario());
        return "registroUsuarios?faces-redirect=true";
    }
    
    public List<Usuario> getUsuarioList() {
        return usuarioFacade.findAll();
    }
    
    public String editarUsuario(Usuario u){
        usuario = u;
        return "updateUsuario";
    }
    
    public String modificarUsuario(){
        usuarioFacade.edit(usuario);
        return "registroUsuarios";
    }
    
    public void eliminarUsuario(int id){
        int idUsuario = id;
        Usuario usuarioid = usuarioFacade.find(idUsuario);
        usuarioFacade.remove(usuarioid);
        
        //Agrega un mensaje
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado", "Cliente Eliminado");
        FacesContext.getCurrentInstance().addMessage(null,message);
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
}
