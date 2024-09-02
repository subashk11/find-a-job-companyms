package com.springboot.microservice.companyms.shared;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.bson.types.ObjectId;

import java.io.IOException;
import java.util.List;

public class ObjectListSerializer extends JsonSerializer<List<ObjectId>> {
    @Override
    public void serialize(List<ObjectId> list, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartArray();
        for(ObjectId value : list){
            gen.writeString(value.toHexString());
        }
        gen.writeEndArray();
    }
}
