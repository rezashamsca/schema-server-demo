package com.rtecsoft.alpha.schemaserverdemo.services.repositories;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.rtecsoft.alpha.schemaserverdemo.domain.Schema;

import java.util.List;

@Repository
public interface SchemaRepository extends MongoRepository<Schema, String> {
    @Query("{ 'content.$id' : '?0' }")
    List<Schema> findAllByContentId(String contentId);
}
