import modelo.*;
import vista.AlumnoWindow;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    	Alumno alumno = new Alumno("ignacio", "ferrari", "140-970-0", "Ziggylineous");

    	AsignacionTarea tpAnual = new AsignacionTarea("TP anual");
    	tpAnual.ponerNota(new NotaNumerica(4));
		tpAnual.ponerNota(new NotaNumerica(2));

		AsignacionTarea primerParcial = new AsignacionTarea("Primer Parcial");
        primerParcial.ponerNota(new NotaNumerica(6));

		AsignacionTarea tpConceptual = new AsignacionTarea("TP Conceptual");
		tpConceptual.ponerNota(new NotaConceptual(EnumNotasConceptuales.MAL));
		tpConceptual.ponerNota(new NotaConceptual(EnumNotasConceptuales.REGULAR_MAS));

		alumno.agregarAsignacionDeTarea(tpAnual);
    	alumno.agregarAsignacionDeTarea(primerParcial);
		alumno.agregarAsignacionDeTarea(tpConceptual);



		Alumno alumno2 = new Alumno("pedro", "perez", "110-472-1", "pedro.perez");
		AsignacionTarea tpConceptual2 = new AsignacionTarea("TP Conceptual 2");
		tpConceptual2.ponerNota(new NotaConceptual(EnumNotasConceptuales.MAL));

		alumno2.agregarAsignacionDeTarea(tpConceptual2);

		List<Alumno> listAlumno = new ArrayList<>();
		listAlumno.add(alumno);
		listAlumno.add(alumno2);

		Alumno[] arrayAlumnos = new Alumno[listAlumno.size()];
		arrayAlumnos = listAlumno.toArray(arrayAlumnos);

    	new AlumnoWindow(arrayAlumnos).startApplication();
    }
}
