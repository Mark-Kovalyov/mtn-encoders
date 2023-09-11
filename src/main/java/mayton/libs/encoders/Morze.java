package mayton.libs.encoders;

import java.util.*;

public class Morze {

    public static final Map<Character, String> INTERNATIONAL_ITU = Collections.unmodifiableMap(new LinkedHashMap<>() {{
        put('A',".-");
        put('B',"-...");
        put('C',"-.-.");
        put('D',"-..");

        put('E',".");
        put('F',"..-.");
        put('G',"--.");
        put('H',"....");

        put('J',".---");
        put('K',"-.-");
        put('L',".-..");

        put('M',"--");
        put('N',"-.");

        put('O',"---");
        put('R',".-.");
        put('S',"...");
        put('T',"-");

        put('U',"..-");
        put('V',"...-");
        put('W',".--");

        put('X',"-..-");
        put('Y',"-.--");
        put('Z',"--..");
    }});

    public static final Map<Character, String> RUSSIAN = Collections.unmodifiableMap(new LinkedHashMap<>() {{
        put('А',".-");
        put('Б',"-...");
        put('В',".--");
        put('Г',"--.");
        put('Д',"-..");
        put('Е',".");
        put('Ё',".");
        put('Ж',"...-");
        put('З',"--..");
        put('И',"..");
        put('Й',".---");
        put('К',"-.-");
        put('Л',".-..");
        put('М',"--");
        put('Н',"-.");
        put('О',"---");
        put('П',".--.");
        put('Р',".-.");
        put('С',"...");
        put('Т',"-");
        put('У',"..-");
        put('Ф',"..-.");
        put('Х',"....");
        put('Ц',"-.-.");
        put('Ч',"---.");
        put('Ш',"----");
        put('Щ',"--.-");
        put('Ъ',"--.--");
        put('Ы',"-.--");
        put('Ь',"-..-");
        put('Э',"..-..");
        put('Ю',"..--");
        put('Я',".-.-");

        put('0',"-----");
        put('1',".----");
        put('2',"..---");
        put('3',"...--");
        put('4',"....-");
        put('5',".....");
        put('6',"-....");
        put('7',"--...");
        put('8',"---..");
        put('9',"----.");
    }});



    public static String encode(String text) {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        for(char c : text.toUpperCase().toCharArray()) {
            if (c == ' ') {
                sb.append(' ');
            } else if (RUSSIAN.containsKey(c)) {
                if (!isFirst) sb.append(' ');
                sb.append(RUSSIAN.get(c));
            } else if (INTERNATIONAL_ITU.containsKey(c)) {
                if (!isFirst) sb.append(' ');
                sb.append(INTERNATIONAL_ITU.get(c));
            }
            isFirst = false;
        }
        return sb.toString();
    }

}
