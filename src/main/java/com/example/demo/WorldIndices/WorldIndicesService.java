package com.example.demo.WorldIndices;

import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.lang.module.FindException;
import java.util.List;

@Service
@AllArgsConstructor
public class WorldIndicesService {
    private final MongoTemplate mongoTemplate;
    private final String collectionName = "world-indices";

    public List<WorldIndices> getAllWorldIndices(){
        return mongoTemplate.findAll(WorldIndices.class, collectionName);
    }

    public List<WorldIndices> getWorldIndices(String worldIndicesSymbol){
        Query query = new Query();
        query.addCriteria(Criteria.where("symbol").is(worldIndicesSymbol));

        return mongoTemplate.find(query, WorldIndices.class, collectionName);
    }
}
