package vista;

import org.uqbar.commons.model.annotations.Observable;

import modelo.Alumno;

@Observable
public class AlumnoViewModel {
	private Alumno alumno;
	
	public AlumnoViewModel(Alumno alumno) {
		this.alumno = alumno;
	}
	
	public Alumno getAlumno() { return alumno; }
	public void setAlumno(Alumno alu) { alumno = alu; }
}
