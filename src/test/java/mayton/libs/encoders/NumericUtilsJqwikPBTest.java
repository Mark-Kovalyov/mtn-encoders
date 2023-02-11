package mayton.libs.encoders;

import net.jqwik.api.*;

public class NumericUtilsJqwikPBTest {

    @Property
    public boolean negativeTestDetectWidthInBits(@ForAll("PositiveNumbers") int i) {
        return NumericUtils.detectWidthInBits(i) > 0;
    }

    @Provide("PositiveNumbers")
    public Arbitrary<Integer> integerArbitraries() {
        return Arbitraries.integers().between(1, Integer.MAX_VALUE);
    }

}
