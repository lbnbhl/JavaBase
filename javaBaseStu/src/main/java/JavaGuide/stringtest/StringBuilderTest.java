package JavaGuide.stringtest;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * TODO 测试是否线程安全
 * @autor wwl
 * @date 2022/12/11-15:03
 */
public class StringBuilderTest {
    public static StringBuilder method(){
        StringBuilder s1 = new StringBuilder();
        s1.append("A");
        s1.append("B");
        s1.append(1);
        ArrayDeque<TreeNode> queue= new ArrayDeque<>();
        queue.isEmpty();
        List<Double> res = new ArrayList<>();
        queue.pollFirst();
        HashMap<Integer,Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        return s1;
    }

    public static void main(String[] args) {
        StringBuilder stringBuilder = method();
        String s = stringBuilder.toString();
//        StringBuilderTest builderTest=new StringBuilderTest();
//        builderTest.method1(stringBuilder);
        System.out.println(s);


//        String s1 = "a";
//        String s2 = "b";
//        String s3 = "a" + "b";
//        String s4 = s1 + s2;
//        String s5 = "ab";
//        String s6 = s4.intern();
//        System.out.println(s3 == s4); //false
//        System.out.println(s3 == s5);   //true
//        System.out.println(s3 == s6);//true
//        String x2 = new String("c") + new String("d");
//        String x1 = "cd";
//        x2.intern();
////        String x1 = "cd";
//        // 如果调换了【最后两行代码】的位置呢，如果是jdk1.6呢
//        System.out.println(x1 == x2);//false

    }

    public void method1(StringBuilder s){
        s.append("A");
    }

    public void method2(StringBuilder s){
        s.append("B");
    }

    public void method3(StringBuilder s){
        s.append("C");
    }
}
