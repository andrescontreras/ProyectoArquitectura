/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracion;

/**
 *
 * @author imroo
 */
import entities.RentaSuper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author imroo
 */
public class ProxyRentas {
    public List<RentaSuper> cosultarRentas() throws IOException
    {
        List<RentaSuper> dataFromService = new ArrayList<>();
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            HttpGet request = new HttpGet("http://localhost:43602/OPRSoporteCE/webresources/servcios.renta");   
            request.addHeader("content-type", "application/json");
            HttpResponse result = httpClient.execute(request);
            String json = EntityUtils.toString(result.getEntity(), "UTF-8"); 
            System.out.println(json);
            com.google.gson.Gson gson = new com.google.gson.Gson(); 
            
            RentaSuper[] response = gson.fromJson(json, RentaSuper[].class);
            System.out.println(response.length);   
            for(RentaSuper transaccion : response)
            {
             dataFromService.add(transaccion);
              System.out.println(transaccion.toString());
            }

        }
        return dataFromService;
    }
}

