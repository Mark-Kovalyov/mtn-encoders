package mayton.libs.encoders;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HashesTest {


    @Test
    void testMd4() {
        assertEquals("1bee69a46ba811185c194762abaeae90", Hashes.md4("The quick brown fox jumps over the lazy dog".getBytes()));
    }

    @Test
    void testMd5() {
       assertEquals("9e107d9d372bb6826bd81d3542a419d6", Hashes.md5("The quick brown fox jumps over the lazy dog".getBytes()));
    }

    @Test
    void testSha1() {
        assertEquals("2fd4e1c67a2d28fced849ee1bb76e7391b93eb12", Hashes.sha1("The quick brown fox jumps over the lazy dog".getBytes()));
    }

    @Test
    void testSha256() {
        assertEquals("d7a8fbb307d7809469ca9abcb0082e4f8d5651e46d3cdb762d02d0bf37c9e592", Hashes.sha256("The quick brown fox jumps over the lazy dog".getBytes()));
    }
}
