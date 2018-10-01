import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import modelo.*;
import vista.AlumnoWindow;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
		entrega2();
    }

    public static void entrega2() {
		try {
			Alumno alumnoDesdeRecurso = new AlumnoHTTP().traer();
			System.out.println(alumnoDesdeRecurso.toString());

		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

    public static void entrega1() {
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

		Alumno alumno3 = new Alumno("jaimito", "delCampo", "88-472-1", "jaimeKPO");
		AsignacionTarea parcialFisica2 = new AsignacionTarea("Parcial fisica 2");
		parcialFisica2.ponerNota(new NotaNumerica(1));
		parcialFisica2.ponerNota(new NotaNumerica(1));
		parcialFisica2.ponerNota(new NotaNumerica(2));

		AsignacionTarea tpFisica2 = new AsignacionTarea("TP fisica 2");
		tpFisica2.ponerNota(new NotaConceptual(EnumNotasConceptuales.MAL));
		tpFisica2.ponerNota(new NotaConceptual(EnumNotasConceptuales.MAL));
		tpFisica2.ponerNota(new NotaConceptual(EnumNotasConceptuales.MAL));

		AsignacionTarea parcialIngles = new AsignacionTarea("Parcial ingles");
		parcialIngles.ponerNota(new NotaNumerica(4));
		parcialIngles.ponerNota(new NotaNumerica(2));
		parcialIngles.ponerNota(new NotaNumerica(5));
		parcialIngles.ponerNota(new NotaNumerica(6));

		alumno3.agregarAsignacionDeTarea(parcialFisica2);
		alumno3.agregarAsignacionDeTarea(tpFisica2);
		alumno3.agregarAsignacionDeTarea(parcialIngles);

		List<Alumno> alumnos = new ArrayList<>();
		alumnos.add(alumno);
		alumnos.add(alumno2);
		alumnos.add(alumno3);

		new AlumnoWindow(alumnos).startApplication();
	}
}
