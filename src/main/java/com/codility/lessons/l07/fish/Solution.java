package com.codility.lessons.l07.fish;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    private static final int DOWNSTREAM = 1;

    public int solution(int[] A, int[] B) {
        final Deque<Integer> downnstreamFishes = new ArrayDeque<>();

        int survivingFish = A.length;

        for (int i = 0; i < A.length; i++) {
            final int weight = A[i];
            final int direction = B[i];
            if (direction == DOWNSTREAM) {
                downnstreamFishes.push(weight);
                continue;
            }

            final Integer upstreamFish = weight;
            while (!downnstreamFishes.isEmpty()) {
                final Integer downstreamFish = downnstreamFishes.peek();
                survivingFish--;
                if (downstreamFish > upstreamFish) {
                    break;
                }
                downnstreamFishes.pop();
            }
        }
        return survivingFish;
    }
}
