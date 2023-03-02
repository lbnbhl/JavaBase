package JavaGuide.jvm;

import java.nio.ByteBuffer;

/**
 * @autor wwl
 * @date 2022/12/11-16:42
 */
public class DirectMemory {
    public static void main(String[] args) {
        //通过ByteBuffer申请1M的直接内存
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);

    }
}
