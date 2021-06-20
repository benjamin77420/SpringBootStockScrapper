package com.example.demo.MostActive;

import com.example.demo.Gainers.Gainers;
import lombok.Data;
import org.jsoup.nodes.Element;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "most-active")
public class MostActive extends Gainers {
    @Override
    public void convertElementToStock(Element stock) {
        super.convertElementToStock(stock);

    }
}
