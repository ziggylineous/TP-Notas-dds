package modelo;

import org.uqbar.commons.model.annotations.Observable;

@Observable
public abstract class Nota {
    // public int id;
    // public Date createdAt;
    abstract boolean getAprobada();
}
