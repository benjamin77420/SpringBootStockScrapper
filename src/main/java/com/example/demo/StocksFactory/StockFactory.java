package com.example.demo.StocksFactory;

import com.example.demo.Commodities.Commodities;
import com.example.demo.Cryprocurrency.CryptoCoin;
import com.example.demo.Currencies.Currencies;
import com.example.demo.Gainers.Gainers;
import com.example.demo.Losers.Losers;
import com.example.demo.MostActive.MostActive;
import com.example.demo.TrendingTickers.TrendingTickers;
import com.example.demo.WorldIndices.WorldIndices;
import org.springframework.stereotype.Service;

@Service
public class StockFactory implements Factory{
    private static volatile StockFactory instance;
    private static Object check = new Object();

    private StockFactory() { }

    public static StockFactory getStockFactory(){
        StockFactory result = instance;
        if(result == null){
            synchronized (check){
                result = instance;
                if(result == null){
                    result = instance = new StockFactory();
                }
            }
        }
        return result;
    }

    public Stock makeStock(String stockType){
        switch (stockType){
            case "cryptocurrencies":
                return new CryptoCoin();
            case "trending-tickers":
                return new TrendingTickers();
            case "most-active":
                return new MostActive();
            case "gainers":
                return new Gainers();
            case "losers":
                return new Losers();
            case "commodities":
                return new Commodities();
            case "world-indices":
                return new WorldIndices();
            case "currencies":
                return new Currencies();
            default:
                System.out.println("No matching datatype was found");
        }

        return null;
    }
}
