package com.rtecsoft.alpha.schemaserverdemo.services.schema;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SchemaServiceImplTest {
    @Autowired
    private SchemaServiceImpl schemaService;

    @Test
    void getSchemaByContentId() {
        final String contentId = "https://example.com/product.schema.json";
        var schemas =  schemaService.getSchemaByContentId(contentId);
        assertFalse(schemas.isEmpty());
    }
}