import modelo.Alumno;
import modelo.AsignacionTarea;
import modelo.NotaNumerica;
import vista.AlumnoWindow;

public class Main {
    public static void main(String[] args) {
    	Alumno alumno = new Alumno("ignacio", "ferrari", "140-970-0", "Ziggylineous");

    	AsignacionTarea tpAnual = new AsignacionTarea("TP anual");
    	tpAnual.ponerNota(new NotaNumerica(4));
		tpAnual.ponerNota(new NotaNumerica(2));

		AsignacionTarea primerParcial = new AsignacionTarea("Primer Parcial");
        primerParcial.ponerNota(new NotaNumerica(6));
    	alumno.agregarAsignacionDeTarea(tpAnual);

    	alumno.agregarAsignacionDeTarea(primerParcial);
        
    	new AlumnoWindow(alumno).startApplication();
    }
}
