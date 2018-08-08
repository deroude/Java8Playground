package com.computaris.techtalks.nostreams;

import com.computaris.techtalks.logic.ListReducer;

import java.util.List;

public class NoStreamMaxProcessor implements ListReducer<Integer> {

    @Override
    public Integer process(List<Integer> input) {
        int max = Integer.MIN_VALUE;
        for (int i : input) {
            if (i > max) max = i;
        }
        return max;
    }
}
