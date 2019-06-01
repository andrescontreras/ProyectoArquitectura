/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Integracion;

import com.google.gson.Gson;
import entities.AprobacionDTO;
import entities.TransaccionDTO;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author imroo
 */
public class ProxyFinanciera {
    public AprobacionDTO httpPost (TransaccionDTO t)
    {
        System.out.println("Estoy en post");
        AprobacionDTO ap = new AprobacionDTO();
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            Gson gson = new Gson();
            HttpPost request = new HttpPost("http://10.192.12.46:8081/api/Transacciones");
            StringEntity postingString = new StringEntity(gson.toJson(t));
            request.setEntity(postingString);
            request.setHeader("Content-type","application/json");
            HttpResponse result = httpClient.execute(request);
            
            
            String content = EntityUtils.toString(result.getEntity());
            System.out.println("Pre conversion");
            ap = gson.fromJson(content, AprobacionDTO.class);
            int statusCode = result.getStatusLine().getStatusCode();
            System.out.println("statusCode = " + statusCode);
            System.out.println("content = " + content);
        }
        catch (IOException ex) {
        }
        return ap;
    }
    public AprobacionDTO httpGet() {

    ArrayList<AprobacionDTO> dataFromService = new ArrayList<AprobacionDTO>();
    AprobacionDTO response = new AprobacionDTO();
    try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
        HttpGet request = new HttpGet("http://srvcronos.tk:8081/api/Transacciones");   
        request.addHeader("content-type", "application/json");
        HttpResponse result = httpClient.execute(request);
        String json = EntityUtils.toString(result.getEntity(), "UTF-8");  
        
        com.google.gson.Gson gson = new com.google.gson.Gson();                       
        response = gson.fromJson(json, AprobacionDTO.class);

        //System.out.println(response.length); 
        /*
        for(TransaccionDTO transaccion : response)
        {
            dataFromService.add(transaccion);
             System.out.println(transaccion.toString());
        }
        */
    } catch (IOException ex) {
    }
    return response;
}
}
