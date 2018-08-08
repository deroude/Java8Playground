package com.computaris.techtalks.streams;

import com.computaris.techtalks.logic.ListReducer;

import java.util.List;

public class StreamMaxProcessor implements ListReducer<Integer> {
    @Override
    public Integer process(List<Integer> input) {
        return input.stream().parallel()
                .reduce((prev,curr)->curr>prev?curr:prev)
                .orElse(null);
    }
}
