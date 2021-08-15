/*
 * Copyright (c) 2021, Velocity Bytes
 * @author: Srivastava Bodakunti
 * Date: 17/07/21, 11:41 AM
 * Website: https://velocitybytes.com
 */

package com.velocitybytes.utils;

public class Utils {

    public static short countBits(int x) {
        short numBits = 0;

        while (x != 0) {
            numBits += (x & 1);
            x >>= 1;
        }
        return numBits;
    }

    public static short parity(long x) {
        x ^= x >>> 32;
        x ^= x >>> 16;
        x ^= x >>> 8;
        x ^= x >>> 4;
        x ^= x >>> 2;
        x ^= x >>> 1;
        return (short) (x & 0x1);
    }

    public static boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static String intToString(int x) {
        boolean isNegative = x < 0;

        StringBuilder builder = new StringBuilder();

        do {
            builder.append((char) ('0' + Math.abs(x % 10)));
            x /= 10;
        } while (x != 0);

        if (isNegative) {
            builder.append("-");
        }
        builder.reverse();
        return builder.toString();
    }

    public static int stringToInt(String s) {
        int result = 0;

        for (int i = s.charAt(0) == '-' ? 1 : 0; i < s.length(); ++i) {
            final int digit = s.charAt(i) - '0';
            result = result * 10 + digit;
        }
        return s.charAt(0) == '-' ? -result : result;
    }

    public static String convertBase(String numAsString, int b1, int b2) {
        boolean isNegative = numAsString.startsWith("-");

        int numAsInt = 0;

        for (int i = (isNegative ? 1 : 0); i < numAsString.length(); ++i) {
            numAsInt *= b1;
            numAsInt += Character.isDigit(numAsString.charAt(i))
                    ? numAsString.charAt(i) - '0'
                    : numAsString.charAt(i) - 'A' + 10;
        }
        return (isNegative ? "-" : "") + (numAsInt == 0 ? "0" : constructFromBase(numAsInt, b2));
    }

    private static String constructFromBase(int numAsInt, int base) {
        return numAsInt == 0
                ? ""
                : constructFromBase(numAsInt / base, base)
                    + (char) (numAsInt % base >= 10 ? 'A' + numAsInt % base - 10
                                                    : '0' + numAsInt % base);
    }
}
