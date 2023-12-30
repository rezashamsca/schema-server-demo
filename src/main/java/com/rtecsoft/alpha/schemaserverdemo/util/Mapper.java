package com.rtecsoft.alpha.schemaserverdemo.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class Mapper {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static JsonNode map(Map<String, Object> json) {
        return objectMapper.valueToTree(json);
    }
}
