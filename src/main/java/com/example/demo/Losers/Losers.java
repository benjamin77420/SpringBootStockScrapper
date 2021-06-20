package com.example.demo.Losers;

import com.example.demo.Gainers.Gainers;
import lombok.Data;
import org.jsoup.nodes.Element;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "losers")
public class Losers extends Gainers {
    @Override
    public void convertElementToStock(Element stock) {
        super.convertElementToStock(stock);
    }
}
