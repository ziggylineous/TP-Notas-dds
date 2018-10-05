package http;

import com.google.gson.*;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import json.DeserializadorNota;
import modelo.Alumno;
import modelo.AsignacionTarea;
import modelo.Nota;

import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlumnoHTTP {
    private static String API = "http://notitas.herokuapp.com/";
    private static String RECURSO_ALUMNO = "student";
    private static String RECURSO_ASIGNACIONES = "student/assignments";
    private static String TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho";

    private String traerRecursoJson(String recurso) {
        Client client = Client.create();

        ClientResponse response = client
                .resource(API)
                .path(recurso)
                .header("Authorization", "Bearer " + TOKEN)
                .accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Error GET de alumno, error response : "
                    + response.getStatus());
        }

        String output = response.getEntity(String.class);

        System.out.println("Output from Server ....");
        System.out.println(output+"\n");

        return output;
    }

    public Alumno traer() {
        Alumno alumno = traerAlumno();
        List<AsignacionTarea> asignaciones = traerAsignaciones();

        alumno.setAsignacionesDeTareas(asignaciones);

        return alumno;
    }

    private Alumno traerAlumno() {
        String alumnoJson = traerRecursoJson(RECURSO_ALUMNO);

        Gson gson = new Gson();
        Alumno alumno = gson.fromJson(alumnoJson, Alumno.class);

        return alumno;
    }

    private List<AsignacionTarea> traerAsignaciones() {
        String asignacionesJson = traerRecursoJson(RECURSO_ASIGNACIONES);

        // tengo que acceder al array de assignments en lo que me mandan
        JsonParser jsonParser = new JsonParser();
        JsonObject json = jsonParser.parse(asignacionesJson).getAsJsonObject();
        JsonArray assignmentsNode = json.get("assignments").getAsJsonArray();

        Gson parser = new GsonBuilder()
                .registerTypeAdapter(Nota.class, new DeserializadorNota())
                .create();

        AsignacionTarea[] asignaciones = parser.fromJson(assignmentsNode, AsignacionTarea[].class);

        return Arrays.asList(asignaciones);
    }

    public void put(Alumno alumno) {

        Client client = Client.create();

        //Creo que este es mejor para crear el json
        String input = new Gson().toJson(alumno);
/*
        String input = "{\"code\":\""+alumno.getLegajo()+"\"," +
                "\"first_name\":\""+alumno.getNombre()+"\"," +
                "\"last_name\":\""+alumno.getApellido()+"\"," +
                "\"github_user\":\""+alumno.getUsuarioGithub()+"\"}" ;
*/
        ClientResponse response = client
                .resource(API)
                .path(RECURSO_ALUMNO)
                .header("Authorization", "Bearer " + TOKEN)
                .accept(MediaType.APPLICATION_JSON)
                .put(ClientResponse.class,input);

        if (response.getStatus() != 201) {
            throw new RuntimeException("Error PUT de alumno, error response : "
                    + response.getStatus());
        }

        System.out.println("Alumno modificado \n");

    }
}
