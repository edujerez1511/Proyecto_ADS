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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eduje
 */
@Entity
@Table(name = "control_gastos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ControlGastos.findAll", query = "SELECT c FROM ControlGastos c")
    , @NamedQuery(name = "ControlGastos.findByIdgasto", query = "SELECT c FROM ControlGastos c WHERE c.idgasto = :idgasto")
    , @NamedQuery(name = "ControlGastos.findByFecha", query = "SELECT c FROM ControlGastos c WHERE c.fecha = :fecha")
    , @NamedQuery(name = "ControlGastos.findByIngresos", query = "SELECT c FROM ControlGastos c WHERE c.ingresos = :ingresos")
    , @NamedQuery(name = "ControlGastos.findByEgresos", query = "SELECT c FROM ControlGastos c WHERE c.egresos = :egresos")
    , @NamedQuery(name = "ControlGastos.findByTotal", query = "SELECT c FROM ControlGastos c WHERE c.total = :total")})
public class ControlGastos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idgasto")
    private Integer idgasto;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ingresos")
    private Double ingresos;
    @Column(name = "egresos")
    private Double egresos;
    @Column(name = "total")
    private Double total;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario idusuario;

    public ControlGastos() {
    }
    
    public ControlGastos(Integer idgasto, Date fecha, Double ingresos, Double egresos, Double total) {
        this.idgasto = idgasto;
        this.fecha = fecha;
        this.ingresos = ingresos;
        this.egresos = egresos;
        this.total = total;
    }

    public ControlGastos(Integer idgasto) {
        this.idgasto = idgasto;
    }

    public Integer getIdgasto() {
        return idgasto;
    }

    public void setIdgasto(Integer idgasto) {
        this.idgasto = idgasto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getIngresos() {
        return ingresos;
    }

    public void setIngresos(Double ingresos) {
        this.ingresos = ingresos;
    }

    public Double getEgresos() {
        return egresos;
    }

    public void setEgresos(Double egresos) {
        this.egresos = egresos;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
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
        hash += (idgasto != null ? idgasto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ControlGastos)) {
            return false;
        }
        ControlGastos other = (ControlGastos) object;
        if ((this.idgasto == null && other.idgasto != null) || (this.idgasto != null && !this.idgasto.equals(other.idgasto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.ControlGastos[ idgasto=" + idgasto + " ]";
    }
    
}
