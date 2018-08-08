package com.computaris.techtalks;

import com.computaris.techtalks.logic.ItemProcessor;
import com.computaris.techtalks.logic.ListGenerator;

import java.util.List;

public class Constants {
    private static final int STRING_COUNT=1000000,INT_COUNT=10000000;
    public static final List<String> STRING_INPUT= ListGenerator.generateStrings("abcdefghijklmnopqrstuvxyz", 10, 10, STRING_COUNT);
    public static final List<Integer> INT_INPUT = ListGenerator.generateIntegers(Integer.MIN_VALUE, Integer.MAX_VALUE, INT_COUNT);
    public static final ItemProcessor<String> STRING_PROCESSOR = item -> (item.substring(0, 1).toUpperCase() + item.substring(1)).replaceAll("ab", "c");


}
