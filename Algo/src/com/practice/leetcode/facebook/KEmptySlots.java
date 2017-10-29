package com.practice.leetcode.facebook;

import java.util.TreeSet;

public class KEmptySlots {

    public int kEmptySlots(int[] flowers, int k) {



        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < flowers.length; i++) {
            int current = flowers[i];
            Integer next = treeSet.higher(current);
            if (next != null && next - current == k + 1) {
                return i + 1;
            }
            Integer pre = treeSet.lower(current);
            if (pre != null && current - pre == k + 1) {
                return i + 1;
            }
            treeSet.add(current);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.print(new KEmptySlots().kEmptySlots(new int[]{2,5,1,4,3},3));

    }
}
