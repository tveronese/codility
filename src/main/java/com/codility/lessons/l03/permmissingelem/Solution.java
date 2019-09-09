package com.codility.lessons.l03.permmissingelem;

public class Solution {

    public int solution(int[] A) {
        // write your code in Java SE 8
        final long biggestNumber = (long) A.length + 1;
        final long maxPossibleSum = (biggestNumber * (biggestNumber + 1)) / 2;
        long sum = 0;
        for (int i : A) {
            sum += i;
        }
        final long l = maxPossibleSum - sum;
        return (int) l;
    }

}
