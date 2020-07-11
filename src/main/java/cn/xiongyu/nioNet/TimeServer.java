package cn.xiongyu.nioNet;

/**
 * ClassName: TimeServer
 * Description:
 * Create by xiongyu
 * Date: 2020/4/23 12:15 下午
 */
public class TimeServer {
    public static void main(String[] args) {
        int port = 5555;
        MultiplexerTimeServer multiplexerTimeServer = new MultiplexerTimeServer(port);
        new Thread(multiplexerTimeServer, "multiplexerTimeServer-01").start();
    }
}
