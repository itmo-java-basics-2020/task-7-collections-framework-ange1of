package ru.ifmo.collections;

import java.util.*;

/**
 * Design a class to find the kth largest element in a stream. k is from 1 to numbers.length.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Constructor accepts an integer k and an integer array numbers, which contains initial elements from the stream.
 * For each call to the method KthLargest.add(), return the element representing the kth largest element in the stream.
 */
public class KthLargest {

    private final int K;
    private final TreeMap<Integer, Integer> sortedElements = new TreeMap<>(Collections.reverseOrder());

    public KthLargest(int k, int[] numbers) {
        K = k;
        for (int element: numbers) {
            addToMap(element);
        }
    }

    public int add(int val) {
        addToMap(val);

        int maxNumber = 0;
        for (Map.Entry<Integer, Integer> pair : sortedElements.entrySet()) {
            maxNumber += pair.getValue();
            if (maxNumber >= K) {
                return pair.getKey();
            }
        }
        return -1;
    }

    private void addToMap(int val) {
        Integer existingElement = sortedElements.getOrDefault(val, null);
        if (existingElement == null) {
            sortedElements.put(val, 1);
        }
        else {
            sortedElements.put(val, ++existingElement);
        }
    }
}