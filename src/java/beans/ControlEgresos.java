/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eduje
 */
@Entity
@Table(name = "control_egresos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ControlEgresos.findAll", query = "SELECT c FROM ControlEgresos c")
    , @NamedQuery(name = "ControlEgresos.findByIdEgreso", query = "SELECT c FROM ControlEgresos c WHERE c.idEgreso = :idEgreso")
    , @NamedQuery(name = "ControlEgresos.findByFecha", query = "SELECT c FROM ControlEgresos c WHERE c.fecha = :fecha")
    , @NamedQuery(name = "ControlEgresos.findByConcepto", query = "SELECT c FROM ControlEgresos c WHERE c.concepto = :concepto")
    , @NamedQuery(name = "ControlEgresos.findByCantidad", query = "SELECT c FROM ControlEgresos c WHERE c.cantidad = :cantidad")})
public class ControlEgresos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_egreso")
    private Integer idEgreso;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    //@Size(max = 50)
    @Column(name = "concepto")
    private String concepto;
    @Column(name = "cantidad")
    private Integer cantidad;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario idusuario;

    public ControlEgresos() {
    }
    
    public ControlEgresos(Integer idEgreso, Date fecha, String concepto, Integer cantidad) {
        this.idEgreso = idEgreso;
        this.fecha = fecha;
        this.concepto = concepto;
        this.cantidad = cantidad;
    }

    public ControlEgresos(Integer idEgreso) {
        this.idEgreso = idEgreso;
    }

    public Integer getIdEgreso() {
        return idEgreso;
    }

    public void setIdEgreso(Integer idEgreso) {
        this.idEgreso = idEgreso;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEgreso != null ? idEgreso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ControlEgresos)) {
            return false;
        }
        ControlEgresos other = (ControlEgresos) object;
        if ((this.idEgreso == null && other.idEgreso != null) || (this.idEgreso != null && !this.idEgreso.equals(other.idEgreso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.ControlEgresos[ idEgreso=" + idEgreso + " ]";
    }
    
}
