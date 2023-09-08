package mayton.libs.encoders.cryptocurrency;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import mayton.libs.encoders.fibonacci.FibonacciUtils;
import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.ForAll;
import net.jqwik.api.Provide;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitQuickcheck.class)
public class Base58Property {

    @Property
    public boolean base58_must_correctly_encode_and_decode(@ForAll("RandomByteArrays") byte[] arr) {
        Optional<byte[]> decoded = Base58.decodeBitcoin(Base58.encodeBitcoin(arr));
        return decoded.isPresent() && Arrays.equals(decoded.get(), arr);
    }

    @Provide("RandomByteArrays")
    public Arbitrary<byte[]> byteArrays() {
        return Arbitraries.create(() -> randomLongArraySupplier(120));
    }

    static Random random = new Random();

    private byte[] randomLongArraySupplier(int maxSize) {
        int randomSize = random.nextInt(maxSize);
        byte[] testData = new byte[randomSize];
        for (int i = 0; i < randomSize; i++) {
            testData[i] = (byte) random.nextInt(256);
        }
        return testData;
    }

}
