package mayton.libs.encoders;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static mayton.libs.encoders.Morze.INTERNATIONAL_ITU;
import static mayton.libs.encoders.Morze.RUSSIAN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MorzeTest {

    @Test
    void testAB() {
        assertEquals(".-", RUSSIAN.get('А'));
        assertEquals("-...", RUSSIAN.get('Б'));
    }

    @Test
    void testEmpty() {
        assertEquals("", Morze.encode(""));
    }

    @Test
    void test_hello_russian() {
        assertEquals(".--. .-. .. .-- . -  .---- ..--- ...--", Morze.encode("Привет 123"));
    }

    @Test
    void test_quick_brown_fox() {
        assertEquals("- .... .  ..- -.-. -.-  -... .-. --- .-- -.  ..-. --- -..-  .--- ..- -- ...  --- ...- . .-.  - .... .  .-.. .- --.. -.--  -.. --- --.", Morze.encode("the quick brown fox jumps over the lazy dog"));
    }

    @Test
    void test_uniq() {
        assertTrue(checkUniqueVal(RUSSIAN.values()));
        assertTrue(checkUniqueVal(INTERNATIONAL_ITU.values()));
    }

    private static boolean checkUniqueVal(Collection<String> strings) {
        Set<String> hs = new HashSet<>();
        for(String s : INTERNATIONAL_ITU.values()) {
            if (!hs.contains(s)) {
                hs.add(s);
            } else {
                System.err.print("Duplicated value " + s);
                return false;
            }
        }
        return true;
    }

}
