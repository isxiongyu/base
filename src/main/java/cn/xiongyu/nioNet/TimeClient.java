package cn.xiongyu.nioNet;

/**
 * ClassName: TimeClient
 * Description:
 * Create by xiongyu
 * Date: 2020/4/23 12:59 下午
 */
public class TimeClient {
    public static void main(String[] args) {
        String ip = "127.0.0.1";
        int port = 5555;
        TimeClientHandler timeClientHandler = new TimeClientHandler(ip, port);
        new Thread(timeClientHandler).start();
    }
}
