package com.example.demo.Currencies;

import com.example.demo.StocksFactory.Stock;
import lombok.Data;
import org.jsoup.nodes.Element;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "currencies")
public class Currencies extends Stock {
    @Override
    public void convertElementToStock(Element stock) {
        super.convertElementToStock(stock);
        setPrice(stock.child(2).text());
        setChange(stock.child(3).text());
        setChangeInPercentage(stock.child(4).text());
    }
}
