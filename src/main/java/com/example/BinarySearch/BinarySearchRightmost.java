package com.example.BinarySearch;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

/**
 * @Classname: BinarySearchRightmost
 * @Description: 有重复时返回最右侧
 * @Date: 2023/8/22 022
 * @Author: zs
 */
@Slf4j
public class BinarySearchRightmost {
    public static int binarySearchRightmost1(int[] a, int target) {
        int i = 0, j = a.length - 1;
        int candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                candidate = m; // 记录候选位置
                i = m + 1;	   // 继续向右
            }
        }
        return candidate;
    }

    /**
     * 返回target在数组中出现的索引，或者应该插入的位置
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearchRightmost2(int[] arr, int target) {
        int i = 0, j = arr.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < arr[m]) {
                j = m - 1;
            } else{
                i = m + 1;
            }
        }
        return i;
    }

    @Test
    @DisplayName("测试 binarySearchRightmost2")
    public void test1() {
        int[] arr = {1, 2, 4, 4, 4, 6, 7, 8, 9};
        log.debug("4的索引:{}", binarySearchRightmost2(arr, 4));
        log.debug("6的索引:{}", binarySearchRightmost2(arr, 6));
        log.debug("0的索引:{}", binarySearchRightmost2(arr, 0));
        log.debug("5的索引:{}", binarySearchRightmost2(arr, 5));

    }
}
