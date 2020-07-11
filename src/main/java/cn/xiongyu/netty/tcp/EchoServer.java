package cn.xiongyu.netty.tcp;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * ClassName: EchoServer
 * Description:
 * Create by xiongyu
 * Date: 2020/4/23 8:38 下午
 */
@ChannelHandler.Sharable
public class EchoServer {
    private int port;
    EchoServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws InterruptedException {
        EchoServer echoServer = new EchoServer(11111);
        EventLoopGroup group = new NioEventLoopGroup();
        EventLoopGroup work = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(group, work)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(echoServer.port))
                    .childHandler(new ChannelInitializerImpl());
            ChannelFuture f = serverBootstrap.bind().sync();
            f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();
        }
    }
    static class ChannelInitializerImpl extends ChannelInitializer<Channel> {

        @Override
        protected void initChannel(Channel channel) throws Exception {
            ChannelPipeline pipeline = channel.pipeline();
            pipeline.addLast(new EchoServerHandler());
            pipeline.addLast(new HttpServerHandler());
        }
    }
}
