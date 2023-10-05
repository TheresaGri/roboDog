package com.roboDog.dogs.controller;

import com.roboDog.dogs.data.Breed;
import com.roboDog.dogs.model.Dog;
import com.roboDog.dogs.service.DogStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("dogs")
public class DogController {
    private final DogStorage dogStorage;

    @Autowired
    public DogController(DogStorage dogStorage) {
        this.dogStorage = dogStorage;
    }
    //The controller has a GET endpoint for returning all stored dogs.

    @RequestMapping("")
    public List<Dog> getDogs() {
        return dogStorage.getDogList();
    }

    //The controller has a GET endpoint for returning a randomly created dog, which is stored by DogStorage.
    @RequestMapping("random")
    public Dog getRandomlyGeneratedDog() {
        return dogStorage.addRandomlyGeneratedDog();
    }

    //The controller has a POST endpoint for adding a new dog. The dog's data is kept in the request body.
    @PostMapping
    Dog save(@RequestBody Dog dog) {
        return dogStorage.addDog(dog);
    }

    //The controller has a PUT endpoint for updating the first dog with a given name. The name is provided in the path variable. Age and breed properties can be updated in the request body.
    //http://localhost:8080/dogs/SomeName?age=3&breed=LABRADOR
    @PutMapping("/{name}")
    ResponseEntity<Dog> updateFirstDogByName(@PathVariable String name, @RequestParam int age, @RequestParam Breed breed) {
        Dog updatedDog = dogStorage.updateDogByName(name, age, breed);
        if (updatedDog != null) {
            ResponseEntity.ok(updatedDog);
        } else {
            return ResponseEntity.notFound().build();
        }
        return null;
    }


}

