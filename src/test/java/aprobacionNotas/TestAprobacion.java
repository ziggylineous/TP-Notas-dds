package aprobacionNotas;

import modelo.*;
import org.junit.Assert;

import org.junit.Test;

public class TestAprobacion{

    @Test
    public void noAproboNotaConceptual(){
        AsignacionTarea tpConceptual= new AsignacionTarea("TP Conceptual", "");
        tpConceptual.ponerNota(new NotaConceptual(EnumNotasConceptuales.MAL));
        Assert.assertEquals(false, tpConceptual.getAprobada());
    }

    @Test
    public void aproboNotaConceptual(){
        AsignacionTarea tpConceptual= new AsignacionTarea("TP Conceptual", "");
        tpConceptual.ponerNota(new NotaConceptual(EnumNotasConceptuales.BIEN));
        Assert.assertEquals(true, tpConceptual.getAprobada());
    }

    @Test
    public void noAproboNotaNumerica(){
        AsignacionTarea parcialNumerico = new AsignacionTarea("parcial", "");
        parcialNumerico.ponerNota(new NotaNumerica(4));
        Assert.assertEquals(false, parcialNumerico.getAprobada());
    }

    @Test
    public void aproboNotaNumerica(){
        AsignacionTarea parcialNumerico = new AsignacionTarea("parcial", "");
        parcialNumerico.ponerNota(new NotaNumerica(8));
        Assert.assertEquals(true, parcialNumerico.getAprobada());
    }

    @Test
    public void noAproboMuchasNotasConceptuales(){
        AsignacionTarea tpAnual= new AsignacionTarea("TP Anual", "");
        tpAnual.ponerNota(new NotaConceptual(EnumNotasConceptuales.MAL));
        tpAnual.ponerNota(new NotaConceptual(EnumNotasConceptuales.MAL));
        tpAnual.ponerNota(new NotaConceptual(EnumNotasConceptuales.MAL));
        Assert.assertEquals(false, tpAnual.getAprobada());
    }

    @Test
    public void aproboMuchasNotasConceptuales(){
        AsignacionTarea tpAnual= new AsignacionTarea("TP Anual", "");
        tpAnual.ponerNota(new NotaConceptual(EnumNotasConceptuales.MAL));
        tpAnual.ponerNota(new NotaConceptual(EnumNotasConceptuales.MAL));
        tpAnual.ponerNota(new NotaConceptual(EnumNotasConceptuales.REGULAR_MAS));
        Assert.assertEquals(true, tpAnual.getAprobada());
    }

    @Test
    public void noAproboMuchasNotasNumericas(){
        AsignacionTarea finalFisica = new AsignacionTarea("Final fisica", "");
        finalFisica.ponerNota(new NotaNumerica(2));
        finalFisica.ponerNota(new NotaNumerica(3));
        finalFisica.ponerNota(new NotaNumerica(4));
        finalFisica.ponerNota(new NotaNumerica(5));
        Assert.assertEquals(false, finalFisica.getAprobada());
    }

    @Test
    public void aproboMuchasNotasNumericas(){
        AsignacionTarea finalFisica = new AsignacionTarea("Final fisica", "");
        finalFisica.ponerNota(new NotaNumerica(3));
        finalFisica.ponerNota(new NotaNumerica(4));
        finalFisica.ponerNota(new NotaNumerica(5));
        finalFisica.ponerNota(new NotaNumerica(6));
        Assert.assertEquals(true, finalFisica.getAprobada());
    }

}