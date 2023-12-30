package com.rtecsoft.alpha.schemaserverdemo.services.schema;

import com.networknt.schema.JsonSchema;
import com.rtecsoft.alpha.schemaserverdemo.TestData;
import com.rtecsoft.alpha.schemaserverdemo.config.SchemaServerConfig;
import com.rtecsoft.alpha.schemaserverdemo.domain.Schema;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Import(SchemaServerConfig.class)
class SchemaValidationServiceImplTest {
    @Autowired
    private SchemaValidationService schemaValidationService;

    @Test
    void isValidSchema() throws IOException {
        TestData testData = new TestData();
        Schema schema = Schema.builder()
                .content(testData.getObject())
                .build();

        var result = schemaValidationService.isValidSchema(schema);
        assertTrue(result);
    }

    @Test
    void notIsValidSchema() throws IOException {
        TestData testData = new TestData();
        Schema schema = Schema.builder()
                .content(testData.getInvalidObject())
                .build();

        var result = schemaValidationService.isValidSchema(schema);
        assertFalse(result);
    }
}