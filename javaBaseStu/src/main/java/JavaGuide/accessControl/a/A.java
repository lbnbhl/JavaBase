package JavaGuide.accessControl.a;

import org.junit.jupiter.api.Test;

/**
 * @autor wwl
 * @date 2023/1/15-10:14
 */
public class A {
    private String a="我是private";
    String b="我是default";
    protected String c="我是protected";
    public String d="我是public";

    @Test
    public void say(){
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }

    public A(){
        this.b="hahaha";
    }

    public String getB() {
        return b;
    }

    public static void sayhh(){
        System.out.println("hhhhhh");
    }
}
