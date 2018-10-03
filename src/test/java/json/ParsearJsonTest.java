package json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelo.Nota;
import modelo.NotaConceptual;
import modelo.NotaNumerica;
import org.junit.Assert;
import org.junit.Test;

public class ParsearJsonTest {
    @Test
    public void leerAsignacionesTest() {
/*{
    "assignments": [{
        "id": 1,
        "title": "Primer Parcial",
        "description": null,
        "grades": [{
            "id": 1,
            "value": 2,
            "created_at": "2017-03-25T13:56:07.526Z",
            "updated_at": "2017-03-25T13:56:07.526Z"
        },
        {
            "id": 2,
            "value": 7,
            "created_at": "2017-03-25T13:56:07.595Z",
            "updated_at": "2017-03-25T13:56:07.595Z"
        }]
    },

    {
        "id": 3,
        "title": "TPA1",
        "description": "Primera Entrega del TP Anual",
        "grades": [{
            "id": 4,
            "value": "B+",
            "created_at": "2017-03-25T13:56:07.649Z",
            "updated_at": "2017-03-25T13:56:07.649Z"
        }]
    }]
}*/

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

        GsonBuilder parserBuilder = new GsonBuilder();
        parserBuilder.registerTypeAdapter(Nota.class, new DeserializadorNota());
        Gson parser = parserBuilder.create();

        Nota conceptual = parser.fromJson(notaConceptualJson, Nota.class);
        Nota numerica = parser.fromJson(notaNumericaJson, Nota.class);

        Assert.assertSame(NotaNumerica.class, numerica.getClass());
        Assert.assertSame(NotaConceptual.class, conceptual.getClass());
    }
}
