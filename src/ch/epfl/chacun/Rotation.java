package ch.epfl.chacun;
import java.util.Arrays;
import java.util.List;

public enum Rotation {
    NONE,
    RIGHT,
    HALF_TURN,
    LEFT;

    private static Rotation[] rotationsArray = new Rotation [] { NONE, RIGHT, HALF_TURN, LEFT};//dc nu merge, ca sa mearga trebuia pus STATIC
    public final static List<Rotation> ALL = List.of(rotationsArray);
    public final static int COUNT = ALL.size();

    public Rotation add(Rotation that)
    {
          int quarter = (this.quarterTurnsCW() + that.quarterTurnsCW()) % COUNT;
          return ALL.get(quarter);//nu cred ca e bine, trb schimbat, dar ALL[quarter]
    }
    public Rotation negated()
    {
        return ALL.get((COUNT - this.ordinal()) % COUNT);//return ALL.get((this.ordinal() + 2) % COUNT);
    }
    public int quarterTurnsCW()
    {
        return this.ordinal();
    }
    public int degreesCW()
    {
        return this.ordinal()  * 90;
    }
}
