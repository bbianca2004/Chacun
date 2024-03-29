package ch.epfl.chacun;

import java.util.List;

public sealed interface TileSide {
    public abstract List<Zone> zones();
    public abstract boolean isSameKindAs(TileSide that);

    public record Forest(Zone.Forest forest) implements TileSide{

        @Override
        public List<Zone> zones() {
	return List.of(forest);//is this right?
        }

        @Override
        public boolean isSameKindAs(TileSide that) {
	return (this.getClass() == that.getClass());
        }
    }

    public record Meadow(Zone.Meadow meadow) implements TileSide{

        @Override
        public List<Zone> zones() {
	return List.of(meadow);
        }

        @Override
        public boolean isSameKindAs(TileSide that) {
	return (this.getClass() == that.getClass());
        }
    }

    public record River(Zone.Meadow meadow1, Zone.River river, Zone.Meadow meadow2) implements TileSide{
        public List<Zone> zones() {
	return List.of(meadow1, river, meadow2);
        }

        @Override
        public boolean isSameKindAs(TileSide that) {
	return (this.getClass() == that.getClass());
        }
    }
}
