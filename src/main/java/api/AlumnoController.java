package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import json.DeserializadorNota;
import modelo.Nota;
import modelo.RepositorioAlumnos;
import spark.Request;
import spark.Response;

public class AlumnoController {
    RepositorioAlumnos repositorio;
    Gson serializadorJson;

    public AlumnoController() {
        repositorio = new RepositorioAlumnos();

        serializadorJson = new GsonBuilder()
                .registerTypeAdapter(Nota.class, new DeserializadorNota())
                .create();
    }

    public String alumnosGET(Request req, Response res) {
        return serializadorJson.toJson(repositorio.todos());
    }
}
