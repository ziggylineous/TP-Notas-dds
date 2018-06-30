package modelo;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.model.annotations.Observable;

@Observable
public class AsignacionTarea {
	private String tarea;
	private List<Integer> notas;
	
	public AsignacionTarea(String tarea) {
		this.tarea = tarea;
		notas = new ArrayList<>();
	}
	
	public boolean estaAprobada() {
		return notas.stream().anyMatch(nota -> nota.compareTo(new Integer(6)) >= 0);
	}
	
	public void ponerNota(Integer nota) {
		notas.add(nota);
	}
	
	public String getTarea() { return tarea; }
	
	public List<Integer> getNotas() { return notas; }
}
