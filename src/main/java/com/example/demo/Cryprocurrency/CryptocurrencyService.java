package com.example.demo.Cryprocurrency;

import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CryptocurrencyService {
    private final MongoTemplate mongoTemplate;
    private final String collectionName = "cryptocurrencies";

    public List<CryptoCoin> getStockBySymbol(String symbol){
        Query query = new Query();
        query.addCriteria(Criteria.where("symbol").is(symbol));

        return mongoTemplate.find(query, CryptoCoin.class, collectionName);
    }

    public List<CryptoCoin> getAllCoins(){
        return mongoTemplate.findAll(CryptoCoin.class, collectionName);
    }
}



