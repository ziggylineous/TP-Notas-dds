package modelo;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import org.uqbar.commons.model.annotations.Observable;

@Observable
public class Alumno {
    @SerializedName("first_name")
    private String nombre;

    @SerializedName("last_name")
    private String apellido;

    @SerializedName("code")
    private String legajo;

    @SerializedName("github_user")
    private String usuarioGithub;
    
    private List<AsignacionTarea> asignacionesDeTareas;

    public Alumno(String nombre, String apellido, String legajo, String usuarioGithub) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.usuarioGithub = usuarioGithub;
        
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

    public String getUsuarioGithub() { return usuarioGithub; }
    public void setUsuarioGithub(String usuarioGithub) { this.usuarioGithub = usuarioGithub; }

    public List<AsignacionTarea> getAsignacionesDeTareas() { return asignacionesDeTareas; }
    public void setAsignacionesDeTareas(List<AsignacionTarea> nuevasAsignacionesDeTareas) {
        this.asignacionesDeTareas = nuevasAsignacionesDeTareas;
    }

    public String getApellidoYNombre() { return String.format("%s, %s", apellido, nombre); }

    public boolean tieneAlgunaAsignacion() {
        return !asignacionesDeTareas.isEmpty();
    }

    @Override
    public String toString() {
        return String.format("nombre: %s\napellido: %s\nlegajo: %s\ngithub: %s",
                nombre, apellido, legajo, usuarioGithub);
    }
}
