package JavaGuide.collection;

import java.util.Arrays;
import java.util.Map;

/**
 * @autor wwl
 * @date 2023/1/20-14:54
 */
public class ArrayscopyOfTest {

    public static void main(String[] args) {
        int[] a = new int[3];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        int[] b = Arrays.copyOf(a, 10);
        System.out.println("b.length"+b.length);

    }
}