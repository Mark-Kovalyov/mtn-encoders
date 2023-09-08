package mayton.libs.encoders.varint;

import net.jqwik.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

class VLQPropertyTest {

    private Random r = new Random();

    @Property(tries = 1)
    public boolean vlqStreamSizeAlwaysEncodedDecodedCorrectly(@ForAll("PositiveNumbers") long[] longs) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        VLQOutputStream vlqOutputStream = new VLQOutputStream(bos);
        for(int i = 0; i < longs.length; i++) {
            vlqOutputStream.writeLong(longs[i]);
        }
        vlqOutputStream.flush();
        byte[] buf = bos.toByteArray();
        VLQInputStream vlqInputStream = new VLQInputStream(new ByteArrayInputStream(buf));
        int k = 0;
        while(vlqInputStream.readLong() >= 0) {
            k++;
        }
        return k == longs.length;
    }

    @Property(tries = 2)
    public boolean vlqStreamAlwaysEncodedDecodedCorrectly(@ForAll("PositiveNumbers") long[] longs) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        VLQOutputStream vlqOutputStream = new VLQOutputStream(bos);
        for(int i = 0; i < longs.length; i++) {
            vlqOutputStream.writeLong(longs[i]);
        }
        vlqOutputStream.flush();
        byte[] buf = bos.toByteArray();
        VLQInputStream vlqInputStream = new VLQInputStream(new ByteArrayInputStream(buf));
        long res = 0;
        int k = 0;
        while((res = vlqInputStream.readLong()) >= 0) {
            if (res != longs[k]) {
                return false;
            }
            k++;
        }
        return true;
    }

    @Provide("PositiveNumbers")
    public Arbitrary<long[]> integerArbitraries() {
        return Arbitraries.create(() -> randomLongArraySupplier(268_435_455, 1000));
    }

    private long[] randomLongArraySupplier(int amplitude, int cnt) {
        long[] testData = new long[cnt];
        for (int i = 0; i < cnt; i++) {
            testData[i] = r.nextInt(amplitude);
        }
        return testData;
    }

    public void test() throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        VLQOutputStream vlqOutputStream = new VLQOutputStream(bos);

        List<Long> testData = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            // 268_435_455
            long testValue = (long) r.nextInt(268_435_455);
            testData.add(testValue);
            vlqOutputStream.writeLong(testValue);
        }
        vlqOutputStream.flush();

        byte[] buf = bos.toByteArray();

        System.out.println("The size is " + buf.length);

        VLQInputStream vlqInputStream = new VLQInputStream(new ByteArrayInputStream(buf));
        for(long testValue : testData) {
            assertEquals(testValue, vlqInputStream.readLong());
        }
        vlqInputStream.close();
    }

}
