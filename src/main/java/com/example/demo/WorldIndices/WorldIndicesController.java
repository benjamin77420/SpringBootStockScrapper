package com.example.demo.WorldIndices;

import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "worldIndices")
@AllArgsConstructor
public class WorldIndicesController {
    private final WorldIndicesService worldIndicesService;

    @GetMapping(path = "/all")
    public List<WorldIndices> getAllWorldIndices(){
        return worldIndicesService.getAllWorldIndices();
    }

    @GetMapping(path = "{worldIndicesSymbol}")
    public List<WorldIndices> getWorldIndices(@PathVariable("worldIndicesSymbol") String worldIndicesSymbol){
        Query query = new Query();
        query.addCriteria(Criteria.where("symbol").is(worldIndicesSymbol));

        return worldIndicesService.getWorldIndices(worldIndicesSymbol);
    }

    @GetMapping(path ="{worldIndicesSymbol}/price")
    public String getworldIndicesPrice(@PathVariable("worldIndicesSymbol") String worldIndicesSymbol){
        return getWorldIndices(worldIndicesSymbol).get(0).getPrice();
    }
}
