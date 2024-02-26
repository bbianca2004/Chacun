package ch.epfl.chacun;

public record Pos(int x, int y) {
    public static Pos ORIGIN = new Pos(0,0);
    public Pos translated(int dX, int dY)
    {
        return new Pos(x + dX, y + dY);
    }

    public Pos neighbor(Direction direction)
    {
        return switch(direction)
        {
            case N -> translated(0, -1);//nici eu nu inteleg de ce e asa, dar uita te la teste
            case E -> translated(1, 0);
            case W -> translated(-1, 0);
            case S -> translated(0, 1);//acelasi lucru
        };
    }
}
