package com.lbnbhl.javase;

import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @autor wwl
 * @date 2022/8/23-11:48
 * Java语言基础、流程控制、函数、数组、对象、修饰符、接口、内部类、集合、异常处理、多线程、
 * IO框架、反射、OOAO初步等基础的测试
 */
public class JavaSE {

    @Test
    public void stringTest(){
//        String hello="hello";
//        String java="java";
//        String s1="hello"+"java";
//        String s2=hello+new String("java");
//        String s3=hello+java;
        String s4=new String("hello")+new String("java");
//        System.out.println(s1==s2);
    }

    /**
     * 综合:100以内逢7过
     */
    @Test
    public void whileSevenTest(){
        for (int i = 0; i < 100; i++) {
            if (i%7==0 || i/10==7 || i%10==7){
                System.out.println(i);
            }
        }
    }

    /**
     * ||和&&为短路与和短路或
     */
    @Test
    public void duanluTest(){
        int a=10;
        int b=10;
//        if (a++>0 || b++>0){
//            System.out.println("a:"+a+"\nb:"+b);
//        }
//        if (a++>0 | b++>0){
//            System.out.println("a:"+a+"\nb:"+b);
//        }
//        if (!(a++<0 && b++>0)){
//            System.out.println("a:"+a+"\nb:"+b);
//        }
        if (!(a++<0 & b++>0)){
            System.out.println("a:"+a+"\nb:"+b);
        }
    }

    @Test
    public void sanyuan(){
        int c = 1>2?1:0;
        System.out.println("c:"+c);
    }

    @Test
    public void switchTest(){
        int i = 1;
        switch (i){
            case 1:
            case 2:
                System.out.println(i);
//                break;
            case 3:
                System.out.println("hhhhhhhh");
            default:
                System.out.println("hh");
        }
    }

    @Test
    public void arrayTest(){
        String[] name={"wwl","zmt"};
        char[] sex={'b','g'};
        int[] age={20,21};
        for (int i = 0; i < age.length; i++) {
            System.out.println(age[i]);
        }
    }

    @Test
    public void randomTest(){
        Random random = new Random();
        int i = random.nextInt(100);
        System.out.println(i);
    }

    @Test
    public void mathAndSystemTest() throws InterruptedException {
        int abs = (int) Math.sqrt(16);
        System.out.println(abs);
        long begin = System.currentTimeMillis();
        Thread.sleep(21);
        long end = System.currentTimeMillis();
        System.out.println(end-begin);
        Date date = new Date();
        System.out.println(date.toString());
    }

    @Test
    public void runtimeTest() throws IOException {
        long l = Runtime.getRuntime().maxMemory();
        System.out.println(l);
        Runtime.getRuntime().exec("shutdown -a");
//        BigInteger bigInteger = new BigInteger("5");
//        System.out.println(bigInteger.max(new BigInteger("3")));
    }

    @Test
    public void pachongTest() throws IOException {
        URL url = new URL("https://www.o8tv.com/");
        URLConnection urlConnection = url.openConnection();
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String line;
        String pattern = "消失的孩子";

        Pattern r = Pattern.compile(pattern);
        while ((line=bufferedReader.readLine()) != null){
            Matcher m = r.matcher(line);
            while (m.find()){
                String group = m.group();
                System.out.println(group);
            }
        }
        bufferedReader.close();
    }

    @Test
    public void zhuangxianghechaixiangTest(){
        Integer x=1,y=2;
//        x可以调用compareTo说明此刻装箱
        int i = x.compareTo(y);
//        可以进行计算说明拆箱
        if (i==0){
            System.out.println("x==y");
        }else if (i<0){
            System.out.println("x-y="+(x-y));
        }else{
            System.out.println("x+y="+(x+y));
        }
    }

    @Test
    public void enumTest(){
            EnumTest[] values = EnumTest.values();
            for (EnumTest value : values) {
                System.out.println(value);
            }
        EnumTest sat = EnumTest.valueOf(EnumTest.class, "Sat");
    }

    @Test
    public void genericTypeTest(){

        MyBoxGenericTypeTest<String> stringMyBoxGenericTypeTest = new MyBoxGenericTypeTest<>();
        stringMyBoxGenericTypeTest.setT("hhh");
        String t = stringMyBoxGenericTypeTest.getT();
        System.out.println(t);

        //定义的是Object，但可以使用它的子类String来作为参数
        MyBoxGenericTypeTest<Object> objectMyBoxGenericTypeTest = new MyBoxGenericTypeTest<Object>();
        objectMyBoxGenericTypeTest.setT(new String("nihao"));
        System.out.println(objectMyBoxGenericTypeTest.getT());
    }

    @Test
    public void threadTest(){

        Thread thread = new Thread();

    }

    @Test
    public void integerTest(){
//        自动装箱
        Integer a=1;

//        自动拆箱
        if (a==1){
            System.out.println("a=1");
        }
    }


//    @Test
//    public void exceptionTest(){
//        Scanner scanner = null;
//        try {
//            scanner = new Scanner(new File("D://read.txt"));
//            while (scanner.hasNext()) {
//                System.out.println(scanner.nextLine());
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            if (scanner != null) {
//                scanner.close();
//            }
//        }
//
//        try (Scanner scanner1 = new Scanner(new File("D://test.txt"))) {
//            while (scanner1.hasNext()) {
//                System.out.println(scanner1.nextLine());
//            }
//        } catch (FileNotFoundException fnfe) {
//            fnfe.printStackTrace();
//        }
//    }
}

enum EnumTest{

    Mon(1),Tue(2),Wed(3),Thu(4),Fri(5),Sat(6),Sun(7);
    private final int value;

    EnumTest(int value) {
        this.value = value;
    }

}

class MyBoxGenericTypeTest<T> {
    private T t;
    void setT(T t){
        this.t=t;
    }
    T getT(){
        return t;
    }
}