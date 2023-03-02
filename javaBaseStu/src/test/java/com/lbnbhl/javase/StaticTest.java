package com.lbnbhl.javase;

/**
 * @autor wwl
 * @date 2022/8/29-19:33
 * 找到main方法入口，main方法是程序入口，但在执行main方法之前，要先加载Test类
 *
 * 加载Test类的时候，发现Test类有static块，而是先执行static块，输出test static结果
 *
 * 然后执行new MyClass(),执行此代码之前，先加载MyClass类，发现MyClass类继承Test类，而是要先加载Test类，Test类之前已加载
 *
 * 加载MyClass类，发现MyClass类有static块，而是先执行static块，输出myclass static结果
 *
 * 然后调用MyClass类的构造器生成对象，在生成对象前，需要先初始化父类Test的成员变量，而是执行Person person = new Person("Test")代码，发现Person类没有加载
 *
 * 加载Person类，发现Person类有static块，而是先执行static块，输出person static结果
 *
 * 接着执行Person构造器，输出person Test结果
 *
 * 然后调用父类Test构造器，输出test constructor结果，这样就完成了父类Test的初始化了
 *
 * 再初始化MyClass类成员变量，执行Person构造器，输出person MyClass结果
 *
 * 最后调用MyClass类构造器，输出myclass constructor结果，这样就完成了MyClass类的初始化了
 * ————————————————
 */
public class StaticTest {
        Person person = new Person("Test");
        static{
            System.out.println("test static");
        }

        public StaticTest() {
            System.out.println("test constructor");
        }

        public static void main(String[] args) {
            new MyClass();
        }

        static void hh(){
            System.out.println("hh");
        }
    }

    class Person{
        static{
            System.out.println("person static");
        }
        public Person(String str) {
            System.out.println("person "+str);
            StaticTest.hh();
        }
    }


    class MyClass extends StaticTest {
        Person person = new Person("MyClass");
        static{
            System.out.println("myclass static");
        }

        public MyClass() {
            System.out.println("myclass constructor");
        }
}
