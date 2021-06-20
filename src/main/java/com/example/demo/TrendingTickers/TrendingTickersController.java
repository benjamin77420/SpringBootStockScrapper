package com.example.demo.TrendingTickers;

import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "trendingTickers")
@AllArgsConstructor
public class TrendingTickersController {
    private final TrendingTickersService trendingTickersService;

    @GetMapping(path = "/all")
    public List<TrendingTickers> getAllTrendingTickers() {
        return trendingTickersService.getAllTredingTickers();
    }

    @GetMapping(path = "{trendingTickersSymbol}")
    public List<TrendingTickers> getTrendingTicker(@PathVariable("trendingTickersSymbol") String trendingTickersSymbol){
        Query query = new Query();
        query.addCriteria(Criteria.where("symbol").is(trendingTickersSymbol));

        return trendingTickersService.getTrendingTickers(trendingTickersSymbol);
    }

    @GetMapping(path = "{trendingTickersSymbol}/price")
    public String getTrendingTickerPrice(@PathVariable("trendingTickersSymbol") String trendingTickersSymbol){
        return getTrendingTicker(trendingTickersSymbol).get(0).getPrice();
    }
}
