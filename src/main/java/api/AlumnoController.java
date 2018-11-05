package api;

import spark.Request;
import spark.Response;

public class AlumnoController {
    public String alumnosGET(Request req, Response res) {
        return "alumnos";
    }
}
