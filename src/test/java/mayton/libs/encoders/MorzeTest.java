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
    void testHello() {
        assertEquals(".--. .-. .. .-- . -  .---- ..--- ...--", Morze.encode("Привет 123"));
    }

}
