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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author santi
 */
@Entity
@Table(name = "PAGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pago.findAll", query = "SELECT p FROM Pago p")
    , @NamedQuery(name = "Pago.findById", query = "SELECT p FROM Pago p WHERE p.id = :id")
    , @NamedQuery(name = "Pago.findByEmail", query = "SELECT p FROM Pago p WHERE p.email = :email")
    , @NamedQuery(name = "Pago.findByTipoDocumento", query = "SELECT p FROM Pago p WHERE p.tipoDocumento = :tipoDocumento")
    , @NamedQuery(name = "Pago.findByNumeroDocumento", query = "SELECT p FROM Pago p WHERE p.numeroDocumento = :numeroDocumento")
    , @NamedQuery(name = "Pago.findByPassword", query = "SELECT p FROM Pago p WHERE p.password = :password")
    , @NamedQuery(name = "Pago.findByValor", query = "SELECT p FROM Pago p WHERE p.valor = :valor")})
public class Pago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Short id;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @Column(name = "TIPO_DOCUMENTO")
    private String tipoDocumento;
    @Basic(optional = false)
    @Column(name = "NUMERO_DOCUMENTO")
    private long numeroDocumento;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @Column(name = "VALOR")
    private int valor;
    @JoinColumn(name = "ID_RENTA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Renta idRenta;

    public Pago() {
    }

    public Pago(Short id) {
        this.id = id;
    }

    public Pago(Short id, String email, String tipoDocumento, long numeroDocumento, String password, int valor) {
        this.id = id;
        this.email = email;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.password = password;
        this.valor = valor;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public long getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(long numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Renta getIdRenta() {
        return idRenta;
    }

    public void setIdRenta(Renta idRenta) {
        this.idRenta = idRenta;
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
        if (!(object instanceof Pago)) {
            return false;
        }
        Pago other = (Pago) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Pago[ id=" + id + " ]";
    }
    
}
