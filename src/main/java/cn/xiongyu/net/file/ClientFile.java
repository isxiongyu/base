package cn.xiongyu.net.file;

import java.io.*;
import java.lang.String;
import java.net.Socket;

/**
 * ClassName: ClientFile
 * Package: cn.xiongyu.net.file
 * Description:
 * Date: 19-10-15 下午4:38
 * Author: xiongyu
 */
public class ClientFile {
    static File file = new File("/home/xiongyu/Documents/sql_file/department.sql");
    public static void main(String[] args) throws IOException {
        String host = "127.0.0.1";
        int port = 12345;
        Socket socket = new Socket(host, port);
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeUTF(file.getName());
        dataOutputStream.flush();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        int c = -1;
        while ((c=bufferedInputStream.read())!=-1) {
            //将读取的文件以字节方式写入DataOutputStream，之后传输到服务端
            //这里也可以使用byte[]数据进行读取和写入
            dataOutputStream.write(c);
            dataOutputStream.flush();
        }
    }
}
