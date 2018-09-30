import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import modelo.Alumno;

import javax.ws.rs.core.MediaType;

public class AlumnoHTTP {
    private static String API = "http://notitas.herokuapp.com/";
    private static String RECURSO_ALUMNO = "student";
    private static String TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho";

    Alumno traer() {
        Client client = Client.create();

        //WebResource webResource =
        ClientResponse response = client
                .resource(API)
                .path(RECURSO_ALUMNO)
                .header("Authorization", "Bearer " + TOKEN)
                .get(ClientResponse.class);


        //ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON)
                //.get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        String output = response.getEntity(String.class);

        System.out.println("Output from Server .... \n");
        System.out.println(output);

        return new Alumno("_", "_", "_", "_");
    }
}
