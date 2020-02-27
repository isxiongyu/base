package cn.xiongyu.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.String;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ClassName: Server
 * Package: cn.xiongyu.net
 * Description:
 * Date: 19-10-9 下午11:02
 * Author: xiongyu
 */
public class Server {
    public static void main(String[] args) throws IOException {
        int port = 55533;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("等待中...");
        Socket socket = null;
        InputStream is = null;
        OutputStream os = null;
        while (true) {
            socket = serverSocket.accept();
            is = socket.getInputStream();
            byte[] bytes = new byte[10240];
            int len;
            StringBuffer sb = new StringBuffer();
            while ((len = is.read(bytes)) != -1) {
                sb.append(new String(bytes, 0, len,"UTF-8"));
            }
            System.out.println("服务器: " + sb);
        }
//        is.close();
//        socket.close();
//        serverSocket.close();
    }
}
