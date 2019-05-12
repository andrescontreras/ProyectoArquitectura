/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author santi
 */
@Entity
@Table(name = "PROPIEDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Propiedad.findAll", query = "SELECT p FROM Propiedad p")
    , @NamedQuery(name = "Propiedad.findById", query = "SELECT p FROM Propiedad p WHERE p.id = :id")
    , @NamedQuery(name = "Propiedad.findByIdOwner", query = "SELECT p FROM Propiedad p WHERE p.idOwner = :idOwner")
    , @NamedQuery(name = "Propiedad.findByTipo", query = "SELECT p FROM Propiedad p WHERE p.tipo = :tipo")
    , @NamedQuery(name = "Propiedad.findByDireccion", query = "SELECT p FROM Propiedad p WHERE p.direccion = :direccion")
    , @NamedQuery(name = "Propiedad.findByLocalidad", query = "SELECT p FROM Propiedad p WHERE p.localidad = :localidad")
    , @NamedQuery(name = "Propiedad.findByNumCuartos", query = "SELECT p FROM Propiedad p WHERE p.numCuartos = :numCuartos")
    , @NamedQuery(name = "Propiedad.findByPrecio", query = "SELECT p FROM Propiedad p WHERE p.precio = :precio")
    , @NamedQuery(name = "Propiedad.findByRentada", query = "SELECT p FROM Propiedad p WHERE p.rentada = :rentada")})
public class Propiedad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Short id;
    @Basic(optional = false)
    @Column(name = "ID_OWNER")
    private short idOwner;
    @Basic(optional = false)
    @Column(name = "TIPO")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "DIRECCION")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "LOCALIDAD")
    private String localidad;
    @Basic(optional = false)
    @Column(name = "NUM_CUARTOS")
    private short numCuartos;
    @Basic(optional = false)
    @Column(name = "PRECIO")
    private int precio;
    @Basic(optional = false)
    @Column(name = "RENTADA")
    private Character rentada;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPropiedad")
    private Collection<Renta> rentaCollection;

    public Propiedad() {
    }

    public Propiedad(Short id) {
        this.id = id;
    }

    public Propiedad(Short id, short idOwner, String tipo, String direccion, String localidad, short numCuartos, int precio, Character rentada) {
        this.id = id;
        this.idOwner = idOwner;
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

    public short getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(short idOwner) {
        this.idOwner = idOwner;
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

    @XmlTransient
    public Collection<Renta> getRentaCollection() {
        return rentaCollection;
    }

    public void setRentaCollection(Collection<Renta> rentaCollection) {
        this.rentaCollection = rentaCollection;
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
