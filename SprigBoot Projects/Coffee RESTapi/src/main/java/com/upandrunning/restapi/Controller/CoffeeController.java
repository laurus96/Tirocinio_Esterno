package com.upandrunning.restapi.Controller;

import com.upandrunning.restapi.Entity.Coffee;
import com.upandrunning.restapi.Service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("/api/coffees")
@Slf4j
public class CoffeeController {

    @Autowired
    private CoffeeService coffeeService;

    @GetMapping
    Iterable<Coffee> getCoffees(){
        log.info("Coffeee retrived");
        return coffeeService.getCoffees();
    }

    @GetMapping("/{id}")
    Optional<Coffee> getCoffee(@PathVariable Long id){
        return coffeeService.getCoffee(id);
    }

    @PostMapping()
    Coffee addCoffee(@RequestBody Coffee coffee){
        return coffeeService.addCoffee(coffee);
    }

    @PutMapping("/{id}")
    ResponseEntity<Coffee> putCoffee(@PathVariable Long id, @RequestBody Coffee coffee){
        return coffeeService.putCoffee(id, coffee);
    }

    @DeleteMapping("/{id}")
    void deleteCoffee(@PathVariable Long id){
        coffeeService.deleteCoffee(id);
    }

}
