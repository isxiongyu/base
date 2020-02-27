package cn.xiongyu.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.String;
import java.net.Socket;

/**
 * ClassName: Client
 * Package: cn.xiongyu.net
 * Description:
 * Date: 19-10-9 下午11:01
 * Author: xiongyu
 */
public class Client {
    public static void main(String[] args) throws IOException {
        String host = "127.0.0.1";
//        String host = "10.108.149.5";
        int port = 55533;
        Socket socket = new Socket(host, port);
        OutputStream os = socket.getOutputStream();
        String message = "我爱你";
        os.write(message.getBytes("UTF-8"));
        os.close();
        socket.close();
    }
}
