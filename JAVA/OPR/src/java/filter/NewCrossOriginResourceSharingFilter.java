/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author santi
 */
@Provider
public class NewCrossOriginResourceSharingFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext response) {
        response.getHeaders().putSingle("Access-Control-Allow-Origin", "http://localhost:8081");
        response.getHeaders().putSingle("Access-Control-Allow-Methods", "*");
        response.getHeaders().putSingle("Access-Control-Allow-Headers", "Content-Type");
        response.getHeaders().putSingle("Access-Control-Allow-Credentials", "true");
    }
    
}
