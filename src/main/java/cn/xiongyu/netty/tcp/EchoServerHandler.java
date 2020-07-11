package cn.xiongyu.netty.tcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;

/**
 * ClassName: EchoServerHandler
 * Description:
 * Create by xiongyu
 * Date: 2020/4/23 8:18 下午
 */
public class EchoServerHandler extends ChannelHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf readBuf = (ByteBuf) msg;
        System.out.println(readBuf.toString(CharsetUtil.UTF_8));
        ByteBuf writeBuf = Unpooled.copiedBuffer("来自服务器的响应".getBytes());
        ctx.writeAndFlush(writeBuf);
        ctx.fireChannelRead(msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}
