package ch.epfl.chacun;

import java.util.List;

public record TileDecks(List<Tile> startTiles, List<Tile> normalTiles, List<Tile> menhirTiles) {
    public TileDecks{
        startTiles = List.copyOf(startTiles);
        normalTiles = List.copyOf(normalTiles);
        menhirTiles = List.copyOf(menhirTiles);
    }

    int deckSize(Tile.Kind kind) {
        return switch(kind) {
	case START -> startTiles.size();
	case NORMAL -> normalTiles.size();
	case MENHIR -> menhirTiles.size();
        };
    }
    Tile topTile(Tile.Kind kind){
        return switch(kind) {
	case START -> startTiles.isEmpty() ? null : startTiles.get(startTiles.size() - 1);
	case NORMAL -> normalTiles.isEmpty() ? null : normalTiles.get(normalTiles.size() - 1);
	case MENHIR -> menhirTiles.isEmpty() ? null : menhirTiles.get(menhirTiles.size() - 1);
        };
    }
   //
}
