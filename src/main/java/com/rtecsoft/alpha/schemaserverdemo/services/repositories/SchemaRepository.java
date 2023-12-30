package com.rtecsoft.alpha.schemaserverdemo.services.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.rtecsoft.alpha.schemaserverdemo.domain.Schema;

@Repository
public interface SchemaRepository extends MongoRepository<Schema, String> {
}
