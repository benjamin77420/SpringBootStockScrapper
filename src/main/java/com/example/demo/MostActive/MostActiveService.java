package com.example.demo.MostActive;

import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MostActiveService {
    private final MongoTemplate mongoTemplate;
    private final String collectionName = "most-active";

    public List<MostActive> getAllMostActive(){
        return mongoTemplate.findAll(MostActive.class, collectionName);
    }

    public List<MostActive> getMostActive(String mostActiveSymbol){
        Query query = new Query();
        query.addCriteria(Criteria.where("symbol").is(mostActiveSymbol));

        return mongoTemplate.find(query, MostActive.class, collectionName);

    }
}
