package modelo;

public enum EnumNotasConceptuales {
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
}
