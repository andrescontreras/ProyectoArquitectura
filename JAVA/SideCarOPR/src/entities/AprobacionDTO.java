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

    long numAprobacion;
    Date fechaAprobacion;
    boolean estado;

    public AprobacionDTO() {
    }

    public long getNumAprobacion() {
        return numAprobacion;
    }

    public void setNumAprobacion(long numAprobacion) {
        this.numAprobacion = numAprobacion;
    }

    public Date getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(Date fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
