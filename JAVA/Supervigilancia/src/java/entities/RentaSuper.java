/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author imroo
 */
@Entity
@Table(name = "RENTA_SUPER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RentaSuper.findAll", query = "SELECT r FROM RentaSuper r")
    , @NamedQuery(name = "RentaSuper.findById", query = "SELECT r FROM RentaSuper r WHERE r.id = :id")
    , @NamedQuery(name = "RentaSuper.findByCedulaUsuario", query = "SELECT r FROM RentaSuper r WHERE r.cedulaUsuario = :cedulaUsuario")
    , @NamedQuery(name = "RentaSuper.findByIdPropiedad", query = "SELECT r FROM RentaSuper r WHERE r.idPropiedad = :idPropiedad")
    , @NamedQuery(name = "RentaSuper.findByEmail", query = "SELECT r FROM RentaSuper r WHERE r.email = :email")
    , @NamedQuery(name = "RentaSuper.findByPrecioRenta", query = "SELECT r FROM RentaSuper r WHERE r.precioRenta = :precioRenta")
    , @NamedQuery(name = "RentaSuper.findByFecha", query = "SELECT r FROM RentaSuper r WHERE r.fecha = :fecha")
    , @NamedQuery(name = "RentaSuper.findByEstado", query = "SELECT r FROM RentaSuper r WHERE r.estado = :estado")
    , @NamedQuery(name = "RentaSuper.findByFechaRenta", query = "SELECT r FROM RentaSuper r WHERE r.fechaRenta = :fechaRenta")})
public class RentaSuper implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Short id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CEDULA_USUARIO", insertable = false)
    private long cedulaUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PROPIEDAD")
    private short idPropiedad;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO_RENTA")
    private long precioRenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private Character estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_RENTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRenta;

    public RentaSuper() {
    }

    public RentaSuper(Short id) {
        this.id = id;
    }

    public RentaSuper(Short id, long cedulaUsuario, short idPropiedad, String email, long precioRenta, Date fecha, Character estado, Date fechaRenta) {
        this.id = id;
        this.cedulaUsuario = cedulaUsuario;
        this.idPropiedad = idPropiedad;
        this.email = email;
        this.precioRenta = precioRenta;
        this.fecha = fecha;
        this.estado = estado;
        this.fechaRenta = fechaRenta;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public long getCedulaUsuario() {
        return cedulaUsuario;
    }

    public void setCedulaUsuario(long cedulaUsuario) {
        this.cedulaUsuario = cedulaUsuario;
    }

    public short getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(short idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPrecioRenta() {
        return precioRenta;
    }

    public void setPrecioRenta(long precioRenta) {
        this.precioRenta = precioRenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Date getFechaRenta() {
        return fechaRenta;
    }

    public void setFechaRenta(Date fechaRenta) {
        this.fechaRenta = fechaRenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RentaSuper)) {
            return false;
        }
        RentaSuper other = (RentaSuper) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.RentaSuper[ id=" + id + " ]";
    }
    
}
