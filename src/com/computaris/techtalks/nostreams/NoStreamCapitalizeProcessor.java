package com.computaris.techtalks.nostreams;

import com.computaris.techtalks.logic.ItemProcessor;
import com.computaris.techtalks.logic.ListMapper;

import java.util.LinkedList;
import java.util.List;

public class NoStreamCapitalizeProcessor implements ListMapper<String> {
    final ItemProcessor<String> processor;

    public NoStreamCapitalizeProcessor(ItemProcessor<String> processor) {
        this.processor = processor;
    }

    @Override
    public List<String> process(List<String> input) {
        List<String> re=new LinkedList<>();
        for(String i:input){
            re.add(processor.process(i));
        }
        return re;
    }
}
