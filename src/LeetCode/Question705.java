package LeetCode;

/**
 * @author Struggle
 * @date Created in 21:14 2021/1/14
 * description Design HashSet 设计一个hashSet
 * node: 因为本题的输入均为正数，所以用数组记录有没有出现即可，本题中使用boolean 类型数组的速度快于 int类型数组
 * path: https://leetcode.com/problems/design-hashset/
 * level: easy
 **/
public class Question705 {

    boolean[] nums = new boolean[1000001];
    /** Initialize your data structure here. */
    public void MyHashSet() {

    }

    public void add(int key) {
        nums[key] = true;
    }

    public void remove(int key) {
        nums[key] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return nums[key];
    }

}
