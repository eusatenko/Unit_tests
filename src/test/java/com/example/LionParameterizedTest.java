package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {
    private final String sex;
    private final boolean havMane;

    Feline feline = new Feline();

    public LionParameterizedTest(String sex, boolean havMane) {
        this.sex = sex;
        this.havMane = havMane;
    }

    @Parameterized.Parameters (name = "Пол: {0}, Грива есть: {1}")
    public static Object[][] getCredentials() {
        return new Object[][] {
                { "Самец", true},
                { "Самка", false},
        };
    }
    @Test
    public void testDoesHaveMane() throws Exception {
        Lion lion = new Lion(sex, feline);
        assertEquals(havMane, lion.doesHaveMane());
    }
}
