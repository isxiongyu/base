package cn.xiongyu.netty.udp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;


/**
 * ClassName: EchoServerHandler
 * Description:
 * Create by xiongyu
 * Date: 2020/4/23 8:18 下午
 */
public class EchoServerHandler extends SimpleChannelInboundHandler<DatagramPacket> {

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, DatagramPacket datagramPacket) throws Exception {
        ByteBuf readBuf = datagramPacket.content();
        System.out.println(readBuf.toString(CharsetUtil.UTF_8));
        ByteBuf writeBuf = Unpooled.copiedBuffer("来自服务器的响应".getBytes());
        ctx.writeAndFlush(new DatagramPacket(writeBuf, datagramPacket.sender()));
    }
}
