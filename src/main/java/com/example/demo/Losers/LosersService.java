package com.example.demo.Losers;

import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LosersService {
    private final MongoTemplate mongoTemplate;
    private final String collectionName = "losers";

    public List<Losers> getAllLosers(){
        return mongoTemplate.findAll(Losers.class, collectionName);
    }

    public List<Losers> getLosers(String LosersSymbol){
        Query query = new Query();
        query.addCriteria(Criteria.where("symbol").is(LosersSymbol));

        return mongoTemplate.find(query, Losers.class, collectionName);

    }
}
