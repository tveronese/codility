package com.codility.lessons.l03.tapeequilibrium;

public class Solution {
    public int solution(final int[] A) {
        long min = Long.MAX_VALUE;
        long leftSum = A[0];
        long rightSum = sum(A) - leftSum;
        for (int i = 1; i < A.length; i++) {
            final int current = A[i];
            final long diff = Math.abs(leftSum - rightSum);
            min = Math.min(min, diff);
            leftSum += current;
            rightSum -= current;
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
