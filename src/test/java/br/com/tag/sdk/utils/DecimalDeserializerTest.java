package br.com.tag.sdk.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;

public class DecimalDeserializerTest {

    private ObjectMapper mapper;
    private DecimalDeserializer deserializer;

    @BeforeEach
    public void setup() {
        mapper = new ObjectMapper();
        deserializer = new DecimalDeserializer();
    }

    @Test
    void deserializeAsBigDecimal() throws IOException {

        long inputValue = 157579;
        BigDecimal expectedValue = BigDecimal.valueOf(1575.79);

        String json = String.format("{\"value\":%s}", inputValue);



        BigDecimal parsedReturn = deserializeBigDecimal(json);

        Assertions.assertEquals(expectedValue, parsedReturn);
    }

    private BigDecimal deserializeBigDecimal(String json) throws IOException {
        InputStream stream = new ByteArrayInputStream(json.getBytes(StandardCharsets.UTF_8));
        JsonParser parser = mapper.getFactory().createParser(stream);
        DeserializationContext ctx = mapper.getDeserializationContext();

        for(int i = 0; i < 3; i++)
            parser.nextToken();

        return deserializer.deserialize(parser, ctx);
    }
}
