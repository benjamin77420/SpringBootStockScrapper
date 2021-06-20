package com.example.demo.WorldIndices;

import com.example.demo.StocksFactory.Stock;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.jsoup.nodes.Element;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "world-indices")
public class WorldIndices extends Stock {
    @JsonProperty("Volume")
    private String volume;

    @Override
    public void convertElementToStock(Element stock) {
        super.convertElementToStock(stock);
        setPrice(stock.child(2).text());
        setChange(stock.child(3).text());
        setChangeInPercentage(stock.child(4).text());
        setVolume(stock.child(5).text());
    }
}
