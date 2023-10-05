package com.roboDog.dogs.service;

import com.roboDog.dogs.data.Breed;
import com.roboDog.dogs.model.Dog;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class DogCreator {
    private Random random = new Random();
    private final int MIN_AGE_OF_DOG = 10;
    private final int MAX_AGE_OF_DOG = 20;
    private final List<String> dogNames = List.of("Bruno", "Benno", "Mickey", "Elisa");

    public Dog createRandomDog() {
        int randomAge = random.nextInt(MAX_AGE_OF_DOG - MIN_AGE_OF_DOG) + MIN_AGE_OF_DOG;
        int randomIndexDogName = random.nextInt(dogNames.size());
        String randomDogName = dogNames.get(randomIndexDogName);
        int randomIndexBreed = random.nextInt(Breed.values().length);
        Breed randomBreed = Breed.values()[randomIndexBreed];
        return new Dog(randomAge, randomDogName, randomBreed);
    }
}
