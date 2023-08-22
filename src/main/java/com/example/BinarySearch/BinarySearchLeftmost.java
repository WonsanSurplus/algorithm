package com.example.BinarySearch;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

/**
 * @Classname: BinarySearchLeftmost
 * @Description: 有重复的时候返回最左侧的
 * @Date: 2023/8/22 022
 * @Author: zs
 */
@Slf4j(topic = "BinarySearchLeftmost")
public class BinarySearchLeftmost {
    public static int binarySearchLeftmost1(int[] arr, int target) {
        int i = 0, j = arr.length;
        int candidate = -1;//记录位置
        while (i < j) {
            int m = (i + j) >>> 1;
            if (target < arr[m]) {
                j = m;
            } else if (arr[m] < target) {
                i = m + 1;
            } else {
                candidate = m;
                j = m;
            }
        }
        return candidate;
    }

    /**
     * 1.返回target在数组arr中最左侧出现的索引
     * 2.如果不存在，在返回target在arr中插入的位置
     * 例如arr = {1, 2, 4, 4, 4, 6, 7, 8, 9}，target=5，返回索引应该是5
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearchLeftmost2(int[] arr, int target) {
        int i = 0, j = arr.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target <= arr[m]) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i;
    }

    @Test
    @DisplayName("测试 binarySearchLeftmost1")
    public void test1() {
        int[] arr = {1, 2, 4, 4, 4, 6, 7, 8, 9};
        log.debug("4的索引:{}", binarySearchLeftmost1(arr, 4));
        log.debug("6的索引:{}", binarySearchLeftmost1(arr, 6));
        log.debug("0的索引:{}", binarySearchLeftmost1(arr, 0));
        log.debug("5的索引:{}", binarySearchLeftmost1(arr, 5));

    }
    @Test
    @DisplayName("测试 binarySearchLeftmost2")
    public void test2() {
        int[] arr = {1, 2, 4, 4, 4, 6, 7, 8, 9};
        log.debug("4的索引:{}", binarySearchLeftmost2(arr, 4));
        log.debug("6的索引:{}", binarySearchLeftmost2(arr, 6));
        log.debug("0的索引:{}", binarySearchLeftmost2(arr, 0));
        log.debug("5的索引:{}", binarySearchLeftmost2(arr, 5));

    }

}
