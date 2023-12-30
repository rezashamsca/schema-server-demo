package com.rtecsoft.alpha.schemaserverdemo.config;

import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.net.URISyntaxException;

@Configuration
public class SchemaServerConfig {
    @Bean
    public JsonSchema schema() throws URISyntaxException {
        JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V202012);
        URI uri = new URI("https://json-schema.org/draft/2020-12/schema");
        JsonSchema schemaSchema = factory.getSchema(uri);
        schemaSchema.initializeValidators();
        return schemaSchema;
    }
}
