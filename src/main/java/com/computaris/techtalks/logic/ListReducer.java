package com.computaris.techtalks.logic;

import java.util.List;

public interface ListReducer <T>{
    T process (List<T> input);
}
