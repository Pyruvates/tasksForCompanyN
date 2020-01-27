package ru.koshkarovvitaliy;
/*
 * Created by Koshkarov Vitaliy on 27.01.2020
 */

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;

import java.util.*;

public class FrequencySorterTest {
    private FrequencySorter frequencySorter;

    @Test
    @BeforeEach
    void init() {
        frequencySorter = new FrequencySorter();
    }

    @Test
    void whenArrayIsNull() {
        List<Map.Entry<Integer, Integer>> map = frequencySorter.sortByFrequency(null);

        Assertions.assertEquals(Collections.EMPTY_LIST, map);
    }

    @Test
    void whenArrayIsEmpty() {
        int[] arr = new int[0];
        List<Map.Entry<Integer, Integer>> map = frequencySorter.sortByFrequency(arr);

        Assertions.assertEquals(Collections.EMPTY_LIST, map);
    }

    @Test
    void whenArrayHasOnlyOneElement() {
        int[] arr = {Integer.MAX_VALUE};
        List<Map.Entry<Integer, Integer>> expectedMap = new ArrayList<>();
        expectedMap.add(Map.entry(2147483647, 1));

        List<Map.Entry<Integer, Integer>> foundMap = frequencySorter.sortByFrequency(arr);

        Assertions.assertEquals(expectedMap, foundMap);
    }

    @Test
    void whenArrayHasSetOfElements() {
        int[] arr = {-1, 1, 0, -1, 0, 0};
        List<Map.Entry<Integer, Integer>> expectedMap = new ArrayList<>();
        expectedMap.add(Map.entry(1, 1));
        expectedMap.add(Map.entry(-1, 2));
        expectedMap.add(Map.entry(0, 3));

        List<Map.Entry<Integer, Integer>> foundMap = frequencySorter.sortByFrequency(arr);

        Assertions.assertEquals(expectedMap, foundMap);
    }

    @Test
    void whenArrayHasOnlyUniqueElements() {
        int[] arr = {-1, 0, 1};
        List<Map.Entry<Integer, Integer>> expectedMap = new ArrayList<>();
        expectedMap.add(Map.entry(-1, 1));
        expectedMap.add(Map.entry(0, 1));
        expectedMap.add(Map.entry(1, 1));

        List<Map.Entry<Integer, Integer>> foundMap = frequencySorter.sortByFrequency(arr);

        Assertions.assertEquals(expectedMap, foundMap);
    }
}
