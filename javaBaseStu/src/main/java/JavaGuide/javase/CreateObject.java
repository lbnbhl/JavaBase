package JavaGuide.javase;

import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * @autor wwl
 * @date 2023/1/15-16:01
 * java创建对象的五种方式
 * 使用new关键字	} → 调用了构造函数
 * 反射
 * 使用clone方法	} → 没有调用构造函数
 * 使用反序列化	} → 没有调用构造函数
 */
public class CreateObject implements Cloneable, Serializable {

    private Integer integer=2131;

//使用new关键字创建
    public void method1(){
        CreateObject createObject = new CreateObject();
        System.out.println(createObject);
    }

//    使用Class类的newInstance方法
    public void method2() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        CreateObject createObject = (CreateObject) Class.forName("JavaGuide.javase.CreateObject").getDeclaredConstructor().newInstance();
        System.out.println(createObject);
    }

//    同method2
    public void method3() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        CreateObject createObject = CreateObject.class.getDeclaredConstructor().newInstance();
        System.out.println(createObject);
    }

//    同method2
    public void method4() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        CreateObject o = (CreateObject) ClassLoader.getSystemClassLoader().loadClass("JavaGuide.javase.CreateObject").getDeclaredConstructor().newInstance();
        System.out.println(o);
    }

//    使用clone方法
    public void method5() throws CloneNotSupportedException {
        CreateObject createObject = new CreateObject();
        CreateObject clone = (CreateObject) createObject.clone();
        System.out.println(createObject.integer==clone.integer);
        System.out.println(createObject.integer.equals(clone.integer));
        System.out.println(clone);
    }

//    使用反序列化
    public void method6(){

    }

    @Test
    public void createObjectTest() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, CloneNotSupportedException, ClassNotFoundException {
        method1();
        method2();
        method3();
        method4();
        method5();
    }

}
