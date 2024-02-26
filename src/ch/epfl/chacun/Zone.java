package ch.epfl.chacun;
import java.util.List;
public sealed interface Zone permits Zone.Forest, Zone.Meadow, Zone.Water {
    public static int tileId(int zoneId){
        return zoneId / 10;
    }
    public static int localId(int zoneId){
        return zoneId % 10;
    }

    public abstract int id();

    public default int tileId() {
        return id() / 10;
    }

    public default int localId() {
        return id() % 10;
    }

    public default SpecialPower specialPower()
    {
        return null;
    }
    
    enum SpecialPower{
        SHAMAN,
        LOGBOAT,
        HUNTING_TRAP,
        PIT_TRAP,
        WILD_FIRE,
        RAFT
    }

    public record Forest(int id, Kind kind) implements Zone{
        public enum Kind{
            PLAIN,
            WITH_MENHIR,
            WITH_MUSHROOMS;
        }
        public int id()
        {
            return id;
        }
    }

    public record Meadow(int id, List<Animal> animals, SpecialPower specialPower) implements Zone {
        public Meadow
        {
            animals = List.copyOf(animals);
        }
        public int id()
        {
            return id;
        }

        @Override
        public SpecialPower specialPower() {
            return specialPower;
        }
    }

    public sealed interface Water extends Zone{
        abstract int fishCount();
    }

    public record Lake(int id, int fishCount, SpecialPower specialPower) implements Water
    {
        public int id()
        {
            return id;
        }
        public int fishCount()
        {
            return fishCount;
        }
    }

    public record River(int id, int fishCount, Lake lake) implements Water
    {
        public int id()
        {
            return id;
        }
        public int fishCount()
        {
            return fishCount;
        }
        public boolean hasLake()
        {
            return(lake != null);
        }
    }
}
