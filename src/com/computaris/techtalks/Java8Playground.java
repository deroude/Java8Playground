package com.computaris.techtalks;

import com.computaris.techtalks.logic.ItemProcessor;
import com.computaris.techtalks.logic.ListGenerator;
import com.computaris.techtalks.logic.ListMapper;
import com.computaris.techtalks.logic.ListReducer;
import com.computaris.techtalks.nostreams.NoStreamCapitalizeProcessor;
import com.computaris.techtalks.nostreams.NoStreamMaxProcessor;
import com.computaris.techtalks.streams.StreamCapitalizeProcessor;
import com.computaris.techtalks.streams.StreamMaxProcessor;

import java.util.List;

public class Java8Playground {

    private static final Integer count = 1000000;

    public static void main(String[] args) {
        final List<String> stringInput = ListGenerator.generateStrings("abcdefghijklmnopqrstuvxyz", 5, 10, count);
        final ItemProcessor<String> processor = item -> (item.substring(0, 1).toUpperCase() + item.substring(1)).replaceAll("ab","c");
        //This is the no stream implementation
        System.out.println("No Stream mapper: \n\n");
        final ListMapper noStreamMapper = new NoStreamCapitalizeProcessor(processor);
        final List<String> afterNoStreamMap = processAndBenchmarkMapper(noStreamMapper, stringInput);
        //No stream implementation ends

        //This is the stream implementation
        System.out.println("Stream mapper: \n\n");
        final ListMapper streamMapper = new StreamCapitalizeProcessor(processor);
        final List<String> afterStreamMap = processAndBenchmarkMapper(streamMapper, stringInput);
        //Stream implementation ends

        assert afterNoStreamMap.size() == afterStreamMap.size();

        final List<Integer> intInput = ListGenerator.generateIntegers(Integer.MIN_VALUE, Integer.MAX_VALUE, count);

        //This is the no stream implementation
        System.out.println("No Stream reducer: \n\n");
        final ListReducer<Integer> noStreamReducer = new NoStreamMaxProcessor();
        final int afterNoStreamReduce = processAndBenchmarkReducer(noStreamReducer, intInput);
        //No stream implementation ends

        //This is the stream implementation
        System.out.println("Stream reducer: \n\n");
        final ListReducer<Integer> streamReducer = new StreamMaxProcessor();
        final int afterStreamReduce = processAndBenchmarkReducer(streamReducer, intInput);
        //Stream implementation ends

        assert afterNoStreamReduce == afterStreamReduce;
    }

    private static <T> List<T> processAndBenchmarkMapper(final ListMapper<T> listProcessor, final List<T> items) {
        long t = System.currentTimeMillis();
        final List<T> re = listProcessor.process(items);
        System.out.println("" + (System.currentTimeMillis() - t) + " ms\n\n");
        return re;
    }

    private static <T> T processAndBenchmarkReducer(final ListReducer<T> listProcessor, final List<T> items) {
        long t = System.currentTimeMillis();
        T re = listProcessor.process(items);
        System.out.println("" + (System.currentTimeMillis() - t) + " ms\n\n");
        return re;
    }
}