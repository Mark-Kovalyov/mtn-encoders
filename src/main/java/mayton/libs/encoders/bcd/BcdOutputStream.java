package mayton.libs.encoders.bcd;

import mayton.libs.encoders.CompactDigitOutputStream;

import java.io.IOException;
import java.io.OutputStream;

public class BcdOutputStream extends CompactDigitOutputStream {

    public BcdOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    @Override
    public void writeLong(long v) throws IOException {

    }
}
