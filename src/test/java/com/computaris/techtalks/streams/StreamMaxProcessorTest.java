package com.computaris.techtalks.streams;

import com.carrotsearch.junitbenchmarks.AbstractBenchmark;
import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.computaris.techtalks.Constants;
import com.computaris.techtalks.logic.ListReducer;
import org.junit.Test;

public class StreamMaxProcessorTest extends AbstractBenchmark {

    final ListReducer<Integer> reducer = new StreamMaxProcessor();

    @BenchmarkOptions(benchmarkRounds = 20,warmupRounds = 2)
    @Test
    public void test(){
        reducer.process(Constants.INT_INPUT);
    }
}
