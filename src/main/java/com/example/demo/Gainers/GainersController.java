package com.example.demo.Gainers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/gainers")
@AllArgsConstructor
public class GainersController {

    private final GainersService gainersService;

    @GetMapping(path = "/all")
    public List<Gainers> getAllGainers(){
        return gainersService.getAllGainers();
    }

    @GetMapping(path = "/{gainersSymbol}")
    public List<Gainers> getGainers(@PathVariable("gainersSymbol") String currencySymbol){
        return gainersService.getGainers(currencySymbol);
    }
    @GetMapping(path = "/{gainersSymbol}/price")
    public String getGainerPrice(@PathVariable("gainersSymbol") String gainersSymbol){
        return getGainers(gainersSymbol).get(0).getPrice();
    }
}
