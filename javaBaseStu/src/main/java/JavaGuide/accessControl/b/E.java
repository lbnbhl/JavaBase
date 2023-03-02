package JavaGuide.accessControl.b;

import JavaGuide.accessControl.a.A;
import org.junit.jupiter.api.Test;

/**
 * @autor wwl
 * @date 2023/1/15-10:25
 */
public class E {
    @Test
    public void hh(){
        A a = new A();
        System.out.println(a.d);
    }

    public static void main(String[] args) {
        A a = new A();
    }
}