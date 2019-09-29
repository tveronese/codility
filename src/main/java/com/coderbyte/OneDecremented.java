package com.coderbyte;

public class OneDecremented {

    public static int OneDecremented(String str) {
        final char[] charArray = str.toCharArray();
        int previous = Character.getNumericValue(charArray[0]);
        int count = 0;
        for (int i = 1; i < charArray.length; i++) {
            final char c = charArray[i];
            final int current = Character.getNumericValue(c);
            if (previous - current == 1) {
                count++;
            }
            previous = current;
        }

        return count;
    }

}
