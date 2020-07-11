package cn.xiongyu.netty.udp;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioDatagramChannel;
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
        EchoClient echoClient = new EchoClient("127.0.0.1", 55555);
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST,true)//允许广播
                    .remoteAddress(new InetSocketAddress(echoClient.ip, echoClient.port))
                    .handler(new SimpleChannelInboundHandler<DatagramPacket>() {
                        @Override
                        protected void messageReceived(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket) throws Exception {
                            System.out.println("客户端接受数据");
                        }
                    });
            ChannelFuture f = bootstrap.bind(new InetSocketAddress(0));
            f.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    if (channelFuture.isSuccess()) {
                        ByteBuf writeBuf = Unpooled.copiedBuffer("来自服务器的响应".getBytes());
                        f.channel().writeAndFlush(new DatagramPacket(writeBuf, new InetSocketAddress(echoClient.ip, echoClient.port)));
                    } else {
                        System.out.println("绑定失败");
                    }
                }
            });
            f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();
        }
    }
}
