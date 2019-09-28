package com.codility.lessons.l07.brackets;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;


public class Solution {

    private static final Map<Character, Character> BRACKETS = new HashMap<Character, Character>() {{
        put('[', ']');
        put('{', '}');
        put('(', ')');
    }};

    public int solution(String S) {
        if (S.isEmpty()) {
            return 1;
        }
        if (S.length() % 2 != 0) {
            return 0;
        }

        final Deque<Character> stack = new LinkedList<>();
        for (char current : S.toCharArray()) {
            final Character closer = BRACKETS.get(current);
            final boolean open = closer != null;
            if (open) {
                stack.push(current);
                continue;
            }

            if (stack.isEmpty()) {
                return 0;
            }

            final char pop = stack.pop();
            final Character popCloser = BRACKETS.get(pop);
            if (!Objects.equals(popCloser, current)) {
                return 0;
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}