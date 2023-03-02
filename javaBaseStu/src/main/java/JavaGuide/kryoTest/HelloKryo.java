package JavaGuide.kryoTest;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.util.Pool;
import sun.misc.Unsafe;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @autor wwl
 * @date 2022/10/14-11:35
 */
public class HelloKryo {
    static public void main(String[] args) throws Exception {

        Pool<Kryo> kryoPool=new Pool<Kryo>(true,false,8) {
            @Override
            protected Kryo create() {
                Kryo kryo = new Kryo();
                return kryo;
            }
        };


        Kryo kryo = kryoPool.obtain();
        kryo.register(SomeClass.class);
        SomeClass object = new SomeClass();
        object.value = "Hello Kryo!";
        Output output = new Output(new FileOutputStream("file1.txt"));
        kryo.writeObject(output, object);
        output.close();
        Input input = new Input(new FileInputStream("file1.txt"));
        SomeClass object2 = kryo.readObject(input, SomeClass.class);
        input.close();
        System.out.println(object2.value);
        kryoPool.free(kryo);
    }

    static public class SomeClass {
        String value;
    }

}
