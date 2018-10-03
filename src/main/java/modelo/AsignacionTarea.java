package modelo;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import org.uqbar.commons.model.annotations.Observable;

@Observable
public class AsignacionTarea {
	@SerializedName("title")
	private String tarea;

	@SerializedName("description")
	private String descripcion;

	@SerializedName("grades")
	private List<Nota> notas;
	
	public AsignacionTarea(String tarea, String descripcion) {
		this.tarea = tarea;
		this.descripcion = descripcion;

		notas = new ArrayList<>();
	}
	
	public boolean getAprobada() {
		return notas.stream().anyMatch(nota -> nota.getAprobada());
	}
	
	public void ponerNota(Nota nota) {
		notas.add(nota);
	}
	
	public String getTarea() { return tarea; }
	public String getDescripcion() { return descripcion; }

	public List<Nota> getNotas() { return notas; }
	public void setNotas(List<Nota> notas) { this.notas = notas; }
}
