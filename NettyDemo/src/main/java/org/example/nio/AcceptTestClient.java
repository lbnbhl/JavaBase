package org.example.nio;

import java.io.IOException;
import java.net.Socket;

/**
 * @autor wwl
 * @date 2022/12/20-19:58
 */
public class AcceptTestClient {
        public static void main(String[] args) {
            try (Socket socket = new Socket("localhost", 8080)) {
                System.out.println(socket);
                socket.getOutputStream().write("world".getBytes());
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
