/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author santi
 */
public class AprobacionDTO {

    int numAprobacion;
    Date fechaAprobacion;
    int estado;

    public AprobacionDTO() {
    }

    public int getNumAprobacion() {
        return numAprobacion;
    }

    public void setNumAprobacion(int numAprobacion) {
        this.numAprobacion = numAprobacion;
    }


    public Date getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(Date fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    

}
