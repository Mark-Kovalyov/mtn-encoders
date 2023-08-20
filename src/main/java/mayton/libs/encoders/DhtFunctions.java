package mayton.libs.encoders;

import mayton.libs.encoders.hashfunctions.Tiger;
import org.apache.commons.codec.binary.Hex;

import java.util.Optional;

public class DhtFunctions {

    // xt=urn:ed2k:[ ed2k хеш  файла (Hex) ]
    //
    public static Optional<String> ed2kHash(byte[] arr)  {
        if (arr.length > 16 * 1024 * 1024) {
            // TODO:
            return Optional.empty();
        }
        return Optional.of(Hashes.md4(arr));
    }

    // Это последовательная запись хеша SHA-1 и TTH, разделённых точкой. Хеш используется в Gnutella2.
    // Direct Connect использует только TTH часть BitPrint
    //
    // xt=urn:bitprint:<SHA1.TTH>
    public static Optional<String> bitPrint(byte[] arr) {
        return Optional.of(sha1(arr).get() + "." + treeTiger(arr).get());
    }

    // xt=urn:aich:[ aich хеш  файла (Base32) ]
    public static Optional<String> aich(byte[] arr)  {
        // TODO: See the rhash utility
        return Optional.empty();
    }

    // xt=urn:btih:<btih>
    public static Optional<String> btih(byte[] arr)  {
        // TODO:
        return Optional.empty();
    }

    // urn:tree:tiger:<treetiger>  (base32)
    public static Optional<String> treeTiger(byte[] arr)  {
        return Optional.of(Hashes.tiger(arr));
    }

    // xt=urn:md5:<md5>
    public static Optional<String> md5(byte[] arr) {
        return Optional.of(Hashes.md5(arr));
    }

    // xt=urn:sha1:<sha1>
    public static Optional<String> sha1(byte[] arr) {
        return Optional.of(Hashes.sha1(arr));
    }

}
