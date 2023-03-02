package org.example.nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @autor wwl
 * @date 2022/12/20-11:00
 */
public class PathAndFileTest {
    public static void main(String[] args) {
//        pathTest();
        visitDirectoryTest();
    }

    public static void pathTest(){
        Path path = Paths.get("D:\\JavaTest\\JavaBase\\NettyDemo\\src\\main\\java\\org\\example\\nio\\hello.txt");
        System.out.println(path);
        System.out.println(path.normalize()); // 正常化路径

        Path path1 = Paths.get("NettyDemo/src/main/java/org/example/nio/d1/d2");
        try {
//            Files.createDirectory(path1);
            Path source = Paths.get("NettyDemo/src/main/java/org/example/nio/hello.txt");
            Path target = Paths.get("NettyDemo/src/main/java/org/example/nio/hi.txt");
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            Files.delete(target);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void visitDirectoryTest(){
        Path path = Paths.get("D:\\work\\计算机组成原理");
        AtomicInteger dirCount = new AtomicInteger();
        AtomicInteger fileCount = new AtomicInteger();
        try {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>(){
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
                        throws IOException {
                    System.out.println(dir);
                    dirCount.incrementAndGet();
                    return super.preVisitDirectory(dir, attrs);
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                        throws IOException {
                    System.out.println(file);
                    fileCount.incrementAndGet();
                    return super.visitFile(file, attrs);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(dirCount); // 1187
        System.out.println(fileCount); // 3163
    }
}
