package hibernate;
// Generated 05-03-2019 04:10:22 PM by Hibernate Tools 4.3.1



/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private Integer idusuario;
     private String nombre;
     private String pass;
     private String user;

    public Usuario() {
    }

    public Usuario(String nombre, String pass, String user) {
       this.nombre = nombre;
       this.pass = pass;
       this.user = user;
    }
   
    public Integer getIdusuario() {
        return this.idusuario;
    }
    
    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPass() {
        return this.pass;
    }
    
    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getUser() {
        return this.user;
    }
    
    public void setUser(String user) {
        this.user = user;
    }




}

