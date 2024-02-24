package ch.epfl.chacun;

import java.util.List;

public enum Direction {
    N,
    E,
    S,
    W;

    private static Direction[] directionsArray = new Direction [] { N, E, S, W};//dc nu merge, ca sa mearga trebuia pus STATIC
    public final static List<Direction> ALL = List.of(directionsArray);
    public final static int COUNT = ALL.size();

    public Direction rotated(Rotation rotation)
    {
        return ALL.get((this.ordinal() + rotation.quarterTurnsCW()) % COUNT);
    }
    public Direction opposite()
    {
        return ALL.get((this.ordinal() + 2) % COUNT);
    }
}
