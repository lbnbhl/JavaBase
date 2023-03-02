package JavaGuide.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @autor wwl
 * @date 2022/10/17-16:21
 */
public class ArraylistTest {

    @Test
    public void arraylistTest(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12);
        ArrayList<Integer> list1 = new ArrayList<>(list);

    }
}
