package com.computaris.techtalks.streams;

import com.computaris.techtalks.logic.ItemProcessor;
import com.computaris.techtalks.logic.ListMapper;

import java.util.List;
import java.util.stream.Collectors;

public class StreamCapitalizeProcessor implements ListMapper<String> {

    final ItemProcessor<String> processor;

    public StreamCapitalizeProcessor(ItemProcessor<String> processor) {
        this.processor = processor;
    }

    @Override
    public List<String> process(List<String> input) {
        return input.stream().unordered().parallel()
                .map(i->processor.process(i))
                .collect(Collectors.toList());
    }
}
