package com.rtecsoft.alpha.schemaserverdemo.domain;

import lombok.Builder;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Builder
@Getter
@Document(collection = "schemas")
public class Schema {
    @Id
    private ObjectId _id;
    private String version;
    private String[] tags;
    private Map<String, Object> content;
}
