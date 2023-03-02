package JavaGuide.kryoTest;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @autor wwl
 * @date 2022/10/14-11:17
 */
//@Slf4j
public class KryoSerializer extends Serializer {
    @Override
    public void write(Kryo kryo, Output output, Object o) {

    }

    @Override
    public Object read(Kryo kryo, Input input, Class aClass) {
        return null;
    }

//    /**
//     * Because Kryo is not thread safe. So, use ThreadLocal to store Kryo objects
//     */
//    private final ThreadLocal<Kryo> kryoThreadLocal = ThreadLocal.withInitial(() -> {
//        Kryo kryo = new Kryo();
//        kryo.register(RpcResponse.class);
//        kryo.register(RpcRequest.class);
//        return kryo;
//    });
//
//    @Override
//    public byte[] serialize(Object obj) {
//        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//             Output output = new Output(byteArrayOutputStream)) {
//            Kryo kryo = kryoThreadLocal.get();
//            // Object->byte:将对象序列化为byte数组
//            kryo.writeObject(output, obj);
//            kryoThreadLocal.remove();
//            return output.toBytes();
//        } catch (Exception e) {
//            throw new SerializeException("Serialization failed");
//        }
//    }
//
//    @Override
//    public <T> T deserialize(byte[] bytes, Class<T> clazz) {
//        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
//             Input input = new Input(byteArrayInputStream)) {
//            Kryo kryo = kryoThreadLocal.get();
//            // byte->Object:从byte数组中反序列化出对对象
//            Object o = kryo.readObject(input, clazz);
//            kryoThreadLocal.remove();
//            return clazz.cast(o);
//        } catch (Exception e) {
//            throw new SerializeException("Deserialization failed");
//        }
//    }
//
//    @Override
//    public void write(Kryo kryo, Output output, Object o) {
//
//    }
//
//    @Override
//    public Object read(Kryo kryo, Input input, Class aClass) {
//        return null;
//    }
}