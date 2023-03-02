package JavaGuide.unsafe;

import JavaGuide.accessControl.a.A;
import lombok.extern.slf4j.Slf4j;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @autor wwl
 * @date 2023/1/16-23:26
 */
@Slf4j
public class UnsafeTest {
    public static void main(String[] args) throws Exception {
//        Unsafe unsafe = new Unsafe();
//        Unsafe unsafe1 = Unsafe.getUnsafe();
//        ClassLoader.getSystemClassLoader().loadClass("sun.misc.Unsafe").getDeclaredMethod()
        Unsafe unsafe = reflectGetUnsafe();
        System.out.println(unsafe);
        assert unsafe != null;
        objTest(unsafe);
//        AtomicIntegerArray
    }

    private static Unsafe reflectGetUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    private void memoryTest(Unsafe unsafe) {
        int size = 4;
        long addr = unsafe.allocateMemory(size);
        long addr3 = unsafe.reallocateMemory(addr, size * 2);
        System.out.println("addr: "+addr);
        System.out.println("addr3: "+addr3);
        try {
            unsafe.setMemory(null,addr ,size,(byte)1);
            for (int i = 0; i < 2; i++) {
                unsafe.copyMemory(null,addr,null,addr3+size*i,4);
            }
            System.out.println(unsafe.getInt(addr));
            System.out.println(unsafe.getLong(addr3));
        }finally {
            unsafe.freeMemory(addr);
            unsafe.freeMemory(addr3);
        }
    }


    public static void objTest(Unsafe unsafe) throws Exception{
        A a1=new A();
        System.out.println(a1.getB());
        A a2 = A.class.newInstance();
        System.out.println(a2.getB());
        A a3= (A) unsafe.allocateInstance(A.class);
        System.out.println(a3.getB());

    }

}
