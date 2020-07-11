package cn.xiongyu.netty.udpBroadCaster;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.CharsetUtil;

import java.util.List;

/**
 * ClassName: LogEventDecoder
 * Description:
 * Create by xiongyu
 * Date: 2020/5/3 6:12 下午
 */
public class LogEventDecoder extends MessageToMessageDecoder<DatagramPacket> {

    @Override
    protected void decode(ChannelHandlerContext ctx, DatagramPacket packet, List<Object> out) throws Exception {
        ByteBuf byteBuf = packet.content();// 消息包的内容存入byteBuf中
        // 获取分隔符的索引，便于分割bytebuf为两部分
        int idx = byteBuf.indexOf(0, byteBuf.readableBytes(), LogEvent.SEPARATOR);
        // 将bytebuf转化为两部分的String类型
        String logfile = byteBuf.slice(0, idx).toString(CharsetUtil.UTF_8);// 提取文件名
        String message = byteBuf.slice(idx + 1, byteBuf.readableBytes() - idx - 1).toString(CharsetUtil.UTF_8);
        // 转化为LogEvent类型
        LogEvent event = new LogEvent(packet.sender(), System.currentTimeMillis(), logfile, message);
        out.add(event);
    }
}
