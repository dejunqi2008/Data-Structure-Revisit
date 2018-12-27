package test;

import binarySearchTree.BST;
import linkedlist.LinkedList;
import map.BSTMap;
import map.ListMap;
import map.Map;
import queue.ArrayQueue;
import queue.LinkedListQueue;
import queue.LoopQueue;
import queue.Queue;
import set.Set;
import set.TreeSet;
import stack.ArrayStack;
import stack.LinkedListStack;
import stack.Stack;

import java.util.ArrayList;
import java.util.Random;

public class Test {

    public void simpleTestLinkedListQueue() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
            System.out.println(queue);
        }
        queue.dequeue();
        System.out.println(queue);
    }

    public void compareStackPerformance() {
        int optCnt = 10000000;
        ArrayStack<Integer> stack1 = new ArrayStack<>();
        LinkedListStack<Integer> stack2 = new LinkedListStack<>();
        System.out.println(testStack(stack1, optCnt));
        System.out.println(testStack(stack2, optCnt));
    }

    private static double testStack(Stack<Integer> stack, int optCnt) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < optCnt; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < optCnt; i++) {
            stack.pop();
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;

    }
    public static void simpleTestStack() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }

    public static void simpleTestArrayQueue() {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
            System.out.println(queue);
        }

        queue.dequeue();
        System.out.println(queue);
    }

    public static void soimpleTestLoopQueue() {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 15; i++) {
            queue.enqueue(i);
            System.out.println(queue);
        }

        int num = queue.dequeue();
        System.out.println(queue);
    }

    public static void queueComparision() {
        int opCnt = 1000000;
        LinkedListQueue<Integer> listQueue = new LinkedListQueue<>();
        double t1 = testQueue(listQueue, opCnt);
        System.out.println("linkedList queue: " + t1);

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double t2 = testQueue(loopQueue, opCnt);
        System.out.println("loop queue: " + t2);
    }

    // test operation time for different queue implementations
    public static double testQueue(Queue<Integer> q, int opCnt) {
        long startTime = System.nanoTime();

        // operation
        Random random = new Random();
        for (int i = 0; i < opCnt; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < opCnt; i++) {
            q.dequeue();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;

    }

    public static void simleTestLinkedList() {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 6; i++) {
            list.addLast(i);
            System.out.println(list);
        }


        list.add(2, 30);
        System.out.println(list);
    }

    public static void testLinkedListQueue() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
            System.out.println(queue);
        }

        int num = queue.dequeue();
        System.out.println(queue);
    }


    public static void simpleTestBST() {
        BST<Integer> bst = new BST<>();
        bst.add(10);
        bst.add(8);
        bst.add(9);
        bst.add(7);
        bst.add(4);
        bst.add(15);

        System.out.println(bst.contains(7));
        ArrayList<Integer> res = bst.inOrder();
        System.out.println(res);

        bst.remove(8);
        System.out.println(bst.contains(8));
        ArrayList<Integer> list = bst.inOrder();
        System.out.println(list);
    }

    public static void testRemoveBST() {
        BST<Integer> bst = new BST<>();
        Random random = new Random();
        int n = 1000;
        for (int i = 0; i < 1000; i++) {
            bst.add(random.nextInt(10000));
        }
        ArrayList<Integer> nums = new ArrayList<>();
        while (!bst.isEmpty()) {
            nums.add(bst.removeMin());
        }
        // System.out.println(nums);
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) > nums.get(i)) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("Correct!");
    }

    public void testBSTSet() {

        Integer[] nums = {10, 8, 3, 15, 9, 7, 7, 7, 7, 2, 14, 17};
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        System.out.println("Array length  " + nums.length);
        System.out.println("Unique number: " + set.getSize());

        System.out.println(set);


        int target = 10;
        set.remove(target);
        System.out.println("Size: " + set.getSize());

        System.out.println(set);
        System.out.println(set.contains(target));
    }

    public void testListMap() {
        Map<String, Integer> map = new ListMap<>();
        String[] arr = {"Apple", "Orange", "Banana", "Melon", "Apple", "Orange"};
        String[] keys = {"Apple", "Orange", "Banana", "Melon"};
        for (String w : arr) {
            if (map.contains(w)) {
                map.set(w, map.get(w) + 1);
            } else {
                map.add(w, 1);
            }
        }

        for (String w : keys) {
            System.out.println(w + " : " + map.get(w));
        }

        map.remove("Apple");
        for (String w : keys) {
            System.out.println(w + " : " + map.get(w));
        }
    }

    public void testBSTMap() {
        Map<String, Integer> map = new BSTMap<>();
        String[] arr = {"Apple", "Orange", "Banana", "Melon", "Apple", "Orange"};
        String[] keys = {"Apple", "Orange", "Banana", "Melon"};
        for (String w : arr) {
            if (map.contains(w)) {
                map.set(w, map.get(w) + 1);
            } else {
                map.add(w, 1);
            }
        }

        for (String w : keys) {
            System.out.println(w + " : " + map.get(w));
        }
        System.out.println(map.getSize());

        map.remove("Apple");
        for (String w : keys) {
            System.out.println(w + " : " + map.get(w));
        }
        System.out.println();

        System.out.println(map.getSize());

    }
}
