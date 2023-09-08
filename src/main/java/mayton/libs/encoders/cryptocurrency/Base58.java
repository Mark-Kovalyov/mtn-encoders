package mayton.libs.encoders.cryptocurrency;

import java.math.BigInteger;
import java.util.*;

public class Base58 {

    private Base58() {

    }

    public static Map<Character, Integer> charsToMap(char[] chars) {
        HashMap<Character, Integer> tempMap = new HashMap<>();
        int n = 0;
        for (char c : BITCOIN_BASE58_ALPHABET) {
            tempMap.put(c, n++);
        }
        return Collections.unmodifiableMap(tempMap);
    }

    public static final char[] BITCOIN_BASE58_ALPHABET = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz".toCharArray();
    public static final char[] RIPPLE_BASE58_ALPHABET  = "rpshnaf39wBUDNEGHJKLM4PQRST7VWXYZ2bcdeCg65jkm8oFqi1tuvAxyz".toCharArray();

    public static Map<Character, Integer> BITCOIN_BASE58_ALPHABET_MAP = charsToMap(BITCOIN_BASE58_ALPHABET);

    public static Map<Character, Integer> RIPPLE_BASE58_ALPHABET_MAP = charsToMap(RIPPLE_BASE58_ALPHABET);

    public static String encodeBitcoin(byte[] code) {
        return "";
    }

    private static Optional<byte[]> decode(String code, Map<Character, Integer> map) {
        BigInteger bigInteger = BigInteger.ZERO;
        BigInteger multiplier = BigInteger.ONE;
        BigInteger MULTIPLIER58 = BigInteger.valueOf(58);
        for(char c: code.toCharArray()) {
            Integer res = map.get(c);
            if (res == null) return Optional.empty();
            bigInteger = bigInteger.add(MULTIPLIER58.multiply(BigInteger.valueOf(res)));
            multiplier = multiplier.multiply(MULTIPLIER58);
        }
        return Optional.of(bigInteger.toByteArray());
    }

    public static boolean containsInKeys(String s, Map<Character, Integer> map) {
        for(char c : s.toCharArray()) {
            if (!map.containsKey(c)) return false;
        }
        return true;
    }

    private static boolean isWalletOf(String code, int length, Map<Character, Integer> map) {
        return code.length() == length && containsInKeys(code, map);
    }

    public static boolean isBitcoinWallet(String code) {
        return isWalletOf(code, 34, BITCOIN_BASE58_ALPHABET_MAP);
    }

    public static Optional<byte[]> decodeRipple(String code) {
        return decode(code, RIPPLE_BASE58_ALPHABET_MAP);
    }

    public static Optional<byte[]> decodeBitcoin(String code) {
        if (code.length() == 0) return Optional.of(new byte[0]);
        return decode(code, BITCOIN_BASE58_ALPHABET_MAP);
    }

}
