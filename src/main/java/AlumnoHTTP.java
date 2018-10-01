import com.google.gson.Gson;
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

        ClientResponse response = client
                .resource(API)
                .path(RECURSO_ALUMNO)
                .header("Authorization", "Bearer " + TOKEN)
                .accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Error GET de alumno, error response : "
                    + response.getStatus());
        }

        String output = response.getEntity(String.class);

        System.out.println("Output from Server .... \n");
        System.out.println(output);

        Gson gson = new Gson();
        Alumno alumno = gson.fromJson(output, Alumno.class);

        if (alumno.getLegajo() == null)
            alumno.setLegajo("123");

        return alumno;
    }
}
