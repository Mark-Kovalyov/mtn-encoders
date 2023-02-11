package mayton.libs.encoders.qrcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WifiQrCodeTest {

    @Test
    public void test() {
        WifiQrCode wifiQrCode = new WifiQrCode.Builder()
                .networkName("skyNet")
                .encryption(WifiQrCode.Encryption.WPA_WPA2)
                .hidden(true)
                .pwd("superSky123").build();

        assertEquals("WIFI:S:skyNet;P:superSky123;T:WPA/WPA2;H:Y;", wifiQrCode.toString());

    }

}
