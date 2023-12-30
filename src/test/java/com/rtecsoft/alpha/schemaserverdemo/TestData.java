package com.rtecsoft.alpha.schemaserverdemo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class TestData {

    public Map<String, Object> getObject() throws IOException {
        TypeReference<HashMap<String,Object>> typeRef
                = new TypeReference<HashMap<String,Object>>() {};
        return new ObjectMapper().readValue(getJsonSource(), typeRef);
    }

    public JsonNode getJsonNode(InputStream inputStream) throws IOException {
        return new ObjectMapper().readTree(getJsonSource());
    }

    public InputStream getJsonSource() {
        return getClass().getClassLoader().getResourceAsStream("product-schema.json");
    }

    public Map<String, Object> getInvalidObject() throws IOException {
        TypeReference<HashMap<String,Object>> typeRef
                = new TypeReference<>() {};
        return new ObjectMapper().readValue(getInvalidJsonSource(), typeRef);
    }

    private InputStream getInvalidJsonSource() {
        return getClass().getClassLoader().getResourceAsStream("invalid-product-schema.json");
    }


}
