
import hibernate.Usuario;
import hibernate.UsuarioDAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maiku
 */
public class Prueba {
    public static void main(String args[]){
        Usuario u = new Usuario();
        u.setUser("eduardo.jerez");
        u.setPass("12345");
        
        UsuarioDAO ud = new UsuarioDAO();
        
        Usuario resultado = ud.autenticar(u);
        
        if(resultado == null){
            System.out.println("NO ENCONTRADO");
        }else{
            System.out.println("USUARIO ENCONTRADO");
        }
    }
}
