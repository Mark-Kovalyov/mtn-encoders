package mayton.libs.encoders;

import mayton.libs.encoders.hashfunctions.Tiger;
import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

public class Hashes {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public static ThreadLocal<MessageDigest> md5tl = ThreadLocal.withInitial(() -> {
        try {
            return MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            System.err.println(e.getMessage());
            return null;
        }
    });

    public static ThreadLocal<MessageDigest> md4tl = ThreadLocal.withInitial(() -> {
        try {
            return MessageDigest.getInstance("MD4");
        } catch (NoSuchAlgorithmException e) {
            System.err.println(e.getMessage());
            return null;
        }
    });

    public static ThreadLocal<MessageDigest> sha256tl = ThreadLocal.withInitial(() -> {
        try {
            return MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            System.err.println(e.getMessage());
            return null;
        }
    });

    public static ThreadLocal<MessageDigest> sha1tl = ThreadLocal.withInitial(() -> {
        try {
            return MessageDigest.getInstance("SHA1");
        } catch (NoSuchAlgorithmException e) {
            System.err.println(e.getMessage());
            return null;
        }
    });

    // xt=urn:ed2k:<md5>
    //
    // the only files less than 9 728 000 bytes size!
    public static String md4(byte[] arr) {
        MessageDigest messageDigest = md4tl.get();
        messageDigest.reset();
        messageDigest.update(arr);
        return Hex.encodeHexString(messageDigest.digest());
    }

    public static String tiger(byte[] arr) {
        Tiger tiger = new Tiger();
        return Hex.encodeHexString(tiger.computeHash(arr));
    }

    public static String md5(byte[] arr) {
        MessageDigest messageDigest = md5tl.get();
        messageDigest.reset();
        messageDigest.update(arr);
        return Hex.encodeHexString(messageDigest.digest());
    }

    public static String sha256(byte[] arr) {
        MessageDigest messageDigest = sha256tl.get();
        messageDigest.reset();
        messageDigest.update(arr);
        return Hex.encodeHexString(messageDigest.digest());
    }

    // xt=urn:sha1:<sha1>
    public static String sha1(byte[] arr) {
        MessageDigest messageDigest = sha1tl.get();
        messageDigest.reset();
        messageDigest.update(arr);
        return Hex.encodeHexString(messageDigest.digest());
    }


}
