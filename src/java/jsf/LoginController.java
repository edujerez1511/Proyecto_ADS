/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import hibernate.Usuario;
import hibernate.UsuarioDAO;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author eduje
 */
@ManagedBean
public class LoginController implements Serializable {
    private Usuario usuario;
    
    /**
     * Creates a new instance of LoginController
     */
    public LoginController() {
        usuario = new Usuario();
    }
    
    public String autenticar(){
        UsuarioDAO ud = new UsuarioDAO();
        
        Usuario resultado = ud.autenticar(usuario);
        
        if(resultado == null){
            
            return "Login";
        }
        
        
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        
        session.setAttribute("usuario", resultado);
        
        
        this.usuario = resultado;
        return "index";
    }
    
    public Usuario getAuthUser(){
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        
        
        Usuario tmp = (Usuario)session.getAttribute("usuario");
        if(tmp != null){
            return tmp;
        }
        
        try {
            context.getExternalContext().redirect(request.getContextPath()+"/faces/Login.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new Usuario();
    }
    
     public Usuario getSessionStart(){
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        
        
        Usuario tmp = (Usuario)session.getAttribute("usuario");
        if(tmp != null){
            return tmp;
        }
        return null;
    }
     
     /*public void security(){
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        
        
        Usuario tmp = (Usuario)session.getAttribute("usuario");
        if(tmp.getTipoAcceso().getIdrol()== 2){
            try {
                context.getExternalContext().redirect(request.getContextPath()+"/faces/index.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }*/
     
     public void logout(){
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        
        session.removeAttribute("usuario");
        
        this.usuario = new Usuario();
        
        try {
            context.getExternalContext().redirect(request.getContextPath()+"/faces/Login.xhtml");
        } catch (IOException ex) {
            try {
                context.getExternalContext().redirect(request.getContextPath()+"/faces/Login.xhtml");
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex1) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
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
