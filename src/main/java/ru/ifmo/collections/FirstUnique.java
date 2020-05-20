package ru.ifmo.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * Design a class which contains integers and returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 */
public class FirstUnique {

    private final HashSet<Integer> allElements = new HashSet<>();
    private final LinkedHashSet<Integer> uniqueElements = new LinkedHashSet<>();

    public FirstUnique(int[] numbers) {
        for (int value: numbers ) {
            add(value);
        }
    }

    public int showFirstUnique() {
        return uniqueElements.isEmpty() ? -1 : uniqueElements.iterator().next();
    }

    public void add(int value) {
        if (!allElements.contains(value)) {
            allElements.add(value);
            uniqueElements.add(value);
        }
        else {
            uniqueElements.remove(value);
        }
    }
}
