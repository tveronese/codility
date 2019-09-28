package com.codility.lessons.l07.nesting;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public int solution(String S) {
        if (S.isEmpty()) {
            return 1;
        }
        if (S.length() % 2 != 0) {
            return 0;
        }

        final Deque<Character> stack = new LinkedList<>();
        for (char current : S.toCharArray()) {
            if (current == '(') {
                stack.push(current);
                continue;
            }

            if (stack.isEmpty()) {
                return 0;
            }

            stack.pop();
        }

        return stack.isEmpty() ? 1 : 0;
    }
}