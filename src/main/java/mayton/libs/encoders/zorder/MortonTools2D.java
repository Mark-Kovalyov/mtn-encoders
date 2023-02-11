package mayton.libs.encoders.zorder;

public class MortonTools2D {

    static int x[] = {0b000000, 0b000001, 0b000100, 0b000101, 0b010000, 0b010001, 0b010100, 0b010101};

    public static int encode(int xx, int yy) {
        return xx | yy;
    }

}
