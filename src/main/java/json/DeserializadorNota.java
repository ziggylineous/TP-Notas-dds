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

        // TODO: sería algo así. Hay que guardar ids y tiempo de creación?
        JsonPrimitive valuePrimitive = json.getAsJsonPrimitive();

        if (valuePrimitive.isNumber()) {
            return new NotaNumerica(valuePrimitive.getAsInt());
        }
        else if (valuePrimitive.isString()) {
            return new NotaConceptual(EnumNotasConceptuales.valueOf(valuePrimitive.getAsString()));
        }
        else {
            throw new JsonParseException("DeserializadorNota: valor raro");
        }
    }
}
