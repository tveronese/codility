package com.codility.lessons.l03.tapeequilibrium;

public class Solution {
    public int solution(final int[] A) {
        long leftSum = 0;
        long rightSum = sum(A);
        long min = Math.abs(leftSum - rightSum);

        for (final int current : A) {
            leftSum += current;
            rightSum -= current;

            final long diff = Math.abs(leftSum - rightSum);
            min = Math.min(min, diff);
        }

        return (int) min;
    }

    private long sum(final int[] array) {
        long sum = 0;
        for (final int value : array) {
            sum += value;
        }
        return sum;
    }
}
