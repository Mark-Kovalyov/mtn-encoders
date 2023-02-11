package mayton.libs.encoders.bcd;

import mayton.libs.encoders.CompactDigitInputStream;

import java.io.IOException;
import java.io.InputStream;

public class BcdInputStream extends CompactDigitInputStream {

    public BcdInputStream(InputStream inputStream) {
        super(inputStream);
    }

    @Override
    public long readLong() throws IOException {
        return 0;
    }
}
