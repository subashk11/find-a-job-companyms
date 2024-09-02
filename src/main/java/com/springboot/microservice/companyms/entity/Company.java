package com.springboot.microservice.companyms.entity;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.springboot.microservice.companyms.shared.ObjectListSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "companies")
@TypeAlias("company")
public class Company {

    @Id
    private String id;
    private String name;
    private String description;

    @JsonSerialize(using = ObjectListSerializer.class)
    private List<ObjectId> jobs;

    @JsonSerialize(using = ObjectListSerializer.class)
    private List<ObjectId> reviews;
}
