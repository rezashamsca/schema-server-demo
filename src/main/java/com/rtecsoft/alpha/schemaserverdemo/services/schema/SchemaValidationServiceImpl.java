package com.rtecsoft.alpha.schemaserverdemo.services.schema;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.ValidationMessage;
import com.rtecsoft.alpha.schemaserverdemo.domain.Schema;
import com.rtecsoft.alpha.schemaserverdemo.util.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Slf4j
@Service
public class SchemaValidationServiceImpl implements SchemaValidationService {
    private final JsonSchema jsonSchema;

    SchemaValidationServiceImpl(JsonSchema jsonSchema) {
        this.jsonSchema = jsonSchema;
    }
    @Override
    public boolean isValidSchema(Schema schema) {
        Set<ValidationMessage> result = validate(schema.getContent());
        return result.isEmpty();
    }

    @Override
    public Set<ValidationMessage> validate(Map<String, Object> data) {
        JsonNode jsonNode = Mapper.map(data);
        Set<ValidationMessage> result = jsonSchema.validate(jsonNode);
        log.info("Validation result: {}", result);
        return result;
    }
}
