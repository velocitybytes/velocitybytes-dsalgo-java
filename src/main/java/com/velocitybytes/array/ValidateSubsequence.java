/*
 * Copyright (c) 2021, Velocity Bytes
 * @author: Srivastava Bodakunti
 * Date: 15/08/21, 10:54 AM
 * Website: https://velocitybytes.com
 *
 * Section: Arrays
 * Problem: Validate Subsequence
 */

package com.velocitybytes.array;

import java.util.List;

/**
 * ***** Problem *****
 * Problem Statement
 * Given two non-empty arrays of integers, write a method that
 * determines whether the second array is a subsequence of the
 * first one.
 *
 * A subsequence of an array is a set of numbers that aren't
 * necessarily adjacent in the array but that are in the same
 * order as they appear in the array. For instance, the
 * numbers [1, 3, 4] form a subsequence of the array [1, 2, 3, 4],
 * and so do the numbers [2, 4]. Note that a single number in an
 * array and the array itself are both valid subsequences of the
 * array.
 *
 * Sample Input:
 * array = [5, 1, 22, 25, 6, -1, 8, 10]
 * sequence = [1, 6, -1, 10]
 *
 * Sample Output:
 * true
 */
public class ValidateSubsequence {

    /**
     * Method to check if a sequence is a valid subsequence of main array.
     * @param array non-empty array of integers
     * @param sequence potential subsequence
     * @return boolean value it is valid subsequence or not
     */
    public static boolean isValidSubsequence1(List<Integer> array, List<Integer> sequence) {
        int arrIdx = 0, seqIdx = 0;

        while (arrIdx < array.size() && seqIdx < sequence.size()) {
            if (array.get(arrIdx).equals(sequence.get(seqIdx))) {
                seqIdx++;
            }
            arrIdx++;
        }
        return seqIdx == sequence.size();
    }

    /**
     * Method to check if a sequence is a valid subsequence of main array.
     * @param array non-empty array of integers
     * @param sequence potential subsequence
     * @return boolean value it is valid subsequence or not
     */
    public static boolean isValidSubsequence2(List<Integer> array, List<Integer> sequence) {
        int seqIdx = 0;
        for (Integer num : array) {
            if (seqIdx == sequence.size()) {
                break;
            }
            if (sequence.get(seqIdx).equals(num)) {
                seqIdx++;
            }
        }
        return seqIdx == sequence.size();
    }
}
