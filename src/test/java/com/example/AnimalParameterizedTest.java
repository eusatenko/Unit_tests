package com.example;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnimalParameterizedTest {
    private final String animalKind;
    private final String expected;


    public AnimalParameterizedTest(String animalKind, String expected) {
        this.animalKind = animalKind;
        this.expected = expected;
    }

    @Parameterized.Parameters (name = "Тип животного: {0}, Что ест: {1}")
    public static Object[][] getCredentials() {
        return new Object[][] {
                { "Травоядное", "Трава, Различные растения"},
                { "Хищник", "Животные, Птицы, Рыба"},
        };
    }

    @Test
    public void testGetFood() throws Exception {
        Animal animal = new Animal();
        assertEquals(expected, String.join(", ", animal.getFood(animalKind)));
    }
}
