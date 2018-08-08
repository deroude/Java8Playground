package com.computaris.techtalks.logic;

import java.util.List;

public interface ListMapper<T> {
    List<T> process(List<T> input);
}
