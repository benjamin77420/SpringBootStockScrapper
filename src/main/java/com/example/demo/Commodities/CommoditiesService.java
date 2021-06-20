package com.example.demo.Commodities;

import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommoditiesService {
    private final MongoTemplate mongoTemplate;
    private final String collectionName = "commodities";

    public List<Commodities> getAllCommodities(){
        return mongoTemplate.findAll(Commodities.class, collectionName);
    }

    public List<Commodities> getCommodity(String commoditySymbol){
        Query query = new Query();
        query.addCriteria(Criteria.where("symbol").is(commoditySymbol));

        return mongoTemplate.find(query, Commodities.class, collectionName);
    }
}
