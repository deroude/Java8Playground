package com.computaris.techtalks.nostreams;

import com.carrotsearch.junitbenchmarks.AbstractBenchmark;
import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.computaris.techtalks.Constants;
import com.computaris.techtalks.logic.ListReducer;
import org.junit.Test;

public class NoStreamMaxProcessorTest extends AbstractBenchmark {

    final ListReducer<Integer> reducer = new NoStreamMaxProcessor();

    @BenchmarkOptions(benchmarkRounds = 20,warmupRounds = 2)
    @Test
    public void test(){
        reducer.process(Constants.INT_INPUT);
    }
}
