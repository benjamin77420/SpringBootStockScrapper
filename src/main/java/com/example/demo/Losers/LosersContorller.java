package com.example.demo.Losers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/losers")
@AllArgsConstructor
public class LosersContorller {
    private final LosersService LosersService;

    @GetMapping(path = "/all")
    public List<Losers> getAllCurrencies(){
        return LosersService.getAllLosers();
    }

    @GetMapping(path = "/{losersSymbol}")
    public List<Losers> getCurrency(@PathVariable("losersSymbol") String losersSymbol){
        return LosersService.getLosers(losersSymbol);
    }
    @GetMapping(path = "/{losersSymbol}/price")
    public String getCurrencyPrice(@PathVariable("losersSymbol") String losersSymbol){
        return getCurrency(losersSymbol).get(0).getPrice();
    }
}
