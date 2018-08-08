package com.computaris.techtalks.logic;

public interface ItemProcessor<T> {
    T process(T item);
}
