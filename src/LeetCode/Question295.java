package LeetCode;

import java.util.*;

/**
 * @author Struggle
 * @date Created in 16:54 2019/11/13
 * description Find Median from Data Stream 寻找中位数 包含两个函数: (1)添加数字; (2)寻找中位数
 * note: 1、所有的数字在0到100之间 2、99%的数字在0到1之间
 *       使用大根堆与小根堆来记录左右两边的数字, 保证大根堆中的数字均不大于小根堆的数字, 且大根堆数字的个数等于或小于1个小根堆数字的个数
 *       比较大根堆的堆顶以及小根堆的堆顶即可比较两者的大小, 可以进行调整
 * path: https://leetcode.com/problems/find-median-from-data-stream/description/
 * level: hard
 **/
public class Question295 {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int left = 0;
    int right = 0;

    public void MedianFinder() {
    }

    public void addNum(int num) {
        if (left == 0 && right == 0) {
            minHeap.add(num);
            right++;
            return;
        }

        // 个数相同加到右边
        if (left == right) {
            if (num >= maxHeap.peek()) {
                minHeap.add(num);
            } else {
                minHeap.add(maxHeap.poll());
                maxHeap.add(num);
            }
            right++;
            return;
        }

        // 个数不同加到左边
        if (num <= minHeap.peek()) {
            maxHeap.add(num);
        } else {
            maxHeap.add(minHeap.poll());
            minHeap.add(num);
        }
        left++;
    }

    public double findMedian() {
        if (left == right) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return minHeap.peek();
        }
    }

    public static void main(String[] args) {
        Question295 q = new Question295();
        q.MedianFinder();
        q.addNum(1);
        System.out.println(q.findMedian());
        q.addNum(3);
        System.out.println(q.findMedian());
    }
}
