package ru.koshkarovvitaliy;
/*
 * Created by Koshkarov Vitaliy on 27.01.2020
 */

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class LessBitChangerFromZeroToOneTest {

    @Test
    void whenLessBitIsZero() {
        int testNumber = 0;
        int expectedNumber = 1;
        int foundNumber = LessBitChangerFromZeroToOne.changeLessBitFromZeroToOne(testNumber);
        assertEquals(expectedNumber, foundNumber);
    }

    @Test
    void whenLessBitIsOne() {
        int testNumber = 1;
        int expectedNumber = 1;
        int foundNumber = LessBitChangerFromZeroToOne.changeLessBitFromZeroToOne(testNumber);
        assertEquals(expectedNumber,foundNumber);
    }

    @Test
    void whenNumberIsMaxInteger() {
        int testNumber = Integer.MAX_VALUE;
        int expectedNumber = Integer.MIN_VALUE - 1;
        int foundNumber = LessBitChangerFromZeroToOne.changeLessBitFromZeroToOne(testNumber);
        assertEquals(expectedNumber,foundNumber);
    }
}
