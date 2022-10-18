package com.example.demo.veterinarian;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, UUID> {

}
