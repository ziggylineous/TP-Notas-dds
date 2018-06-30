package modelo;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.model.annotations.Observable;

@Observable
public class Alumno {
    private String nombre;
    private String apellido;
    private String legajo;
    
    private List<AsignacionTarea> asignacionesDeTareas;

    public Alumno(String nombre, String apellido, String legajo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        
        asignacionesDeTareas = new ArrayList<>();
    }

    public void agregarAsignacionDeTarea(AsignacionTarea asignacionDeTarea) {
    	asignacionesDeTareas.add(asignacionDeTarea);
    }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nuevoNombre) { nombre = nuevoNombre; }
    
    public String getApellido() { return apellido; }
    public void setApellido(String nuevoApellido) { apellido = nuevoApellido; }
    
    public String getLegajo() { return legajo; }
    public void setLegajo(String nuevoLegajo) { apellido = nuevoLegajo; }
    
    public List<AsignacionTarea> getAsignacionesDeTareas() { return asignacionesDeTareas; }

    public void setAsignacionesDeTareas(List<AsignacionTarea> nuevasAsignacionesDeTareas) {
        this.asignacionesDeTareas = nuevasAsignacionesDeTareas;
    }
}
