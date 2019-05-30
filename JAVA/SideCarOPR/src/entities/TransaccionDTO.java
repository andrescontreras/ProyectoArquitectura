/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author santi
 */
public class TransaccionDTO {
    
        String tipoDocumento;
        int numDocumento;
        Short idPropiedad;
        String email;
	Date fecha;
        String password;
        int descontar;
        String fechaRenta;

    public TransaccionDTO() {}

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getDescontar() {
        return descontar;
    }

    public void setDescontar(int descontar) {
        this.descontar = descontar;
    }

    

    public Short getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(Short idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(int numDocumento) {
        this.numDocumento = numDocumento;
    }

    

    public String getFechaRenta() {
        return fechaRenta;
    }

    public void setFechaRenta(String fechaRenta) {
        this.fechaRenta = fechaRenta;
    }
    
    
}
