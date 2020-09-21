package mayton.libs.encoders.varint;

import mayton.libs.encoders.CompactDigitOutputStream;

import java.io.IOException;
import java.io.OutputStream;

// TODO: Cover by tests
public class ZigZagVLQOutputStream extends CompactDigitOutputStream {

    private VLQOutputStream vlqOutputStream;

    public ZigZagVLQOutputStream(OutputStream outputStream) {
        super(outputStream);
        vlqOutputStream = new VLQOutputStream(outputStream);
    }

    @Override
    public void writeLong(long v) throws IOException {
        if (v >= 0) {
            vlqOutputStream.writeLong(v * 2);
        } else {
            vlqOutputStream.writeLong(v * 2 + 1);
        }
    }

    @Override
    public void close() throws IOException {
        vlqOutputStream.close();
    }

    @Override
    public void flush() throws IOException {
        vlqOutputStream.flush();
    }
}
