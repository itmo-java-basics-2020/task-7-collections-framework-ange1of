package ru.ifmo.collections;

import java.util.*;

/**
 * Represents sorted set of unique values.
 * create() returns a SortedSet instance with natural ordering. (i.e. from smallest to largest in case of integer numbers)
 * from() is used to create a SortedSet instance with given Comparator.
 * Instances of a class can be created using only these two methods above.
 *
 * This class should not be abstract and should be capable of adding/removing single/multiple elements.
 * It has two more methods: getSorted() and getReversed() which return an array of set contents in forward and reverse order respectively.
 *
 * NB! This class must have only map(s) as an internal data structure(s).
 *
 * @param <T> set contents type
 */
public class SortedSet<T> extends AbstractSet<T> {
    private final TreeMap<T, Object> contents;

    public static <T> SortedSet<T> create() {
        return from(null);
    }

    public static <T> SortedSet<T> from(Comparator<T> comparator) {
        return new SortedSet<>(comparator);
    }

    private SortedSet(Comparator<T> comparator) {
        contents = new TreeMap<>(comparator);
    }

    public ArrayList<T> getSorted() {
        return new ArrayList<>(contents.keySet());
    }

    public ArrayList<T> getReversed() {
        return new ArrayList<>(contents.descendingKeySet());
    }

    @Override
    public boolean add(T element) {
        return contents.put(element, null) != null;
    }

    @Override
    public Iterator<T> iterator() {
        return contents.keySet().iterator();
    }

    @Override
    public int size() {
        return contents.size();
    }
}
