package api;
import spark.debug.DebugScreen;
import static spark.Spark.*;

public class ApiWeb {

    public static void main(String[] args) {
        port(9017);
        DebugScreen.enableDebugScreen();

        AlumnoController alumnoController = new AlumnoController();

        get("/alumnos", alumnoController::alumnosGET);
    }
}
