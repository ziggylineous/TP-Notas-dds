package modelo;

import java.util.Arrays;

public enum EnumNotasConceptuales {
    BIEN_MAS("B+", true),
    BIEN("B", true),
    BIEN_MENOS("B-", true),
    REGULAR_MAS("R+", true),
    REGULAR("R", true),
    REGULAR_MENOS("R-", true),
    MAL("M", false);

    public final String notaConceptual;
    public final boolean notaAprueba;

    EnumNotasConceptuales(String nota , boolean aprueba){
        this.notaConceptual = nota;
        this.notaAprueba = aprueba;
    }

    public String getNotaConceptual() {
        return notaConceptual;
    }

    public boolean aprueba(){
        return notaAprueba;
    }

    static public EnumNotasConceptuales desdeNombre(String nombre) {
        EnumNotasConceptuales nota = Arrays.stream(values())
                .filter(nombreNota -> nombreNota.equals(nombre))
                .findAny()
                .orElseThrow(() -> new EnumConstantNotPresentException(EnumNotasConceptuales.class, nombre));

        return nota;
    }
}
