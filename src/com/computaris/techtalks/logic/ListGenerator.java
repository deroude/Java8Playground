package com.computaris.techtalks.logic;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ListGenerator {
    public static List<String> generateStrings(String alphabet, int minWordSize, int maxWordSize, int count) {
        final Random r = new Random();
        final List<String> re = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            int n = r.nextInt(maxWordSize - minWordSize) + minWordSize;
            StringBuilder word = new StringBuilder();
            for (int j = 0; j < n; j++) {
                word.append(alphabet.charAt(r.nextInt(alphabet.length())));
            }
            re.add(word.toString());
        }
        return re;
    }

    public static List<Integer> generateIntegers(int min, int max, int count){
        return new Random().ints(count,min,max).boxed().collect(Collectors.toList());
    }
}
