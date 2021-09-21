package api.java.javaweb.controller.Pcourse.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.time.LocalDate;


public class LocalDateSerializer extends StdSerializer<LocalDate> {

    public LocalDateSerializer(Class<LocalDate> t) {
        super(t);
    }
    public LocalDateSerializer() {
        this(null);
    }

    @Override
    public void serialize(LocalDate localDate, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException {

        jsonGenerator.writeString(String.valueOf(localDate.getYear()));
    }
}
