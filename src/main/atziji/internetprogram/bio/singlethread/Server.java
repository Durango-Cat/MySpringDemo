package main.atziji.internetprogram.bio.singlethread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 网络编程
 *
 * @author Zhuqiuping on 2019/11/5
 */
public class Server {
    public static void main(String[] args) {
        byte[] buffer = new byte[1024];

        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("服务器端连接上8080端口");
            System.out.println(serverSocket);
            while (true) {
                System.out.println("服务器端等待客户端的连接请求...");
                Socket socket = serverSocket.accept();
                System.out.println("服务器端已经接收客户端连接请求");
                System.out.println("服务器正在等待接收数据");
                socket.getInputStream().read(buffer);
                System.out.println("服务器读取到数据...");
                String content = new String(buffer, "utf-8");
                System.out.println("读取到的数据是：" + content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
