package cn.xiongyu.net.file;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ClassName: ServerFile
 * Package: cn.xiongyu.net
 * Description:
 * Date: 19-10-15 下午4:38
 * Author: xiongyu
 */
public class ServerFile {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("等待接收文件");
        Socket socket = serverSocket.accept();
        new AcceptThread(socket.getInputStream()).start();
    }
}
