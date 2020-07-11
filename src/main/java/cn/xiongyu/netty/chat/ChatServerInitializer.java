package cn.xiongyu.netty.chat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * ClassName: ChatServerInitializer
 * Description:
 * Create by xiongyu
 * Date: 2020/5/2 6:21 下午
 */
public class ChatServerInitializer extends ChannelInitializer<Channel> {
    private ChannelGroup group;

    public ChatServerInitializer(ChannelGroup group) {
        this.group = group;
    }

    @Override
    protected void initChannel(Channel channel) throws Exception {
        ChannelPipeline cp = channel.pipeline();
        cp.addLast(new HttpServerCodec());
        cp.addLast(new ChunkedWriteHandler());
        cp.addLast(new HttpObjectAggregator(64 * 1024));
        cp.addLast(new HttpRequestHandler("/ws"));
        cp.addLast(new WebSocketServerProtocolHandler("/ws"));
        cp.addLast(new TextWebSocketFrameHandler(group));
    }
}
