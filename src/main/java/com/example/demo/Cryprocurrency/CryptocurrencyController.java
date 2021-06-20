package com.example.demo.Cryprocurrency;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/cryptocurrency")
@AllArgsConstructor
public class CryptocurrencyController {

    private final CryptocurrencyService cryptocurrencyService;

    @GetMapping(path = "/{coinSymbol}")
    public List<CryptoCoin> getCryptoCoin(@PathVariable("coinSymbol") String coinSymbol){
        return cryptocurrencyService.getStockBySymbol(coinSymbol);
    }

    @GetMapping(path = "/all")
    public List<CryptoCoin> getAllCryptoCoins(){
        return cryptocurrencyService.getAllCoins();
    }

    @GetMapping(path = "/{coinSymbol}/price")
    public String getCoinPrice(@PathVariable("coinSymbol") String coinSymbol){
        return getCryptoCoin(coinSymbol).get(0).getPrice();
    }
}
