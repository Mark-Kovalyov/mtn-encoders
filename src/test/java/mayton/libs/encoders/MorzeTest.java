package mayton.libs.encoders;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MorzeTest {

    @Test
    void testAB() {
        assertEquals(".-", Morze.MORZE.get('А'));
        assertEquals("-...", Morze.MORZE.get('Б'));
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
        //assertEquals("", Morze.encode("the quick brown fox jumps over the lazy dog"));
    }

}
