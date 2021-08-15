/*
 * Copyright (c) 2021, Velocity Bytes.
 * @author: Srivastava Bodakunti
 * Date: 16/07/21, 10:05 AM
 * Website: https://velocitybytes.com
 *
 * Section: Arrays
 * Problem: Two Number Sum
 */

package com.velocitybytes.array;

import java.util.HashSet;
import java.util.Set;

/**
 * ***** Two Number Sum *****
 * Problem Statement:
 * Write a method that takes in a non-empty array of distinct integers
 * and an integer representing a target sum. If any two numbers in the
 * input array sum up to the target sum, the method should return them
 * in an array, in any order. If no two numbers sum up to the target sum,
 * the method should return an empty array.
 *
 * Note that the target sum has to be obtained by summing two different
 * integers in the array; you can't add a single integer to itself in
 * order to obtain the target sum.
 *
 * You can assume that there will be at most one pair of numbers summing
 * up to the target sum.
 *
 * Sample Input:
 * array = [3, 5, -4, 8, 11, 1, -1, 6], targetSum = 10
 *
 * Sample Output:
 * [11, -1] // the numbers could be in reverse order
 */
public class TwoNumberSum {

    /**
     * Two number sum:
     * Realize that for every number x in the input array, you are essentially
     * trying to find a corresponding number y such that x + y = targetSum.
     *
     * Time Complexity: O(n), where n is length of an array.
     * Space Complexity: O(n), where n is length of an array.
     *
     * @param array non-empty array of distinct integers
     * @param targetSum integer representing a target sum
     * @return array of two numbers representing target sum
     */
    public int[] twoNumSum(int[] array, int targetSum) {
        Set<Integer> nums = new HashSet<>();

        for (int num: array) {
            int complement = targetSum - num;

            if (nums.contains(complement)) {
                return new int[]{complement, num};
            } else {
                nums.add(num);
            }
        }
        return new int[0];
    }

    /**
     * Two number sum:
     * Naive approach:
     * Use two nested for loops and check if the sum of any two elements
     * in the array is equal to the given target
     *
     * Time Complexity: O(n^2), where n is length of an array.
     * Space Complexity: O(1)
     *
     * @param array non-empty array of distinct integers
     * @param targetSum targetSum integer representing a target sum
     * @return array of two numbers representing target sum
     */
    public int[] twoNumberSum(int[] array, int targetSum) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if ((array[i] + array[j]) == targetSum) {
                    return new int[]{array[i], array[j]};
                }
            }
        }
        return new int[0];
    }
}
