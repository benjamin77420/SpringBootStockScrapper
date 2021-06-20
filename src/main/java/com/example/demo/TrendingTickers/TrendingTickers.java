package com.example.demo.TrendingTickers;

import com.example.demo.StocksFactory.Stock;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.jsoup.nodes.Element;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "trending-tickers")
public class TrendingTickers extends Stock {
    @JsonProperty("Market time")
    private String marketTime;

    @JsonProperty("Volume")
    private String volume;

    @JsonProperty("Market cap")
    private String marketCap;

    @Override
    public void convertElementToStock(Element stock) {
        super.convertElementToStock(stock);
        setPrice(stock.child(2).text());
    }
}
