package ch.epfl.chacun;

public non-sealed class River implements Zone{
    private int id;
    private Kind kind;

    public River(int id, Kind kind)
    {
        this.id = id;
        this.kind = kind;
    }
    @Override
    public int id() {
        return id;
    }

    enum Kind{
        PLAIN,
        WITH_MENHIR,
        WITH_MUSHROOMS
    }
}
