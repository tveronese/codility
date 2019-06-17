package com.codility.lessons.l02.cyclicrotation;

class Solution {
    public int[] solution(int[] A, int K) {
        if (A.length == 0) {
            return A;
        }

        final int rotations = K % A.length;
        if (rotations == 0) {
            return A;
        }

        int[] res = new int[A.length];

        for (int index = 0; index < A.length; index++) {
            final int newIndex = (index + rotations) % res.length;
            res[newIndex] = A[index];
        }
        return res;
    }
}