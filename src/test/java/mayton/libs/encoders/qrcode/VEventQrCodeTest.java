package mayton.libs.encoders.qrcode;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VEventQrCodeTest {

    @Test
    @Disabled
    public void test() {
        VEventQrCode vEventQrCode = new VEventQrCode.Builder()
                .summary("Воркшоп «Dashboard`ы на Python»")
                .location("Киев, ул. Попудренка, 1А, Коворкинг The Spaces ")
                .desc("Сергей Андреев, Data Scientist в MyCredit, проведет бесплатный воркшоп.")
                .dtStart(LocalDateTime.now())
                .dtEnd(LocalDateTime.now())
                .build();

        assertEquals("", vEventQrCode.toString());
    }

}
