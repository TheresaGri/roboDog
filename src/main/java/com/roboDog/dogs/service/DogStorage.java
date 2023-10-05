package com.roboDog.dogs.service;

import com.roboDog.dogs.data.Breed;
import com.roboDog.dogs.model.Dog;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DogStorage {
    //orderedCollection
    private List<Dog> dogList;
    private DogCreator dogCreator;

    public DogStorage(DogCreator dogCreator) {
        this.dogCreator = dogCreator;
        this.dogList = new ArrayList<>();
    }

    //dog can be added to the collection.
    public Dog addDog(Dog dog) {
        dogList.add(dog);
        return dog;
    }

    //A randomly generated dog can be added to the collection.
    public Dog addRandomlyGeneratedDog() {
        Dog randomDog = dogCreator.createRandomDog();
        dogList.add(randomDog);
        return randomDog;

    }
    //The collection of all dogs can be returned.

    public List<Dog> getDogList() {
        return dogList;
    }

    //The first dog with a given name can have its age and breed properties updated.
    public Dog updateDogByName(String name, int age, Breed breed) {
        Optional<Dog> optionalDog = dogList.stream()
                .filter(dog -> dog.getName().equals(name))
                .findFirst();
        if (optionalDog.isPresent()) {
            Dog firstDogWithName = optionalDog.get();
            firstDogWithName.setAge(age);
            firstDogWithName.setBreed(breed);
            return firstDogWithName;
        } else {
            // Handle the case where no dog with the specified name is found
            return null;
        }
    }

}
