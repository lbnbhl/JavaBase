package org.example.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;


import static org.example.util.ByteBufferUtil.debugAll;

/**
 * @autor wwl
 * @date 2022/12/19-15:01
 */
@Slf4j
public class BufferAndChannelTest {
    public static void main(String[] args) {
//        readAndWrite();

        BufferAndChannelTest bufferAndChannelTest = new BufferAndChannelTest();
//        bufferAndChannelTest.stringAndBufferTest();
//        bufferAndChannelTest.ScatteringReads();

        bufferAndChannelTest.transferToTest();

    }

    private static void readAndWrite() {
        try {
            RandomAccessFile rw = new RandomAccessFile("NettyDemo/src/main/java/org/example/nio/hello.txt", "rw");
            FileChannel channel = rw.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(10);
            do {
                int n = channel.read(byteBuffer);
                log.debug("读到字节数：{}", n);
                if (n==-1)
                    break;
                // 切换 buffer 读模式
                byteBuffer.flip();
                while(byteBuffer.hasRemaining()) {
                    log.debug("读到的字节：{}", (char)byteBuffer.get());
                }
                // 切换 buffer 写模式
//                byteBuffer.clear();
                byteBuffer.compact();
                debugAll(byteBuffer);
            }while (true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void stringAndBufferTest(){
        ByteBuffer buffer1 = StandardCharsets.UTF_8.encode("你好");
        ByteBuffer buffer2 = Charset.forName("utf-8").encode("你好");

        debugAll(buffer1);
        debugAll(buffer2);

        CharBuffer buffer3 = StandardCharsets.UTF_8.decode(buffer1);
        System.out.println(buffer3.getClass());
        System.out.println(buffer3.toString());
    }

    public void ScatteringReads(){
        try (RandomAccessFile file = new RandomAccessFile("NettyDemo/src/main/java/org/example/nio/hello.txt", "rw")) {
            FileChannel channel = file.getChannel();
            ByteBuffer a = ByteBuffer.allocate(10);
            ByteBuffer b = ByteBuffer.allocate(3);
            ByteBuffer c = ByteBuffer.allocate(5);
            channel.read(new ByteBuffer[]{a, b, c});
            a.flip();
            b.flip();
            c.flip();
            debugAll(a);
            debugAll(b);
            debugAll(c);
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void split(ByteBuffer source) {
        source.flip();
        int oldLimit = source.limit();
        for (int i = 0; i < oldLimit; i++) {
            if (source.get(i) == '\n') {
                System.out.println(i);
                ByteBuffer target = ByteBuffer.allocate(i + 1 - source.position());
                // 0 ~ limit
                source.limit(i + 1);
                target.put(source); // 从source 读，向 target 写
                debugAll(target);
                source.limit(oldLimit);
            }
        }
        source.compact();
    }

    public void transferToTest(){
        String FROM = "NettyDemo/src/main/java/org/example/nio/hello.txt";
        String TO = "NettyDemo/src/main/java/org/example/nio/hi.txt";
        long start = System.nanoTime();
        try (FileChannel from = new FileInputStream(FROM).getChannel();
             FileChannel to = new FileOutputStream(TO).getChannel();
        ) {
            from.transferTo(0, from.size(), to);
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.nanoTime();
        System.out.println("transferTo 用时：" + (end - start) / 1000_000.0);
    }

    public void transferToBigTest(){
        try (
                FileChannel from = new FileInputStream("NettyDemo/src/main/java/org/example/nio/hello.txt").getChannel();
                FileChannel to = new FileOutputStream("NettyDemo/src/main/java/org/example/nio/hi.txt").getChannel();
        ) {
            // 效率高，底层会利用操作系统的零拷贝进行优化
            long size = from.size();
            // left 变量代表还剩余多少字节
            for (long left = size; left > 0; ) {
                System.out.println("position:" + (size - left) + " left:" + left);
                left -= from.transferTo((size - left), left, to);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
