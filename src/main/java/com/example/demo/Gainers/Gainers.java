package com.example.demo.Gainers;

import com.example.demo.StocksFactory.Stock;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.jsoup.nodes.Element;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "gainers")
public class Gainers extends Stock {
    @JsonProperty("Volume")
    private String volume;

    @JsonProperty("Avg volume (3 month")
    private String averageVolume3Months;

    @JsonProperty("Market cap")
    private String marketCap;

    @JsonProperty("PE ration (TTM)")
    private String peRationTtm;


    @Override
    public void convertElementToStock(Element stock) {
        super.convertElementToStock(stock);
        setPrice(stock.child(2).text());
        setChange(stock.child(3).text());
        setChangeInPercentage(stock.child(4).text());
        setVolume(stock.child(5).text());
        setAverageVolume3Months(stock.child(6).text());
        setMarketCap(stock.child(7).text());
        setPeRationTtm(stock.child(8).text());
    }
}
