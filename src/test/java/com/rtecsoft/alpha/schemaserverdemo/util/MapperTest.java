package com.rtecsoft.alpha.schemaserverdemo.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.rtecsoft.alpha.schemaserverdemo.TestData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapperTest {

    @Test
    void map() throws IOException {
        TestData testData = new TestData();
        Map<String, Object> json = testData.getObject();
        JsonNode node = Mapper.map(json);
        assertEquals("https://json-schema.org/draft/2020-12/schema", node.get("$schema").asText());
    }
}