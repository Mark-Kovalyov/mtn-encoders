package mayton.libs.encoders;

import org.apache.commons.codec.digest.MurmurHash2;
import org.apache.commons.codec.digest.MurmurHash3;

import java.nio.charset.StandardCharsets;

public class MurmurHashTest {

    public static void main(String[] args) {

        String[] testdata = { "1", "hello", "The quick brown fox jumps over the lazy dog", "abc", "1993", "Java", "ZigLang" };

        for(String str : testdata) {
            byte[] data = str.getBytes(StandardCharsets.UTF_8);
            long hash2_64 = MurmurHash2.hash64(data, data.length);
        }
    }

}
