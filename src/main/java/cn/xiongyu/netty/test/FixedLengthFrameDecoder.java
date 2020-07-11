package cn.xiongyu.netty.test;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * ClassName: FixedLengthFrameDecoder
 * Description:
 * Create by xiongyu
 * Date: 2020/4/27 10:31 下午
 */
public class FixedLengthFrameDecoder extends ByteToMessageDecoder {
    private int len;
    public FixedLengthFrameDecoder(int len) {
        this.len = len;
    }
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        while (byteBuf.readableBytes() >= len) {
            ByteBuf buf = byteBuf.readBytes(len);
            list.add(buf);
        }
    }
}
