package mayton.libs.encoders;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Morze {

    public static final Map<Character, String> MORZE = Collections.unmodifiableMap(new HashMap<>() {{
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
            } else if (MORZE.containsKey(c)) {
                if (!isFirst) sb.append(' ');
                sb.append(MORZE.get(c));
            }
            isFirst = false;
        }
        return sb.toString();
    }

}
