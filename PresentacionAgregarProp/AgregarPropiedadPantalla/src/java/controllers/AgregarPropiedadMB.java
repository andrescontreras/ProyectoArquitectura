/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.google.gson.Gson;
import entities.Propiedad;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author imroo
 */
@ManagedBean
@Named(value = "agregarPropiedadMB")
@RequestScoped
public class AgregarPropiedadMB implements Serializable {

    private Propiedad propiedad = new Propiedad();

    public Propiedad getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;
    }
    
    
    public void guardar() throws UnsupportedEncodingException {
        System.out.println(propiedad.toString());
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            Gson gson = new Gson();
            HttpPost request = new HttpPost("http://localhost:43602/OPR/webresources/propiedad/");
            StringEntity postingString = new StringEntity(gson.toJson(propiedad));
            request.setEntity(postingString);
            request.setHeader("Content-type","application/json");
            HttpResponse result = httpClient.execute(request);
            
            String content = "N/A";
            if (result.getEntity() != null)
            {
                content = EntityUtils.toString(result.getEntity());
            }
            
            
            int statusCode = result.getStatusLine().getStatusCode();
            System.out.println("statusCode = " + statusCode);
            System.out.println("content = " + content);
        }
        catch (IOException ex) {
        }
    }
    
}
