package JavaGuide.jvm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @autor wwl
 * @date 2023/1/2-15:31
 */
public class ClassTest {
    private String a="s1";
    {
        b=1;
    }
    private int b=2;
    {
        a="s2";
    }

    ClassTest(String a ,int b){
        this.a=a;
        this.b=b;
    }

    public static void main(String[] args) {
        ClassTest s3 = new ClassTest("s3", 3);
        System.out.println(s3.a);
        System.out.println(s3.b);
        List<String> list = new ArrayList<>();
        list.add("令狐冲");
        list.add("风清扬");
        list.add("任我行");

        //获取迭代器对象
        Iterator<String> it = list.iterator();
        //使用迭代器遍历
        while(it.hasNext()) {
            String ele = it.next();
            System.out.println(ele);
        }
    }
}

