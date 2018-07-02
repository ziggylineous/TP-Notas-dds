package modelo;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.model.annotations.Observable;

@Observable
public class AsignacionTarea {
	private String tarea;
	private List<Nota> notas;
	
	public AsignacionTarea(String tarea) {
		this.tarea = tarea;

		notas = new ArrayList<>();
	}
	
	public boolean getAprobada() {
		return notas.stream().anyMatch(nota -> nota.getAprobada());
	}
	
	public void ponerNota(Nota nota) {
		notas.add(nota);
	}
	
	public String getTarea() { return tarea; }
	
	public List<Nota> getNotas() { return notas; }
	public void setNotas(List<Nota> notas) { this.notas = notas; }
}
