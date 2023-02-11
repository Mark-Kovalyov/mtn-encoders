package mayton.libs.encoders.splitterators.lzo;

import java.io.InputStream;

public class LzoIndexer implements AutoCloseable {

    private InputStream inputStream;

    public LzoIndexer(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public void close() throws Exception {

    }
}
