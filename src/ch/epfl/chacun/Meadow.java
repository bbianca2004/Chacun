package ch.epfl.chacun;
import java.util.List;
import java.util.ArrayList;

public record Meadow(int id, List<Animal> animals, SpecialPower specialPower) implements Zone{

    public Meadow(int id, ArrayList<Animal> animals, SpecialPower specialPower)
    {
        this.id = id;
        animals = List.copyOf(animals);
    }
}
