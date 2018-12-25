package test;

import linkedlist.LinkedList;
import queue.ArrayQueue;
import queue.LinkedListQueue;
import queue.LoopQueue;
import queue.Queue;
import stack.ArrayStack;
import stack.LinkedListStack;
import stack.Stack;

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
    private static void simpleTestStack() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }

    private static void simpleTestArrayQueue() {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
            System.out.println(queue);
        }

        queue.dequeue();
        System.out.println(queue);
    }

    private static void soimpleTestLoopQueue() {
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
    private static double testQueue(Queue<Integer> q, int opCnt) {
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

    private static void simleTestLinkedList() {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 6; i++) {
            list.addLast(i);
            System.out.println(list);
        }


        list.add(2, 30);
        System.out.println(list);
    }

    private static void testLinkedListQueue() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
            System.out.println(queue);
        }

        int num = queue.dequeue();
        System.out.println(queue);
    }
}
