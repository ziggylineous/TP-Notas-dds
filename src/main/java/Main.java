import modelo.Alumno;
import modelo.AsignacionTarea;
import vista.AlumnoWindow;

public class Main {
    public static void main(String[] args) {
    	Alumno alumno = new Alumno("ignacio", "ferrari", "140-970-0");
    	alumno.agregarAsignacionDeTarea(new AsignacionTarea("TP anual"));
    	alumno.agregarAsignacionDeTarea(new AsignacionTarea("Primer Parcial"));
        
    	new AlumnoWindow(alumno).startApplication();
    }
}
