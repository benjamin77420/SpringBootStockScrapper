package com.example.demo.TrendingTickers;

import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TrendingTickersService {
    private final MongoTemplate mongoTemplate;
    private final String collectionName = "trending-tickers";

    public List<TrendingTickers> getAllTredingTickers(){ return mongoTemplate.findAll(TrendingTickers.class, collectionName); }

    public List<TrendingTickers> getTrendingTickers(String trendingTickerSymbol){
        Query query = new Query();
        query.addCriteria(Criteria.where("symbol").is(trendingTickerSymbol));

        return mongoTemplate.find(query, TrendingTickers.class, collectionName);
    }
}
