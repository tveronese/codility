package com.codility.lessons.l03.frogjump;

public class Solution {
    public int solution(int X, int Y, int D) {
        // write your code in Java SE 8
        final int initial = X;
        final int target = Y;
        final int jumpDistance = D;

        final int totalDistance = target - initial;

        return (int) Math.ceil((double) totalDistance / jumpDistance);
    }
}
