/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author santi
 */
@Entity
@Table(name = "PROPIEDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Propiedad.findAll", query = "SELECT p FROM Propiedad p"),
    @NamedQuery(name = "Propiedad.findById", query = "SELECT p FROM Propiedad p WHERE p.id = :id"),
    @NamedQuery(name = "Propiedad.findByNombreOwner", query = "SELECT p FROM Propiedad p WHERE p.nombreOwner = :nombreOwner"),
    @NamedQuery(name = "Propiedad.findByCedulaOwner", query = "SELECT p FROM Propiedad p WHERE p.cedulaOwner = :cedulaOwner"),
    @NamedQuery(name = "Propiedad.findByNombre", query = "SELECT p FROM Propiedad p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Propiedad.findByDescripcion", query = "SELECT p FROM Propiedad p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Propiedad.findByTipoCedula", query = "SELECT p FROM Propiedad p WHERE p.tipoCedula = :tipoCedula"),
    @NamedQuery(name = "Propiedad.findByTipo", query = "SELECT p FROM Propiedad p WHERE p.tipo = :tipo"),
    @NamedQuery(name = "Propiedad.findByDireccion", query = "SELECT p FROM Propiedad p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Propiedad.findByLocalidad", query = "SELECT p FROM Propiedad p WHERE p.localidad = :localidad"),
    @NamedQuery(name = "Propiedad.findByNumCuartos", query = "SELECT p FROM Propiedad p WHERE p.numCuartos = :numCuartos"),
    @NamedQuery(name = "Propiedad.findByPrecio", query = "SELECT p FROM Propiedad p WHERE p.precio = :precio"),
    @NamedQuery(name = "Propiedad.findByRentada", query = "SELECT p FROM Propiedad p WHERE p.rentada = :rentada")})
public class Propiedad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID", insertable=false)
    private Short id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE_OWNER")
    private String nombreOwner;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CEDULA_OWNER")
    private long cedulaOwner;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "TIPO_CEDULA")
    private String tipoCedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TIPO")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "DIRECCION")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "LOCALIDAD")
    private String localidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_CUARTOS")
    private short numCuartos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO")
    private int precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RENTADA")
    private Character rentada;

    public Propiedad() {
    }

    public Propiedad(Short id) {
        this.id = id;
    }

    public Propiedad(Short id, String nombreOwner, long cedulaOwner, String nombre, String descripcion, String tipoCedula, String tipo, String direccion, String localidad, short numCuartos, int precio, Character rentada) {
        this.id = id;
        this.nombreOwner = nombreOwner;
        this.cedulaOwner = cedulaOwner;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoCedula = tipoCedula;
        this.tipo = tipo;
        this.direccion = direccion;
        this.localidad = localidad;
        this.numCuartos = numCuartos;
        this.precio = precio;
        this.rentada = rentada;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getNombreOwner() {
        return nombreOwner;
    }

    public void setNombreOwner(String nombreOwner) {
        this.nombreOwner = nombreOwner;
    }

    public long getCedulaOwner() {
        return cedulaOwner;
    }

    public void setCedulaOwner(long cedulaOwner) {
        this.cedulaOwner = cedulaOwner;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoCedula() {
        return tipoCedula;
    }

    public void setTipoCedula(String tipoCedula) {
        this.tipoCedula = tipoCedula;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public short getNumCuartos() {
        return numCuartos;
    }

    public void setNumCuartos(short numCuartos) {
        this.numCuartos = numCuartos;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Character getRentada() {
        return rentada;
    }

    public void setRentada(Character rentada) {
        this.rentada = rentada;
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
        if (!(object instanceof Propiedad)) {
            return false;
        }
        Propiedad other = (Propiedad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Propiedad[ id=" + id + " ]";
    }
    
}
