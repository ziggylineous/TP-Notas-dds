package api;

import modelo.RepositorioAlumnos;
import spark.Request;
import spark.Response;

public class AlumnoController {
    RepositorioAlumnos repositorio;

    public AlumnoController() {
        repositorio = new RepositorioAlumnos();
    }

    public String alumnosGET(Request req, Response res) {
        return "alumnos";
    }
}
