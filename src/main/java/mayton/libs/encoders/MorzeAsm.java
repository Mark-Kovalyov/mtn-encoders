package mayton.libs.encoders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static mayton.libs.encoders.Morze.INTERNATIONAL_ITU;
import static mayton.libs.encoders.Morze.RUSSIAN;

public class MorzeAsm {

    static long detectLen(String code) {
        int cnt = 0;
        for(char c : code.toCharArray()) {
            switch (c) {
                case '.' : cnt++; break;
                case '-' : cnt+=3; break;
            }
        }
        return cnt + code.length() - 1;
    }

    static long upgradeCode(long code, char c) {
        if (c == '-') {
            code <<= 3;
            code |= 0x7;
        } else if (c == '.') {
            code <<= 1;
            code |= 0x1;
        }
        code <<= 1;
        return code;
    }

    public static void main(String[] args) {
        List<Map.Entry<Character,String>> compose = new ArrayList<>();
        compose.addAll(INTERNATIONAL_ITU.entrySet());
        compose.addAll(RUSSIAN.entrySet());
        System.out.println("morze_codes db");
        for(Map.Entry<Character,String> item : compose) {
            long morzeCode = 0x0;
            Character key = item.getKey();
            String val = item.getValue();
            for(char c : val.toCharArray()) {
                morzeCode = upgradeCode(morzeCode, c);
            }
            //System.out.printf("%08Xh,", morzeCode);
            System.out.printf("%d,", detectLen(val));
        }
    }

}
