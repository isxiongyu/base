package cn.xiongyu.netty.chat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.util.SelfSignedCertificate;

import java.net.InetSocketAddress;

/**
 * ClassName: SecureChatServer
 * Description:
 * Create by xiongyu
 * Date: 2020/5/3 12:37 上午
 */
public class SecureChatServer extends ChatServer {
    private SslContext context;

    public SecureChatServer(SslContext context) {
        this.context = context;
    }

    @Override
    public ChannelInitializer<Channel> creatInitializer(ChannelGroup group) {
        return new SecureCharServerInitializer(group, context);
    }

    public static void main(String[] args) throws Exception {
        int port = 54321;
        SelfSignedCertificate certificate = new SelfSignedCertificate();
        SslContext context = SslContext.newServerContext(certificate.certificate(), certificate.privateKey());
        SecureChatServer server = new SecureChatServer(context);
        ChannelFuture future = server.start(new InetSocketAddress(port));
        Runtime.getRuntime().addShutdownHook(new Thread(server::destroy));
        future.channel().closeFuture().syncUninterruptibly();
    }

}
