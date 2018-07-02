package vista;

import modelo.AsignacionTarea;
import org.uqbar.commons.model.annotations.Observable;

import modelo.Alumno;

@Observable
public class AlumnoViewModel {
	private Alumno alumno;
	private AsignacionTarea asignacionSeleccionada;
	
	public AlumnoViewModel(Alumno alumno) {
		this.alumno = alumno;

		if (alumno.tieneAlgunaAsignacion())
			setAsignacionSeleccionada(alumno.getAsignacionesDeTareas().get(0));
	}
	
	public Alumno getAlumno() { return alumno; }

	public AsignacionTarea getAsignacionSeleccionada() { return asignacionSeleccionada; }
	public void setAsignacionSeleccionada(AsignacionTarea asignacionSeleccionada) {
		this.asignacionSeleccionada = asignacionSeleccionada;
	}
}
