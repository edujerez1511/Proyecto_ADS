/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import beans.Menu;
import ejb.MenuFacade;
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
@Named(value = "menuController")
@RequestScoped
public class MenuController {

    @EJB
    MenuFacade menuFacade;
    
    private List<Menu> menuList;
    
    private Menu menu;
    
    /**
     * Creates a new instance of MenuController
     */
    public MenuController() {
        menu = new Menu();
    }
    
     public String nuevoMenu(){
        menuFacade.create(getMenu());
        return "registroMenu?faces-redirect=true";
    }
     
     public List<Menu> getMenuList(){
         return menuFacade.findAll();
     }
     
      public String editarMenu(Menu m){
        setMenu(m);
        return "registroMenu?faces-redirect=true";
    }
      
      public String modificarMenu(){
        menuFacade.edit(getMenu());
        return "registroMenu?faces-redirect=true";
    }
      
      public void eliminarMenu(int id){
        int idmenu = id;
        Menu menuid = menuFacade.find(idmenu);
        menuFacade.remove(menuid);
        
        //Agrega un mensaje
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminada", "Categoría Eliminada");
        FacesContext.getCurrentInstance().addMessage(null,message);
    }

    /**
     * @return the menu
     */
    public Menu getMenu() {
        return menu;
    }

    /**
     * @param menu the menu to set
     */
    public void setMenu(Menu menu) {
        this.menu = menu;
    }
      
}
