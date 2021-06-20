package com.example.demo.Commodities;

import com.example.demo.StocksFactory.Stock;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.jsoup.nodes.Element;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "commodities")
public class Commodities extends Stock {
    @JsonProperty("Market time")
    private String marketTime;
    @JsonProperty("Volume")
    private String volume;
    @JsonProperty("Open interest")
    private String openInterest;

    @Override
    public void convertElementToStock(Element stock){
        super.convertElementToStock(stock);
        setPrice(stock.child(2).text());
        setMarketTime(stock.child(3).text());
        setChange(stock.child(4).text());
        setChangeInPercentage(stock.child(5).text());
        setVolume(stock.child(6).text());
        setOpenInterest(stock.child(7).text());
    }
}
