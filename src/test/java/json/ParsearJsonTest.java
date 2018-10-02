package json;

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

        System.out.println(notaNumericaJson);
        System.out.println(notaConceptualJson);
    }
}
