package com.example.demo.StocksFactory;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.jsoup.nodes.Element;
import org.springframework.data.annotation.Id;

@Data
public abstract class Stock {
    @Id
    private String id;

    @JsonProperty("Symbol")
    private String symbol;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Price (Intraday)")
    private String price;

    @JsonProperty("Change")
    private String change;

    @JsonProperty("Change in %")
    private String changeInPercentage;

    public void convertElementToStock(Element stock){
        setSymbol(stock.child(0).text());
        setName(stock.child(1).text());
    };
}
