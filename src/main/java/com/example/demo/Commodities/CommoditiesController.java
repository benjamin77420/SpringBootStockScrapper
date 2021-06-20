package com.example.demo.Commodities;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/commodities")
@AllArgsConstructor
public class CommoditiesController {

    private final CommoditiesService commoditiesService;

    @GetMapping(path = "/all")
    public List<Commodities> getAllCommodities(){
        return commoditiesService.getAllCommodities();
    }

    @GetMapping(path = "/{commoditySymbol}")
    public List<Commodities> getCommodity(@PathVariable("commoditySymbol") String commoditySymbol){
        return commoditiesService.getCommodity(commoditySymbol);
    }

    @GetMapping(path = "/{commoditySymbol}/price")
    public String  getCommodityPrice(@PathVariable("commoditySymbol") String commoditySymbol){
        return getCommodity(commoditySymbol).get(0).getPrice();
    }
}
