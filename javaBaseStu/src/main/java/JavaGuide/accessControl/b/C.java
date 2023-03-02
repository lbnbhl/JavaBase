package JavaGuide.accessControl.b;

import JavaGuide.accessControl.a.A;
import org.junit.jupiter.api.Test;

/**
 * @autor wwl
 * @date 2023/1/15-10:14
 */
public class C extends A {
    @Test
    public void hhh(){
        System.out.println(super.c);
        System.out.println(super.d);
    }

    public static void main(String[] args) {
    }
}
