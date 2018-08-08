package com.computaris.techtalks.streams;

import com.carrotsearch.junitbenchmarks.AbstractBenchmark;
import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.computaris.techtalks.Constants;
import com.computaris.techtalks.logic.ListMapper;
import org.junit.Test;

public class StreamCapitalizeProcessorTest extends AbstractBenchmark {

    private static final ListMapper streamMapper = new StreamCapitalizeProcessor(Constants.STRING_PROCESSOR);

    @BenchmarkOptions(benchmarkRounds = 20, warmupRounds=2)
    @Test
    public void test(){
        streamMapper.process(Constants.STRING_INPUT);
    }
}
