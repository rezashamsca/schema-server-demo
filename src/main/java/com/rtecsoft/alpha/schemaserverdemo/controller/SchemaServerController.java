package com.rtecsoft.alpha.schemaserverdemo.controller;

import com.rtecsoft.alpha.schemaserverdemo.controller.resource.SchemaServerRegisterResponse;
import com.rtecsoft.alpha.schemaserverdemo.controller.resource.SchemaServerValidateResponse;
import com.rtecsoft.alpha.schemaserverdemo.domain.Schema;
import com.rtecsoft.alpha.schemaserverdemo.services.schema.SchemaServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path="/api/v1")
@AllArgsConstructor
public class SchemaServerController {
    private final SchemaServiceImpl schemaService;
    @RequestMapping(
            value = "/register",
            consumes = "application/json",
            produces = "application/json",
            method = RequestMethod.POST)
    public ResponseEntity<SchemaServerRegisterResponse> register(@RequestBody Schema schema) {
        // Make sure it's valid schema & store in Db
        Schema savedSchema = schemaService.register(schema);

        // Return response
        SchemaServerRegisterResponse response = SchemaServerRegisterResponse.builder()
                .id(savedSchema.get_id().toString())
                .build();

        return ResponseEntity.ok(response);
    }

    @RequestMapping(
            value = "/validate",
            consumes = "application/json",
            produces = "application/json",
            method = RequestMethod.POST)
    public ResponseEntity<SchemaServerValidateResponse> validate(@RequestBody Map<String, Object> data) {
        // Validate data
        var errors = schemaService.validate(data);
        SchemaServerValidateResponse response = SchemaServerValidateResponse.builder()
                .valid(errors.isEmpty())
                .errors(errors)
                .build();
        return ResponseEntity.ok(response);
    }

}
