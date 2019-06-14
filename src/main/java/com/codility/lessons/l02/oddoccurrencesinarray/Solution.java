package com.codility.lessons.l02.oddoccurrencesinarray;

import java.util.HashSet;
import java.util.Set;

class Solution {

    public int solution(int[] A) {
        final Set<Integer> notFound = new HashSet<>();
        for (int i : A) {
            if (notFound.contains(i)) {
                notFound.remove(i);
            } else {
                notFound.add(i);
            }
        }
        if (notFound.size() != 1) {
            throw new IllegalArgumentException("Array is not in expected format.");
        }
        return notFound.iterator().next();
    }

}