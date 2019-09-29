package com.coderbyte;

import java.util.HashSet;
import java.util.Set;

public class SeatingStudents {

    public static int SeatingStudents(int[] arr) {
        final int totalDesks = arr[0];
        final Set<Integer> occupiedDesks = new HashSet<>();
        for (int i = 1; i < arr.length; i++) {
            occupiedDesks.add(arr[i]);
        }

        System.out.println("totalDesks: " + totalDesks);
        System.out.println("occupiedDesks: " + occupiedDesks);

        int count = 0;
        for (int currentDesk = 1; currentDesk < totalDesks; currentDesk++) {
            if (isOccupied(currentDesk, occupiedDesks, totalDesks)) {
                continue;
            }
            if (currentDesk % 2 != 0) {
                final int sideDesk = currentDesk + 1;
                if (!isOccupied(sideDesk, occupiedDesks, totalDesks)) {
                    count++;
                }
            }
            final int belowDesk = currentDesk + 2;
            if (!isOccupied(belowDesk, occupiedDesks, totalDesks)) {
                count++;
            }
        }

        return count;
    }

    private static boolean isOccupied(final int desk, final Set<Integer> occupiedDesks, final int totalDesks) {
        return desk > totalDesks || occupiedDesks.contains(desk);
    }

}
