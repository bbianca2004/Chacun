package ch.epfl.chacun;
import java.util.Arrays;
import java.util.List;
public enum PlayerColor {
    RED,
    BLUE,
    GREEN,
    YELLOW,
    PURPLE;

    private static PlayerColor[] colorsArray = new PlayerColor [] { RED, BLUE, GREEN, YELLOW, PURPLE};//dc nu merge, ca sa mearga trebuia pus STATIC
    public final static List<PlayerColor> ALL = List.of(colorsArray);
}
