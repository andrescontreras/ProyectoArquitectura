/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author sistemas
 */
public class ConfirmacionDTO {
    int idPropiedad;
    int documentoUsuario;

    public ConfirmacionDTO() {}
    
    public int getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(int idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public int getDocumentoUsuario() {
        return documentoUsuario;
    }

    public void setDocumentoUsuario(int documentoUsuario) {
        this.documentoUsuario = documentoUsuario;
    }

    

    
}
