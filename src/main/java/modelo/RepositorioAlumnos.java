package modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import json.DeserializadorNota;

import java.util.Optional;

public class RepositorioAlumnos {
    Alumno[] alumnos;

    public RepositorioAlumnos() {
        Gson parser = new GsonBuilder()
                .registerTypeAdapter(Nota.class, new DeserializadorNota())
                .create();

        String jsonPrueba = "[\n" +
                "  {\n" +
                "    \"nombre\": \"Tuco\",\n" +
                "    \"apellido\": \"Amarello\",\n" +
                "    \"legajo\": \"1234560\",\n" +
                "    \"usuarioGithub\": \"Tuqui\",\n" +
                "    \"asignacionesDeTareas\": [\n" +
                "      {\n" +
                "        \"tarea\": \"Primer Parcial\",\n" +
                "        \"descripcion\": \"Diseño con Objetos. Cualidades del Diseño. Refactors\",\n" +
                "        \"notas\": [\n" +
                "          { \"nota\": 2 },\n" +
                "          { \"nota\": 6 }\n" +
                "        ]\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"nombre\": \"Turco\",\n" +
                "    \"apellido\": \"García\",\n" +
                "    \"legajo\": \"11122330\",\n" +
                "    \"usuarioGithub\": \"TurcoGarcia\",\n" +
                "    \"asignacionesDeTareas\": [\n" +
                "      {\n" +
                "        \"tarea\": \"Primer Parcial\",\n" +
                "        \"descripcion\": \"Diseño con Objetos. Cualidades del Diseño. Refactors\",\n" +
                "        \"notas\": [\n" +
                "          { \"nota\": 8 }\n" +
                "        ]\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]";

        alumnos = parser.fromJson(jsonPrueba, Alumno[].class);
    }

    public Optional<Alumno> buscarConLegajo(String legajo) {
        // todo
        return Optional.empty();
    }

    // metodo para probar que manda todos los alumnos; sacar
    public Alumno[] todos() {
        return alumnos;
    }
}
