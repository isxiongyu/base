package cn.xiongyu.netty.udpBroadCaster;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * ClassName: LogEventHandler
 * Description:
 * Create by xiongyu
 * Date: 2020/5/3 6:39 下午
 */
public class LogEventHandler extends SimpleChannelInboundHandler<LogEvent> {
    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, LogEvent logEvent) throws Exception {
        System.out.println(logEvent);
    }
}
