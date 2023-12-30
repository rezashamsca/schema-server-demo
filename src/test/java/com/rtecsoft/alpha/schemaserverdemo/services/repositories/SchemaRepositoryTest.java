package com.rtecsoft.alpha.schemaserverdemo.services.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SchemaRepositoryTest {
    @Autowired
    private SchemaRepository schemaRepository;

    @Test
    void test() {
        assertNotNull(schemaRepository);
    }

}