package com.codility.lessons.l01.binarygap;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {

    public int solution(int N) {
        // write your code in Java SE 8
        int maxCount = 0;
        int currentCount = 0;
        boolean insideGap = false;
        final char[] chars = Integer.toBinaryString(N).toCharArray();
        for (final char current : chars) {
            switch (current) {
                case '1':
                    if (insideGap) {
                        maxCount = Math.max(currentCount, maxCount);
                        currentCount = 0;
                    } else {
                        insideGap = true;
                    }
                    break;
                case '0':
                    if (insideGap) currentCount++;
                    break;
                default:
                    insideGap = false;
                    break;
            }
        }
        return maxCount;
    }

}