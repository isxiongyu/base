package cn.xiongyu.netty.test;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import org.junit.Assert;
import org.junit.Test;

/**
 * ClassName: FixedLengthFrameDecoderTest
 * Description:
 * Create by xiongyu
 * Date: 2020/4/27 10:35 下午
 */
public class FixedLengthFrameDecoderTest {
    @Test
    public void testFramesDecoded() {
        ByteBuf writeBuf = Unpooled.buffer();
        for (int i = 0; i < 9; i++) {
            writeBuf.writeByte(i);
        }
        ByteBuf input = writeBuf.duplicate();
        EmbeddedChannel channel = new EmbeddedChannel(new FixedLengthFrameDecoder(3));
        assert channel.writeInbound(input.retain());
        assert channel.finish();
        ByteBuf read = (ByteBuf) channel.readInbound();
        Assert.assertEquals(writeBuf.readSlice(3), read);
        read.release();
        read = (ByteBuf) channel.readInbound();
        Assert.assertEquals(writeBuf.readSlice(3), read);
        read.release();
        read = (ByteBuf) channel.readInbound();
        Assert.assertEquals(writeBuf.readSlice(3), read);
        read.release();
    }
}
