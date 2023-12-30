package com.rtecsoft.alpha.schemaserverdemo.services.schema;

import com.networknt.schema.ValidationMessage;
import com.rtecsoft.alpha.schemaserverdemo.domain.Schema;
import com.rtecsoft.alpha.schemaserverdemo.services.repositories.SchemaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class SchemaServiceImpl {
    private final SchemaRepository repository;
    private final SchemaValidationServiceImpl schemaValidationService;

    public Schema register(final Schema schema) {
        // Make sure it's valid schema
        if (!isValidSchema(schema)) {
            throw new IllegalArgumentException("Invalid schema");
        }

        // Store in database
        Schema savedSchema = repository.save(schema);
        log.debug("Saved schema: {}", savedSchema);
        return savedSchema;
    }

    public Set<ValidationMessage> validate(final Map<String, Object> data) {
        // Make sure it's valid schema
        // Validate data
        Set<ValidationMessage> errors = schemaValidationService.validate(data);
        log.debug("Validation errors: {}", errors);
        return errors;
    }

    private boolean isValidSchema(final Schema schema) {
        return schemaValidationService.isValidSchema(schema);
    }
}
