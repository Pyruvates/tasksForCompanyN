package ru.koshkarovvitaliy;
/*
 * Created by Koshkarov Vitaliy on 27.01.2020
 */

import java.util.*;
import java.util.stream.Collectors;

public class FrequencySorter {
    public static void main(String[] args) {
        int[] numbers = {1, -2, 16, 34, 7, -3, 0, 12, -2, 34, 17, 1, 7, 1, 1, 4};

        List<Map.Entry<Integer, Integer>> list = new FrequencySorter().sortByFrequency(numbers);

        System.out.println(list);
    }

    public List<Map.Entry<Integer, Integer>> sortByFrequency(int[] arr) {
        return toList(frequency(arr));
    }

    private Map<Integer, Integer> frequency(int[] array) {
        if (array != null) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int elem : array) {
                map.put(elem, map.containsKey(elem) ? map.get(elem) + 1 : 1);
            }
            return map;
        }
        return Collections.emptyMap();
    }

    private List<Map.Entry<Integer, Integer>> toList(Map<Integer, Integer> map) {
        return map.entrySet()
            .stream()
            .sorted(Map.Entry.<Integer, Integer> comparingByValue())
            .collect(Collectors.toList());
    }
}
