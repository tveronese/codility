package com.codility.lessons.l07.stonewall;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(int[] H) {
        Deque<Integer> stack = new ArrayDeque<>();
        int count = 1;

        stack.push(H[0]);

        for (int i = 1; i < H.length; i++) {
            final int current = H[i];

            if (stack.isEmpty()) {
                stack.push(current);
                count++;
            }
            if (current > stack.peek()) {
                stack.push(current);
                count++;
            }
            while (current < stack.peek()) {
                stack.pop();
                if (stack.isEmpty() || current > stack.peek()) {
                    stack.push(current);
                    count++;
                }
            }
        }
        return count;
    }
}
