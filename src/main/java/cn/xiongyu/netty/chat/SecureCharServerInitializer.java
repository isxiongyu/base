package cn.xiongyu.netty.chat;

import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslHandler;

import javax.net.ssl.SSLEngine;

/**
 * ClassName: SecureCharServerInitializer
 * Description:
 * Create by xiongyu
 * Date: 2020/5/3 1:07 上午
 */
public class SecureCharServerInitializer extends ChatServerInitializer {
    private SslContext sslContext;
    public SecureCharServerInitializer(ChannelGroup group, SslContext sslContext) {
        super(group);
        this.sslContext = sslContext;
    }

    @Override
    protected void initChannel(Channel channel) throws Exception {
        super.initChannel(channel);
        SSLEngine engine = sslContext.newEngine(channel.alloc());
        engine.setUseClientMode(false);
        channel.pipeline().addLast(new SslHandler(engine));
    }
}
