package ch.epfl.chacun;

public record Occupant(Kind kind, int zoneId) {
    public enum Kind
    {
        PAWN,
        HUT
    }

    public Occupant
    {
        if(kind == null)
	throw new NullPointerException();
        if(zoneId < 0)
	throw new IllegalArgumentException();
    }

    public static int occupantsCount(Kind kind)
    {
        if(kind == kind.PAWN)
	return 5;
        return 3;
    }
}
