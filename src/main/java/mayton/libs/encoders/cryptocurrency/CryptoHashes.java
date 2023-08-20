package mayton.libs.encoders.cryptocurrency;

public class CryptoHashes {

    public static boolean containsBase64Set(String s) {
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c) || !(c >= 'a' && c <= 'z') || !(c >= 'A' && c <= 'Z') || c!='+' || c!='/' || c !='=') return false;
        }
        return true;
    }

    public static boolean containsBinHexOnly(String s) {
        for (char c : s.toLowerCase().toCharArray()) {
            if (!Character.isDigit(c) || !(c >= 'a' && c <= 'f')) return false;
        }
        return true;
    }

}
