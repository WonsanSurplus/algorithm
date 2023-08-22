package com.example.BinarySearch;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Classname: BinarySearchBasic
 * @Description: TODO
 * @Date: 2023/8/21 021
 * @Author: zs
 */
public class BinarySearchBasic2 {
    /**
     *   |           |
     *   1 2 4 6 7 8
     */
    public int binarySearch(int[] arr, int target) {
        int i = 0, j = arr.length;
        while (i < j) {
            int mid = (i + j) >>> 1;
            if (arr[mid] < target) {
                i = mid + 1;
            } else if (target < arr[mid]) {
                j = mid;
            } else return mid;
        }

        return -1;

    }

    @Test
    @DisplayName("测试 binarySearchBasic")
    public void test1() {
        int[] arr = {1, 2, 4, 6, 7, 8, 9};
        assertEquals(0, binarySearch(arr, 1));
        assertEquals(1, binarySearch(arr, 2));
        assertEquals(2, binarySearch(arr, 4));
        assertEquals(3, binarySearch(arr, 6));
        assertEquals(4, binarySearch(arr, 7));
        assertEquals(5, binarySearch(arr, 8));
        assertEquals(6, binarySearch(arr, 9));
        assertEquals(-1, binarySearch(arr, 10));
    }
}
