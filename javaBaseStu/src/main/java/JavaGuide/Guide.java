package JavaGuide;

import lombok.Data;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @autor wwl
 * @date 2022/10/14-11:16
 */

public class Guide {
    public static void main(String[] args) {
        Math.max(1,2);
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addLast(4);
        Integer integer1 = deque.pollFirst();
        Integer integer2 = deque.pollFirst();
        Integer integer3 = deque.pollFirst();
        Integer integer4 = deque.pollFirst();
        System.out.println(integer1);
        System.out.println(integer2);
        System.out.println(integer3);
        System.out.println(integer4);
        deque.isEmpty();
        System.out.println(Math.abs(-4));
//        Integer.MIN_VALUE
        Object object = new Object();
    }
}


class Object {
    static {
        System.out.println("hhhhhh");
    }
}

