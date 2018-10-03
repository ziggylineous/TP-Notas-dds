package json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelo.AsignacionTarea;
import modelo.Nota;
import modelo.NotaConceptual;
import modelo.NotaNumerica;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParsearJsonTest {
    Gson parser;

    @Before
    public void setupParser() {
        GsonBuilder parserBuilder = new GsonBuilder();
        parserBuilder.registerTypeAdapter(Nota.class, new DeserializadorNota());
        parser = parserBuilder.create();
    }

    @Test
    public void leerNotasTest() {
        String notaNumericaJson =
        "{\n" +
            "\t\"id\": 4,\n" +
            "\t\"value\": 5,\n" +
            "\t\"created_at\": \"2017-03-25T13:56:07.649Z\",\n" +
            "\t\"updated_at\": \"2017-03-25T13:56:07.649Z\"\n" +
        "}";

        String notaConceptualJson =
        "{\n" +
            "\t\"id\": 4,\n" +
            "\t\"value\": \"B+\",\n" +
            "\t\"created_at\": \"2017-03-25T13:56:07.649Z\",\n" +
            "\t\"updated_at\": \"2017-03-25T13:56:07.649Z\"\n" +
        "}";

        Nota conceptual = parser.fromJson(notaConceptualJson, Nota.class);
        Nota numerica = parser.fromJson(notaNumericaJson, Nota.class);

        Assert.assertSame(NotaNumerica.class, numerica.getClass());
        Assert.assertSame(NotaConceptual.class, conceptual.getClass());
    }

    @Test
    public void leerAsignación() {
        String jsonAsignacion =
        "{\n" +
        "\t\"id\": 1,\n" +
        "\t\"title\": \"Primer Parcial\",\n" +
        "\t\"description\": \"diseño con objetos\",\n" +
        "\t\"grades\": [{\n" +
            "\t\t\"id\": 4,\n" +
            "\t\t\"value\": 5,\n" +
            "\t\t\"created_at\": \"2017-03-25T13:56:07.649Z\",\n" +
            "\t\t\"updated_at\": \"2017-03-25T13:56:07.649Z\"\n" +
        "\t},\n" +
        "\t{\n" +
            "\t\t\"id\": 2,\n" +
            "\t\t\"value\": 7,\n" +
            "\t\t\"created_at\": \"2017-03-25T13:56:07.595Z\",\n" +
            "\t\t\"updated_at\": \"2017-03-25T13:56:07.595Z\"\n" +
            "\t}]\n}";

        AsignacionTarea asignacion = parser.fromJson(jsonAsignacion, AsignacionTarea.class);

        Assert.assertNotNull(asignacion);
        Assert.assertEquals("Primer Parcial", asignacion.getTarea());
        Assert.assertEquals("diseño con objetos", asignacion.getDescripcion());
        Assert.assertSame(2, asignacion.getNotas().size());

        Nota nota0 = asignacion.getNotas().get(0);
        Assert.assertSame(5, ((NotaNumerica) nota0).getNota() );

        Nota nota1 = asignacion.getNotas().get(1);
        Assert.assertSame(7, ((NotaNumerica) nota1).getNota() );
    }

    public void leerAsignaciones() {
        String asignacionesJson =
        "\"assignments\": [{\n" +
        "        \"id\": 1,\n" +
        "        \"title\": \"Primer Parcial\",\n" +
        "        \"description\": null,\n" +
        "        \"grades\": [{\n" +
        "            \"id\": 1,\n" +
        "            \"value\": 2,\n" +
        "            \"created_at\": \"2017-03-25T13:56:07.526Z\",\n" +
        "            \"updated_at\": \"2017-03-25T13:56:07.526Z\"\n" +
        "        },\n" +
        "        {\n" +
        "            \"id\": 2,\n" +
        "            \"value\": 7,\n" +
        "            \"created_at\": \"2017-03-25T13:56:07.595Z\",\n" +
        "            \"updated_at\": \"2017-03-25T13:56:07.595Z\"\n" +
        "        }]\n" +
        "    },\n" +
        "\n" +
        "    {\n" +
        "        \"id\": 3,\n" +
        "        \"title\": \"TPA1\",\n" +
        "        \"description\": \"Primera Entrega del TP Anual\",\n" +
        "        \"grades\": [{\n" +
        "            \"id\": 4,\n" +
        "            \"value\": \"B+\",\n" +
        "            \"created_at\": \"2017-03-25T13:56:07.649Z\",\n" +
        "            \"updated_at\": \"2017-03-25T13:56:07.649Z\"\n" +
        "        }]\n" +
        "    }]\n" +
        "}";

        AsignacionTarea[] asignaciones = parser.fromJson(asignacionesJson, AsignacionTarea[].class);

        Assert.assertSame(2, asignaciones.length);

        Assert.assertEquals("Primer Parcial", asignaciones[0].getTarea());
        Assert.assertNull(asignaciones[0].getDescripcion());
        Assert.assertSame(2, asignaciones[0].getNotas().size());

        Assert.assertEquals("TPA1", asignaciones[1].getTarea());
        Assert.assertEquals("Primera Entrega del TP Anual",asignaciones[1].getDescripcion());
        Assert.assertSame(1, asignaciones[1].getNotas().size());
    }
}
