/*
 * Copyright (c) 2021, Velocity Bytes
 * @author: Srivastava Bodakunti
 * Date: 17/07/21, 9:26 AM
 * Website: https://velocitybytes.com
 *
 * Section: Arrays
 * Problem: Product Array
 */

package com.velocitybytes.array;

/**
 * ***** Product Array ****
 * Problem Statement:
 * Write a method that takes in a non-empty array of integers
 * and returns an array of same length, where each element in
 * the output array is equal to the product of every other
 * number in the input array.
 *
 * In other words, the value of output[i] is equal to the
 * product of every number in the input array other than input[i]
 *
 * Note that you're expected to solve this problem without using
 * division
 *
 * Sample Input:
 * array = [5, 1, 4, 2]
 *
 * Sample Output:
 * [8, 40, 10, 20]
 */
public class ProductArray {

    /**
     * For each index in the input array, try calculating the product
     * of every element to the left and the product of every element
     * to the right.
     * @param array non-empty array of integers
     * @return product array
     */
    public int[] arrayOfProducts(int[] array) {
        int[] products = new int[array.length];

        int leftRunningProduct = 1;
        for (int i = 0; i < array.length; i++) {
            products[i] = leftRunningProduct;
            leftRunningProduct *= array[i];
        }

        int rightRunningProduct = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            products[i] *= rightRunningProduct;
            rightRunningProduct *= array[i];
        }

        return products;
    }

    public int[] productArray(int[] array) {
        int[] products = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int runningProduct = 1;
            for (int j = 0; j < array.length; j++) {
                if (i != j) {
                    runningProduct *= array[j];
                }
                products[i] = runningProduct;
            }
        }

        return products;
    }
}
