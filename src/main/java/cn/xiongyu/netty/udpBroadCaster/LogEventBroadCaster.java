package cn.xiongyu.netty.udpBroadCaster;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

import java.io.File;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;

/**
 * ClassName: LogEventBroadCaster
 * Description:
 * Create by xiongyu
 * Date: 2020/5/3 4:49 下午
 */
public class LogEventBroadCaster {
    private EventLoopGroup group;
    private Bootstrap bootstrap;
    private File file;

    public LogEventBroadCaster(InetSocketAddress address, File file) {
        group = new NioEventLoopGroup();
        bootstrap = new Bootstrap();
        bootstrap.group(group).channel(NioDatagramChannel.class)
                .option(ChannelOption.SO_BROADCAST, true)
                .handler(new LogEventEncoder(address));
        this.file = file;
    }

    public void run() throws Exception {
        Channel channel = bootstrap.bind(0).sync().channel();
        long pointer = 0;
        for (; ; ) {
            long len = file.length();
            if (len < pointer) {
                pointer = len;
            } else if (len > pointer) {// 从0开始读取文件
                RandomAccessFile raf = new RandomAccessFile(this.file, "r");
                raf.seek(pointer);// 跳到指针的位置
                String line;
                while ((line = raf.readLine()) != null) {// 逐行读取文件内容，指针随之移动，直到文件末尾
                    // 将logevent消息传输给Channel
                    channel.writeAndFlush(new LogEvent(null, -1, file.getName(), line));
                }
                pointer = raf.getFilePointer();// 获取当前指针位置，如果循环被中断，则重启时不会读取旧文件
                raf.close();// 关闭文件
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.interrupted();
                break;
            }
        }
    }

    public void stop() {
        group.shutdownGracefully();
    }

    public static void main(String[] args) {
        File file = new File("/Users/xiongyu/Documents/javaProjects/base/src/main/java/cn/xiongyu/netty/udpBroadCaster/file.txt");
        LogEventBroadCaster broadCaster = new LogEventBroadCaster(new InetSocketAddress("127.0.0.1", 9999), file);
        try {
            broadCaster.run();
        } catch (Exception e) {
            broadCaster.stop();
        }
    }
}
