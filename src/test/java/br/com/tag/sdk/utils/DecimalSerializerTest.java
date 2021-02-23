package br.com.tag.sdk.utils;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.math.BigDecimal;

public class DecimalSerializerTest {

    @Test
    void serializeABigInteger() throws IOException {

        Writer jsonWriter = new StringWriter();
        JsonGenerator jsonGenerator = new JsonFactory().createGenerator(jsonWriter);
        SerializerProvider serializerProvider = new ObjectMapper().getSerializerProvider();

        BigDecimal baseNumber = BigDecimal.valueOf(145.57);
        long expectedNumber = 14557;
        new DecimalSerializer().serialize(baseNumber, jsonGenerator, serializerProvider);

        jsonGenerator.flush();

        Assertions.assertEquals(expectedNumber,  Long.parseLong(jsonWriter.toString()));

    }
}
