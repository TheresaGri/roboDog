package com.roboDog.dogs.model;

import com.roboDog.dogs.data.Breed;
import java.util.UUID;

public class Dog {

    private String id;
    private int age;
    private String name;
    private Breed breed;

    public Dog(int age, String name, Breed breed) {
        this.id = UUID.randomUUID().toString();
        this.age = age;
        this.name = name;
        this.breed = breed;
    }




    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
