package mayton.libs.encoders;


import org.apache.commons.io.output.NullOutputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BitOutpuStreamTest {

    @Test
    public void testFlushedStream() throws IOException {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BitOutpuStream bitOutpuStream = new BitOutpuStream(new NullOutputStream());
            bitOutpuStream.writeBit(1);
            bitOutpuStream.flush();
            bitOutpuStream.writeBit(1);
        });
    }

    @Test
    public void testNegativeBit() throws IOException {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BitOutpuStream bitOutpuStream = new BitOutpuStream(new NullOutputStream());
            bitOutpuStream.writeBit(-1);
        });
    }

    @Test
    @Disabled
    public void test() throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        BitOutpuStream bitOutpuStream = new BitOutpuStream(bos);
        bitOutpuStream.writeIntBits(0b111_1111_1111_1111_1111_1111); // 23 bits
        bitOutpuStream.flush();
        byte[] buf = bos.toByteArray();
        assertEquals(8, buf.length);

        // bits   :   aaaaaaa_aaaaaaaa_aaaaaaaa count = 23, free = 32 - 23 = 19
        // Infoblock
        assertEquals((byte) 0b1111_1111, buf[0]);
        assertEquals((byte) 0b1111_1111, buf[1]);
        assertEquals((byte) 0b1111_1110, buf[2]);
        assertEquals((byte) 0b0000_0000, buf[3]);

       /* assertEquals(19, buf[4]);
        assertEquals(19, buf[5]);
        assertEquals(19, buf[6]);
        assertEquals(19, buf[7]);*/

    }

}
