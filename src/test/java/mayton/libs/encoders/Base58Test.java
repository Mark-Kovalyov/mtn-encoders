package mayton.libs.encoders;

import mayton.libs.encoders.cryptocurrency.Base58;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class Base58Test {

    @Test
    void encode_empty() {
        assertEquals("", Base58.encodeBitcoin(new byte[0]));
    }

    @Test
    void decode_empty() {
        assertArrayEquals(new byte[0], Base58.decodeBitcoin("").get());
    }

    @Test
    @Disabled
    void encode_test() {
        assertEquals("2NEpo7TZRRrLZSi2U",
                Base58.encodeBitcoin("Hello World!".getBytes()));
        assertEquals("USm3fpXnKG5EUBx2ndxBDMPVciP5hGey2Jh4NDv6gmeo1LkMeiKrLJUUBk6Z",
                Base58.encodeBitcoin("The quick brown fox jumps over the lazy dog.".getBytes()));
    }

    @Test
    @Disabled
    void decode_satoshi_nakamoto_address() throws DecoderException {
        Optional<byte[]> res = Base58.decodeBitcoin("1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa");
        assertTrue(res.isPresent());
        assertArrayEquals(Hex.decodeHex("0062e907b15cbf27d5425399ebf6f0fb50ebb88f18c29b7d93"), res.get());
    }

    @Test
    @Disabled
    void encode_satoshi_nakamoto_address() throws DecoderException {
        byte[] hex = Hex.decodeHex("0062e907b15cbf27d5425399ebf6f0fb50ebb88f18c29b7d93");
        assertEquals("1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa", Base58.encodeBitcoin(hex));
    }

}
