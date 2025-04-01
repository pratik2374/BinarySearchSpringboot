package com.example.demo;

import java.util.Arrays;
import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class BinarySearchService {

    public int binarySearch(int[] Array, int target) {
        
        HashMap<Integer,Integer>map=new HashMap<>();

        for(int i=0;i<Array.length;i++){
            map.put(Array[i], i);
        }

        if (!isSorted(Array)) {
            Arrays.sort(Array);
        }

        int left = 0, right = Array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (Array[mid] == target) return map.get(Array[mid]);
            if (Array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Target not found
    }

    private boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
