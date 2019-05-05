/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author eduje
 */
@Entity
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findByIdProducto", query = "SELECT p FROM Producto p WHERE p.idProducto = :idProducto")
    , @NamedQuery(name = "Producto.findByNombreProducto", query = "SELECT p FROM Producto p WHERE p.nombreProducto = :nombreProducto")
    , @NamedQuery(name = "Producto.findByClasificacion", query = "SELECT p FROM Producto p WHERE p.clasificacion = :clasificacion")
    , @NamedQuery(name = "Producto.findByCostoCompra", query = "SELECT p FROM Producto p WHERE p.costoCompra = :costoCompra")
    , @NamedQuery(name = "Producto.findByCostoVenta", query = "SELECT p FROM Producto p WHERE p.costoVenta = :costoVenta")
    , @NamedQuery(name = "Producto.findByEntrada", query = "SELECT p FROM Producto p WHERE p.entrada = :entrada")
    , @NamedQuery(name = "Producto.findBySalida", query = "SELECT p FROM Producto p WHERE p.salida = :salida")
    , @NamedQuery(name = "Producto.findByDisponibles", query = "SELECT p FROM Producto p WHERE p.disponibles = :disponibles")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_producto")
    private Integer idProducto;
    //@Size(max = 50)
    @Column(name = "nombre_producto")
    private String nombreProducto;
    //@Size(max = 20)
    @Column(name = "clasificacion")
    private String clasificacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "costo_compra")
    private Double costoCompra;
    @Column(name = "costo_venta")
    private Double costoVenta;
    @Column(name = "entrada")
    private Double entrada;
    @Column(name = "salida")
    private Double salida;
    @Column(name = "disponibles")
    private Integer disponibles;
    @OneToMany(mappedBy = "idProducto")
    private List<Compras> comprasList;

    public Producto() {
    }
    
    public Producto(Integer idProducto, String nombreProducto, String clasificacion, Double costoCompra, Double costoVenta, Double entrada, Double salida, Integer disponibles) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.clasificacion = clasificacion;
        this.costoCompra = costoCompra;
        this.costoVenta = costoVenta;
        this.entrada = entrada;
        this.salida = salida;
        this.disponibles = disponibles;
    }

    public Producto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public Double getCostoCompra() {
        return costoCompra;
    }

    public void setCostoCompra(Double costoCompra) {
        this.costoCompra = costoCompra;
    }

    public Double getCostoVenta() {
        return costoVenta;
    }

    public void setCostoVenta(Double costoVenta) {
        this.costoVenta = costoVenta;
    }

    public Double getEntrada() {
        return entrada;
    }

    public void setEntrada(Double entrada) {
        this.entrada = entrada;
    }

    public Double getSalida() {
        return salida;
    }

    public void setSalida(Double salida) {
        this.salida = salida;
    }

    public Integer getDisponibles() {
        return disponibles;
    }

    public void setDisponibles(Integer disponibles) {
        this.disponibles = disponibles;
    }

    @XmlTransient
    public List<Compras> getComprasList() {
        return comprasList;
    }

    public void setComprasList(List<Compras> comprasList) {
        this.comprasList = comprasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Producto[ idProducto=" + idProducto + " ]";
    }
    
}
