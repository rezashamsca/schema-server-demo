package com.rtecsoft.alpha.schemaserverdemo.services.schema;

import com.networknt.schema.ValidationMessage;
import com.rtecsoft.alpha.schemaserverdemo.domain.Schema;

import java.util.Map;
import java.util.Set;

public interface SchemaValidationService {
    boolean isValidSchema(final Schema schema);

    Set<ValidationMessage> validate(Map<String, Object> data);
}
