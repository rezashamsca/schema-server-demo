package com.rtecsoft.alpha.schemaserverdemo.controller.resource;

import com.networknt.schema.ValidationMessage;
import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Getter
@Builder
public class SchemaServerValidateResponse {
    private boolean valid;
    private Set<ValidationMessage> errors;
}
