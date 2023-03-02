package JavaGuide.accessControl.a;

import org.junit.jupiter.api.Test;

/**
 * @autor wwl
 * @date 2023/1/15-10:14
 */
public class B extends A{

    @Test
    public void hh() {
        A a=new A();
        System.out.println(a.b);
        System.out.println(a.c);
        System.out.println(a.d);
    }

    public static void main(String[] args) {
        A a=new A();
        System.out.println(a.b);
        System.out.println(a.c);
        System.out.println(a.d);
    }
}
