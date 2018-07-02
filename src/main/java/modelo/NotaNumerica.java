package modelo;

import org.uqbar.commons.model.annotations.Observable;

@Observable
public class NotaNumerica extends Nota {
    private int nota;

    public NotaNumerica(int nota) {
        this.nota = nota;
    }

    @Override
    public boolean getAprobada() {
        return nota >= 6;
    }

    @Override
    public String toString() {
        return Integer.toString(nota);
    }

}
