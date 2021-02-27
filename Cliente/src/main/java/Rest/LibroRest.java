/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author aloja
 */
public class LibroRest {
    public String listar(String categoria){
        try {
            String endpoint = "http://localhost:8080/Examen/ws/ex/resumen"+categoria;

            String url = endpoint;

            System.out.println(url);
            HttpClientBuilder hcBuilder = HttpClients.custom();
            HttpClient client = hcBuilder.build();
            HttpGet request = new HttpGet(url);
            //Setting header parameters
            request.addHeader("Content-Type", "application/json");
            request.addHeader("Accept", "application/json");

            //Executing the call
            HttpResponse response = client.execute(request);
            System.out.println("\nSending 'Get' to " + url);
            System.out.println("HTTP Response: " + response.getStatusLine().getStatusCode());
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            //Reading the response
            StringBuilder result = new StringBuilder();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            String mensaje = result.toString();
            System.out.println(result.toString());
            return mensaje;
        } catch (IOException ex) {
           
            return null;
        }
    }
    private final String WS_SAVE_CATEGORIA = "http://localhost:8080/Examen/ws/ex/reservar";
    public void cambio(int id){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(WS_SAVE_CATEGORIA);
        target.request().post(Entity.json(id));
    }
    
}
