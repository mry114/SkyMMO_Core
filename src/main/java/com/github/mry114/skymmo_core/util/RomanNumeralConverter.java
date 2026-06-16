package com.github.mry114.skymmo_core.util;

public class RomanNumeralConverter {
    private static final int[] NUMBERS = {
            900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
    };
    private static final String[] ROMAN_SYMBOLS = {
            "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
    };

    public static String toRoman(int num) {
        if (num <= 0 || num > 999) {
            throw new IllegalArgumentException("1から999の範囲で指定してください。");
        }

        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < NUMBERS.length; i++) {
            while (num >= NUMBERS[i]) {
                roman.append(ROMAN_SYMBOLS[i]);
                num -= NUMBERS[i];
            }
        }
        return roman.toString();
    }
}
