package mayton.libs.encoders.varint;

import org.apache.commons.io.input.NullInputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VLQInputStreamTest {

    @Test
    public void testReadEmptyStream() throws IOException {
        VLQInputStream vlqInputStream = new VLQInputStream(new NullInputStream(0));
        assertEquals(-1, vlqInputStream.readLong());
    }

    @Test
    @Disabled
    public void illegalStreamState() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            byte[] buf = new byte[] { (byte) 0xFF };
            VLQInputStream vlqInputStream = new VLQInputStream(new ByteArrayInputStream(buf));
            long res = vlqInputStream.readLong();
        });
    }

    @Test
    public void trivialTest() throws IOException {
        byte[] buf = new byte[] {
                0x00,0x01,0x02,0x04,
                0x08,0x10,0x20,0x40,
                0x7F
        };
        VLQInputStream vlqInputStream = new VLQInputStream(new ByteArrayInputStream(buf));
        assertEquals(0L, vlqInputStream.readLong());
        assertEquals(1L, vlqInputStream.readLong());
        assertEquals(2L, vlqInputStream.readLong());
        assertEquals(4L, vlqInputStream.readLong());

        assertEquals(8L, vlqInputStream.readLong());
        assertEquals(16L, vlqInputStream.readLong());
        assertEquals(32L, vlqInputStream.readLong());
        assertEquals(64L, vlqInputStream.readLong());

        assertEquals(127L, vlqInputStream.readLong());
    }

}
