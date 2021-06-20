package com.example.demo.Currencies;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/currencies")
@AllArgsConstructor
public class CurrenciesController {

    private final CurrenciesService currenciesService;

    @GetMapping(path = "/all")
    public List<Currencies> getAllCurrencies(){
        return currenciesService.getAllCurrency();
    }

    @GetMapping(path = "/{currencySymbol}")
    public List<Currencies> getCurrency(@PathVariable("currencySymbol") String currencySymbol){
        return currenciesService.getCurrency(currencySymbol);
    }
    @GetMapping(path = "/{currencySymbol}/price")
    public String getCurrencyPrice(@PathVariable("currencySymbol") String currencySymbol){
        return getCurrency(currencySymbol).get(0).getPrice();
    }
}
