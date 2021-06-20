package com.example.demo.Cryprocurrency;

import com.example.demo.StocksFactory.Stock;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.jsoup.nodes.Element;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "cryptocurrencies")
public class CryptoCoin extends Stock {

    @JsonProperty("Market cap")
    private String marketCap;

    @JsonProperty("Volume in Currency (Since 0:00 UTC)")
    private String volumeInCurrencyUtc;

    @JsonProperty("Volume in Currency (24Hr)")
    private String volumeInCurrencyLocalDay;

    @JsonProperty("Total Volume All Currencies (24Hr)")
    private String totalVolumeInCurrencyLocalDay;

    @JsonProperty("Circulating Supply")
    private String circulatingSupply;

    @Override
    public void convertElementToStock(Element stock) {
        super.convertElementToStock(stock);
        setPrice(stock.child(2).text());
        setChange(stock.child(3).text());
        setChangeInPercentage(stock.child(4).text());
        setMarketCap(stock.child(5).text());
        setVolumeInCurrencyUtc(stock.child(6).text());
        setVolumeInCurrencyLocalDay(stock.child(7).text());
        setTotalVolumeInCurrencyLocalDay(stock.child(8).text());
        setCirculatingSupply(stock.child(9).text());
    }
}
