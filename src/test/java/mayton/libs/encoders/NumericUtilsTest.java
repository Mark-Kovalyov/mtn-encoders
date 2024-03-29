package mayton.libs.encoders;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumericUtilsTest {

    @Test
    public void negativeTestDetectWidthInBits() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            NumericUtils.detectWidthInBits(-1);
        });
    }

    @Test
    public void testDetectWidthInBits() {
        assertEquals(0, NumericUtils.detectWidthInBits(0));
        assertEquals(1, NumericUtils.detectWidthInBits(0b0000_0001));
        assertEquals(2, NumericUtils.detectWidthInBits(0b0000_0010));
        assertEquals(2, NumericUtils.detectWidthInBits(0b0000_0011));
        assertEquals(8, NumericUtils.detectWidthInBits(0b1000_0000));

        assertEquals(16, NumericUtils.detectWidthInBits(0b1000_0000_1000_0000));
        assertEquals(24, NumericUtils.detectWidthInBits(0b1000_0000_1000_0000_1000_0000));
        assertEquals(31, NumericUtils.detectWidthInBits(0b0100_0000_1000_0000_1000_0000_1000_0000));
    }

}
