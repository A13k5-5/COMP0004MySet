package uk.ac.ucl;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListMySet<T extends Comparable<T>> extends AbstractMySet<T>{
    private LinkedList<T> contents;
    private int maximumSize;
    public LinkedListMySet() throws MySetException {
        this(MAX_SIZE);
    }

    public LinkedListMySet(int maximumSize) throws MySetException {
        super.checkSize(maximumSize);
        System.out.println("Working on it");
    }

    private void initialiseToEmpty(int maximumSize) {
        this.maximumSize = maximumSize;
        contents = new LinkedList<>();
    }

    @Override
    public int size() {
        return this.contents.size();
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    private void checkForSpace() throws MySetException{
        if (this.size() < this.maximumSize)
            return;
        throw(new MySetException("Attempting to add to a full set"));
    }

    @Override
    public void add(T value) throws MySetException {
        if (this.contains(value))
            return;
        checkForSpace();
        this.contents.add((T) value);
    }

    @Override
    public boolean contains(T value) {
        for (T curVal : this.contents) {
            if (curVal.compareTo(value) == 0)
                return true;
        }
        return false;
    }

    @Override
    public void remove(T value) {
        this.contents.remove(value);
    }

    @Override
    public Iterator iterator() {
        return this.contents.iterator();
    }
}
