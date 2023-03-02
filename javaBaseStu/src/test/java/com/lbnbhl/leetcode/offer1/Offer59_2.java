package com.lbnbhl.leetcode.offer1;

//import java.awt.desktop.QuitResponse;
import java.util.*;

/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * @autor wwl
 * @date 2022/10/7-17:10
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出:[null,null,null,2,1,2]
 */
public class Offer59_2 {

    Deque<Integer> queue1;
    Deque<Integer> queue2;

    public Offer59_2() {
        queue1=new ArrayDeque<>();
        queue2=new ArrayDeque<>();
    }

    public int max_value() {
        return queue2.isEmpty()?-1:queue2.getFirst();
    }

    public void push_back(int value) {
        if (queue2.isEmpty()){}
        else if (queue2.getFirst()<value){
            queue2.removeAll(queue2);

        }else if (queue2.getFirst()>value){
            while (queue2.getLast()< value){
                queue2.removeLast();
            }
        }
        queue2.addLast(value);
        queue1.addLast(value);
    }

    public int pop_front() {
        if (queue2.isEmpty()) return -1;
        int res=queue1.removeFirst();
        if (queue2.getFirst() == res)
            queue2.removeFirst();
        return res;
    }
}

//DALAO
//class MaxQueue {
//    Queue<Integer> queue;
//    Deque<Integer> deque;
//    public MaxQueue() {
//        queue = new LinkedList<>();
//        deque = new LinkedList<>();
//    }
//    public int max_value() {
//        return deque.isEmpty() ? -1 : deque.peekFirst();
//    }
//    public void push_back(int value) {
//        queue.offer(value);
//        while(!deque.isEmpty() && deque.peekLast() < value)
//            deque.pollLast();
//        deque.offerLast(value);
//    }
//    public int pop_front() {
//        if(queue.isEmpty()) return -1;
//        if(queue.peek().equals(deque.peekFirst()))
//            deque.pollFirst();
//        return queue.poll();
//    }
//}
