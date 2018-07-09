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

	private String nombre;
	private String apellido;

	private String advertencia;

	private List<Alumno> listaAlumnos;

	
	public AlumnoViewModel(Alumno[] arrayAlumnos) {
		listaAlumnos = new ArrayList<>();
		this.listaAlumnos = Arrays.asList(arrayAlumnos);
		advertencia="";
		/*if (alumno.tieneAlgunaAsignacion())
			setAsignacionSeleccionada(alumno.getAsignacionesDeTareas().get(0));*/
	}
	
	public Alumno getAlumno() { return alumno; }

	public AsignacionTarea getAsignacionSeleccionada() { return asignacionSeleccionada; }
	public void setAsignacionSeleccionada(AsignacionTarea asignacionSeleccionada) {
		this.asignacionSeleccionada = asignacionSeleccionada;
	}

	public String getApellido() { return apellido; }
	public void setApellido(String apellido) { this.apellido = apellido; }

	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }

	public String getAdvertencia() { return advertencia; }
	public void setAdvertencia(String advertencia) { this.advertencia = advertencia; }

	public void obtenerAlumnoPorDatos(){
		if(listaAlumnos.stream().anyMatch(unAlumno->existeAlumno(unAlumno))){
			this.alumno = listaAlumnos.stream().filter(unAlumno->existeAlumno(unAlumno)).collect(Collectors.toList()).get(0);
			advertencia="";
		}else{
			advertencia="No esxiste alumno";
		}

	}

	private boolean existeAlumno(Alumno unAlumno){
		return unAlumno.getNombre().equals(nombre) && unAlumno.getApellido().equals(apellido);
	}

}
