package com.upandrunning.restapi.Repository;

import com.upandrunning.restapi.Entity.Coffee;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends CrudRepository<Coffee, Long> {
}
