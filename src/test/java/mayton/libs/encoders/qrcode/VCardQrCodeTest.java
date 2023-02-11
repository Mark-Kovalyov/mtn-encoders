package mayton.libs.encoders.qrcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VCardQrCodeTest {

    // BEGIN:VCARD
    // VERSION:3.0
    // N:Sname;Name
    // FN:Name Sname
    // ORG:Organization
    // TITLE:JobTitle
    // ADR:;;Street;CIty;State;12345;Country
    // TEL;
    // WORK;
    // VOICE:MainPhone TEL;
    // CELL:Mobile TEL;
    // FAX:Fax EMAIL;WORK;
    // INTERNET:you@mail.com
    // URL:www.site.com
    // END:VCARD

    @Test
    public void test() {
        VCardQrCode vCardQrCode = new VCardQrCode.Builder()
                .n("Arnold")
                .fn("Shartzennegger")
                .org("Hollywood")
                .title("film actor")
                .adr("Log-Angelos;Hollywood;1st street")
                .fax("+1 (209) 55-55-55")
                .tel("+1 (209) 77-77-77")
                .email("schwarzenegger@gmail.com")
                .url("http://www.schwarzenegger.com/")
                .build();

        assertEquals(
                "BEGIN:VCARD\n" +
                "VERSION:3.0\n" +
                "N:Arnold;\n" +
                "FN:Shartzennegger;\n" +
                "ORG:Hollywood;\n" +
                "TITLE:film actor;\n" +
                "ADR:Log-Angelos;Hollywood;1st street;\n" +
                "TEL:+1 (209) 77-77-77;\n" +
                "FAX:+1 (209) 55-55-55EMAIL;WORK;\n" +
                "URL:http://www.schwarzenegger.com/;\n" +
                "END:VCARD\n", vCardQrCode.toString());
    }

}
