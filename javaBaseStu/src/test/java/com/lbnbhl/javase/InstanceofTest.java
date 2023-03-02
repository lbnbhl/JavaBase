package com.lbnbhl.javase;

/**
 * @autor wwl
 * @date 2022/8/29-20:29
 */
public class InstanceofTest {
        public static void main(String[] args) {
            // 向上转型
            Animal a = new Cat();
            a.eat();               // 调用的是 Cat 的 eat

            // 向下转型
            if (a instanceof Cat){
                Cat c = (Cat)a;
                c.catchMouse();        // 调用的是 Cat 的 catchMouse
            } else if (a instanceof Dog){
                Dog d = (Dog)a;
                d.watchHouse();       // 调用的是 Dog 的 watchHouse
            }
        }
}

class Animal {
    String name;
    public void eat(){
        System.out.println("animal吃东西");
    }
}

class Cat extends Animal{
    public void eat(){
        System.out.println("cat吃🐟");
    }
    void catchMouse(){
        System.out.println("cat抓老鼠");
    }
}

class Dog extends Animal{

    public void eat(){
        System.out.println("dog吃hh");
    }

    void watchHouse(){
        System.out.println("dog看家");
    }
}