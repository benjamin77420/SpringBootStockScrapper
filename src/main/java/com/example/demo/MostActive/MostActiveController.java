package com.example.demo.MostActive;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/mostActive")
@AllArgsConstructor
public class MostActiveController {
    private final MostActiveService mostActiveService;

    @GetMapping(path = "/all")
    public List<MostActive> getAllCurrencies(){
        return mostActiveService.getAllMostActive();
    }

    @GetMapping(path = "/{mostActiveSymbol}")
    public List<MostActive> getMostActive(@PathVariable("mostActiveSymbol") String mostActiveSymbol){
        return mostActiveService.getMostActive(mostActiveSymbol);
    }
    @GetMapping(path = "/{mostActiveSymbol}/price")
    public String getMostActivePrice(@PathVariable("mostActiveSymbol") String mostActiveSymbol){
        return getMostActive(mostActiveSymbol).get(0).getPrice();
    }
}
