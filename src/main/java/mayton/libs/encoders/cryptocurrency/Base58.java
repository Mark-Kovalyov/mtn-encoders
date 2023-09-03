package mayton.libs.encoders.cryptocurrency;

import java.util.Optional;

public class Base58 {

    private Base58() {}

    public static final char[] BITCOIN_BASE58_ALPHABET = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz".toCharArray();
    public static final char[] BITCOIN_BASE58_RIPPLE   = "rpshnaf39wBUDNEGHJKLM4PQRST7VWXYZ2bcdeCg65jkm8oFqi1tuvAxyz".toCharArray();

    public static String encodeBitcoin(byte[] code) {
        return "";
    }

    public static Optional<byte[]> decodeBitcoin(String code) {
        return Optional.of(new byte[0]);
    }

}
