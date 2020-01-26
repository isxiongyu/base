package cn.xiongyu.net.file;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.String;

/**
 * ClassName: AcceptThread
 * Package: cn.xiongyu.net.file
 * Description:
 * Date: 19-10-15 下午4:41
 * Author: xiongyu
 */
public class AcceptThread extends Thread {
    private InputStream in = null;
    AcceptThread(InputStream inputStream) {
        in = inputStream;
    }

    @Override
    public void run() {
        DataInputStream din = null;
        FileOutputStream fout = null;
        try {
            din = new DataInputStream(in);
            String filename = null;
            filename = din.readUTF();
            fout = new FileOutputStream("/home/xiongyu/java_receive_file/" + filename);
            int c = -1;
            while ((c = din.read()) != -1) {
                fout.write(c);
                fout.flush();
            }
            System.out.println("文件接收成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                din.close();
                fout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
