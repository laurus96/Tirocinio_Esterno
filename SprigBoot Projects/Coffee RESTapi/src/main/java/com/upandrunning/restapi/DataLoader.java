package com.upandrunning.restapi;

import com.upandrunning.restapi.Entity.Coffee;
import com.upandrunning.restapi.Repository.CoffeeRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

import java.util.List;

@Component
public class DataLoader {
    private final CoffeeRepository coffeeRepository;

    public DataLoader(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @PostConstruct
    private void loadData(){
        coffeeRepository.saveAll(List.of(
                new Coffee("Café Cereza"),
                new Coffee("Café Ganador "),
                new Coffee("Café Lareno"),
                new Coffee("Café Très Pontas")
        ));
    }
}
