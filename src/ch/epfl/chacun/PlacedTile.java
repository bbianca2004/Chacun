package ch.epfl.chacun;
import java.util.HashSet;
import java.util.Set;

import static ch.epfl.chacun.Preconditions.checkArgument;
import static ch.epfl.chacun.Tile.Kind.START;

public record PlacedTile(Tile tile, PlayerColor placer, Rotation rotation, Pos pos, Occupant occupant) {
    public PlacedTile{
        checkArgument(tile != null && pos != null && rotation != null);
    }

    int id() {
        return tile.id();//e ok sa fac asa
    }
    Tile.Kind kind(){
        return tile.kind();
    }
    //TileSide side(Direction direction) {

    //}
    Zone zoneWithId(int id){
        Set<Zone> TileZones = new HashSet<>(tile.zones());
        for(Zone zone: TileZones)
        {
            if(zone.localId() == id)
                return zone;
        }
        throw new IllegalArgumentException();//??
    }
    Zone specialPowerZone(){
        Set<Zone> TileZones = new HashSet<>(tile.zones());
        for(Zone zone: TileZones)
        {
            if(zone.specialPower() != null)
                return zone;
        }
        return null;
    }
    Set<Zone.Forest> forestZones() {
        Set<Zone.Forest> ForestZones = new HashSet<>();
        Set<Zone> TileZones = new HashSet<>(tile.zones());
        for(Zone zone: TileZones)
        {
            if(zone instanceof Zone.Forest forest)
                ForestZones.add(forest);
        }
        return ForestZones;
    }
    Set<Zone.Meadow> meadowZones(){
        Set<Zone.Meadow> MeadowZones = new HashSet<>();
        Set<Zone> TileZones = new HashSet<>(tile.zones());
        for(Zone zone: TileZones)
        {
            if(zone instanceof Zone.Meadow meadow)
                MeadowZones.add(meadow);
        }
        return MeadowZones;
    }
    Set<Zone.River> riverZones(){
        Set<Zone.River> RiverZones = new HashSet<>();
        Set<Zone> TileZones = new HashSet<>(tile.zones());
        for(Zone zone: TileZones)
        {
            if(zone instanceof Zone.River river)
                RiverZones.add(river);
        }
        return RiverZones;
    }
    Set<Occupant> potentialOccupants() {
        Set<Occupant> potentialOccupants = new HashSet<>();
        if(kind().equals(START))
            return potentialOccupants;
        else {
            Set<Zone> TileZones = new HashSet<>(tile.zones());
            for(Zone zone: TileZones) {
                if (zone instanceof Zone.River river)
                {
                    potentialOccupants.add(new Occupant(Occupant.Kind.PAWN, river.id()));
                    if (!river.hasLake())
                        potentialOccupants.add(new Occupant(Occupant.Kind.HUT, river.id()));
                }
                else if(zone instanceof Zone.Meadow meadow)
                    potentialOccupants.add(new Occupant(Occupant.Kind.HUT, meadow.id()));
                else if(zone instanceof Zone.Lake lake)
                    potentialOccupants.add(new Occupant(Occupant.Kind.HUT, lake.id()));//de rescris cu sideZones()
            }
        }
        return potentialOccupants;
    }
    PlacedTile withOccupant(Occupant occupant){
        if(this.occupant !=  null)
            throw new IllegalArgumentException();
        else {
            return new PlacedTile(tile, placer, rotation, pos, occupant);
        }
    }
    PlacedTile withNoOccupant() {
        return new PlacedTile(tile, placer, rotation, pos, null);
    }
    int idOfZoneOccupiedBy(Occupant.Kind occupantKind) {
        if(occupantKind != occupant.kind()  || occupant == null)
            return -1;
        return occupant.zoneId();
    }
}
