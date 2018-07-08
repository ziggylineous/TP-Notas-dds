package modelo;


import org.uqbar.commons.model.annotations.Observable;

@Observable
public class NotaConceptual extends Nota {
    private EnumNotasConceptuales nota ;

    public NotaConceptual(EnumNotasConceptuales unaNota){
        this.nota = unaNota;
    }

    @Override
    public boolean getAprobada(){
        return this.nota.aprueba();
    }

    @Override
    public String toString() {
        return nota.getNotaConceptual();
    }

}
