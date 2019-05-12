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
 * @author santi
 */
@Entity
@Table(name = "RENTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Renta.findAll", query = "SELECT r FROM Renta r")
    , @NamedQuery(name = "Renta.findById", query = "SELECT r FROM Renta r WHERE r.id = :id")
    , @NamedQuery(name = "Renta.findByIdUsuario", query = "SELECT r FROM Renta r WHERE r.idUsuario = :idUsuario")
    , @NamedQuery(name = "Renta.findByEmail", query = "SELECT r FROM Renta r WHERE r.email = :email")
    , @NamedQuery(name = "Renta.findByPrecioRenta", query = "SELECT r FROM Renta r WHERE r.precioRenta = :precioRenta")
    , @NamedQuery(name = "Renta.findByFecha", query = "SELECT r FROM Renta r WHERE r.fecha = :fecha")})
public class Renta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Short id;
    @Basic(optional = false)
    @Column(name = "ID_USUARIO")
    private short idUsuario;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @Column(name = "PRECIO_RENTA")
    private int precioRenta;
    @Basic(optional = false)
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "ID_PROPIEDAD", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Propiedad idPropiedad;

    public Renta() {
    }

    public Renta(Short id) {
        this.id = id;
    }

    public Renta(Short id, short idUsuario, String email, int precioRenta, Date fecha) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.email = email;
        this.precioRenta = precioRenta;
        this.fecha = fecha;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public short getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(short idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPrecioRenta() {
        return precioRenta;
    }

    public void setPrecioRenta(int precioRenta) {
        this.precioRenta = precioRenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Propiedad getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(Propiedad idPropiedad) {
        this.idPropiedad = idPropiedad;
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
        if (!(object instanceof Renta)) {
            return false;
        }
        Renta other = (Renta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Renta[ id=" + id + " ]";
    }
    
}
