package com.example.demo.Gainers;

import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GainersService {
    private final MongoTemplate mongoTemplate;
    private final String collectionName = "gainers";

    public List<Gainers> getAllGainers(){
        return mongoTemplate.findAll(Gainers.class, collectionName);
    }

    public List<Gainers> getGainers(String GainersSymbol){
        Query query = new Query();
        query.addCriteria(Criteria.where("symbol").is(GainersSymbol));

        return mongoTemplate.find(query, Gainers.class, collectionName);

    }
}
