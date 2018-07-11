package vista;

import modelo.AsignacionTarea;
import org.uqbar.commons.model.annotations.Observable;

import modelo.Alumno;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Observable
public class AlumnoViewModel {
	private Alumno alumno;
	private AsignacionTarea asignacionSeleccionada;

	private List<Alumno> alumnos;

	
	public AlumnoViewModel(List<Alumno> alumnos) {
		this.alumnos = alumnos;

		if (!alumnos.isEmpty()) {
		    alumno = alumnos.get(0);

		    /*if (alumno.tieneAlgunaAsignacion())
			    setAsignacionSeleccionada(alumno.getAsignacionesDeTareas().get(0));*/
        }
	}
	
	public Alumno getAlumno() { return alumno; }
	public void setAlumno(Alumno alumno) { this.alumno = alumno; }

    public List<Alumno> getAlumnos() { return alumnos; }
    public void setAlumnos(List<Alumno> alumnos) { this.alumnos = alumnos; }

	public AsignacionTarea getAsignacionSeleccionada() { return asignacionSeleccionada; }
	public void setAsignacionSeleccionada(AsignacionTarea asignacionSeleccionada) {
		this.asignacionSeleccionada = asignacionSeleccionada;
	}
}
