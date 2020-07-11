package cn.xiongyu.netty.udpBroadCaster;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;
import java.util.List;

/**
 * ClassName: LogEventEncoder
 * Description:
 * Create by xiongyu
 * Date: 2020/5/3 4:41 下午
 */
public class LogEventEncoder extends MessageToMessageEncoder<LogEvent> {

    private final InetSocketAddress remoteAddress;

    public LogEventEncoder(InetSocketAddress remoteAddress) {
        this.remoteAddress = remoteAddress;
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, LogEvent msg, List<Object> out) throws Exception {
        // 将消息内容转为byte类型存储，以待传入byteBuf
        byte[] file = msg.getLogfile().getBytes(CharsetUtil.UTF_8);
        byte[] message = msg.getMsg().getBytes(CharsetUtil.UTF_8);

        ByteBuf byteBuf = ctx.alloc().buffer(file.length+message.length+1);// 分配byteBuf的内存

        byteBuf.writeBytes(file);// 将file内容写入byteBuf
        byteBuf.writeByte(LogEvent.SEPARATOR);// 写入指定的分隔符
        byteBuf.writeBytes(message);
        out.add(new DatagramPacket(byteBuf, remoteAddress));// 将datagrampacket写入out列，进行处理
    }
}
