package cn.xiongyu.netty.tcp;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;

/**
 * ClassName: EchoClient
 * Description:
 * Create by xiongyu
 * Date: 2020/4/23 8:50 下午
 */
public class EchoClient {
    private String ip;
    private int port;

    public EchoClient(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public static void main(String[] args) throws InterruptedException {
        EchoClient echoClient = new EchoClient("127.0.0.1", 11111);
        EchoClientHandler echoClientHandler = new EchoClientHandler();
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .remoteAddress(new InetSocketAddress(echoClient.ip, echoClient.port))
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(echoClientHandler);
                        }
                    });
            ChannelFuture f = bootstrap.connect().sync();
            if (f.channel().isActive()) {
                f.channel().writeAndFlush(Unpooled.copiedBuffer("你好，我是客户端!", CharsetUtil.UTF_8));
            }
            f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();
        }
    }
}
