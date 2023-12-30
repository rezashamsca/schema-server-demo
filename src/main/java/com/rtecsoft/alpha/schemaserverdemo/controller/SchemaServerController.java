package com.rtecsoft.alpha.schemaserverdemo.controller;

import com.rtecsoft.alpha.schemaserverdemo.controller.resource.SchemaServerRegisterResponse;
import com.rtecsoft.alpha.schemaserverdemo.controller.resource.SchemaServerValidateResponse;
import com.rtecsoft.alpha.schemaserverdemo.domain.Schema;
import com.rtecsoft.alpha.schemaserverdemo.services.schema.SchemaServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
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

    @RequestMapping(
            value = "/schema/{id}",
            produces = "application/json",
            method = RequestMethod.GET)
    public ResponseEntity<Schema> getSchema(@PathVariable String id) {
        // Get schema based on unique database id
        Optional<Schema> schema = schemaService.getSchema(id);
        return schema.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @RequestMapping(
            value = "/schema/content",
            produces = "application/json",
            method = RequestMethod.GET)
    public ResponseEntity<Schema[]> getSchemaByContentId(@RequestParam String id) {
        if (id == null || id.isEmpty()) {
            log.error("Invalid content id");
            return ResponseEntity.badRequest().build();
        }

        // Get schema content based on schema identifier
        List<Schema> schemas = schemaService.getSchemaByContentId(id);
        if (schemas.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(schemas.toArray(new Schema[0]));
        }
    }



}
