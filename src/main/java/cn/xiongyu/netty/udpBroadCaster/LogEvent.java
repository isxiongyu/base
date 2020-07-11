package cn.xiongyu.netty.udpBroadCaster;

import java.net.InetSocketAddress;

/**
 * ClassName: LogEvent
 * Description:
 * Create by xiongyu
 * Date: 2020/5/3 4:31 下午
 */
public class LogEvent {
    public static final byte SEPARATOR = (byte) ':';
    private final InetSocketAddress source;
    private final String logfile;
    private final String msg;
    private final long received;

    public LogEvent(String logfile, String msg) { //用于传出消息的构造函数
        this(null, -1, logfile, msg);
    }

    // 用于传入消息的构造函数
    public LogEvent(InetSocketAddress source, long received, String logfile, String msg) {
        this.source = source;
        this.logfile = logfile;
        this.msg = msg;
        this.received = received;
    }

    public InetSocketAddress getSource() {
        return source;
    }

    public String getLogfile() {
        return logfile;
    }

    public String getMsg() {
        return msg;
    }

    public long getReceived() {
        return received;
    }

    @Override
    public String toString() {
        return "LogEvent{" +
                "source=" + source +
                ", logfile='" + logfile + '\'' +
                ", msg='" + msg + '\'' +
                ", received=" + received +
                '}';
    }
}
