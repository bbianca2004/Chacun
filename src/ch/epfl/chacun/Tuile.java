package ch.epfl.chacun;

public class Tuile {
    protected int IDnumber;
    public Tuile(int IDnumber)
    {
        this.IDnumber = IDnumber;
    }
}

class TuileDepart extends Tuile {
    public TuileDepart(int IDnumber)
    {
        super(IDnumber);
    }
}

class TuileNormal extends Tuile {
    public TuileNormal(int IDnumber)
    {
        super(IDnumber);
    }
}

class TuileMenhir extends Tuile {
    public TuileMenhir(int IDnumber)
    {
        super(IDnumber);
    }
}
