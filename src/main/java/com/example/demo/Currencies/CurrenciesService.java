package com.example.demo.Currencies;


import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CurrenciesService {
    private final MongoTemplate mongoTemplate;
    private final String collectionName = "currencies";

    public List<Currencies> getAllCurrency(){
        return mongoTemplate.findAll(Currencies.class, collectionName);
    }

    public List<Currencies> getCurrency(String currencySymbol){
        Query query = new Query();
        query.addCriteria(Criteria.where("symbol").is(currencySymbol));

        return mongoTemplate.find(query, Currencies.class, collectionName);

    }
}
