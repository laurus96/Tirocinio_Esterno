package com.upandrunning.restapi.Service;

import com.upandrunning.restapi.Entity.Coffee;
import com.upandrunning.restapi.Repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CoffeeService {

    @Autowired
    private CoffeeRepository coffeeRepository;

    public Iterable<Coffee> getCoffees(){
        return coffeeRepository.findAll();
    }

    public Optional<Coffee> getCoffee(Long id){
        return coffeeRepository.findById(id);
    }

    public Coffee addCoffee(Coffee coffee){
        coffeeRepository.save(coffee);
        return coffee;
    }

    public ResponseEntity<Coffee> putCoffee(Long id, Coffee coffee){
        return  (coffeeRepository.existsById(id))
                    ? new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.OK)
                    : new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.CREATED);
    }

    public void deleteCoffee(Long id){
        coffeeRepository.deleteById(id);
    }

}
