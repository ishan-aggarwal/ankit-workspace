package microservicetest;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomLocalDateTimeSerializer extends JsonSerializer<LocalDate> {

    @Override
    public void serialize(LocalDate localDate, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM. dd. yyyy");
        jsonGenerator.writeString(formatter.format(localDate));
        jsonGenerator.writeEndObject();
    }
}