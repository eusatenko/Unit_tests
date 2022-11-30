package com.example;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnimalParameterizedTest {
    private final String animalKind;
    private final List<String> food;



    public AnimalParameterizedTest(String animalKind, List<String> food) {
        this.animalKind = animalKind;
        this.food = food;
    }

    @Parameterized.Parameters (name = "Тип животного: {0}, Что ест: {1}")
    public static Object[][] getCredentials() {
        return new Object[][] {
                { "Травоядное", List.of("Трава", "Различные растения")},
                { "Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }

    @Test
    public void testGetFood() throws Exception {
        Animal animal = new Animal();

        assertEquals(food, animal.getFood(animalKind));
    }
}
