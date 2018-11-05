package json;

import com.google.gson.*;
import modelo.EnumNotasConceptuales;
import modelo.Nota;
import modelo.NotaConceptual;
import modelo.NotaNumerica;

import java.lang.reflect.Type;

public class DeserializadorNota implements JsonDeserializer<Nota> {
    @Override
    public Nota deserialize(final JsonElement json,
                            final Type typeOfT,
                            final JsonDeserializationContext context) throws JsonParseException {

        // por ahora no hace falta guardar ids y tiempo de creación
        // con el valor alcanza
        JsonObject jsonNota = json.getAsJsonObject();
        JsonPrimitive valuePrimitive = jsonNota.get("nota").getAsJsonPrimitive();

        if (valuePrimitive.isNumber()) {
            return new NotaNumerica(valuePrimitive.getAsInt());
        }
        else if (valuePrimitive.isString()) {
            return new NotaConceptual(EnumNotasConceptuales.desdeNombre(valuePrimitive.getAsString()));
        }
        else {
            throw new JsonParseException("DeserializadorNota: valor de nota raro, ni int ni string");
        }
    }
}
