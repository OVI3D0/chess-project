package com.chess.engine.board;
import com.chess.engine.pieces.Piece;
import com.google.common.collect.ImmutableMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Tile class
// Needs a coordinate
public abstract class Tile {

    protected final int tileCoordinate;

    private static final Map<Integer, emptyTile> EMPTY_TILES_CACHE = createAllPossibleEmptyTiles();

    private static Map<Integer, emptyTile> createAllPossibleEmptyTiles() {
        final Map<Integer, emptyTile> emptyTileMap = new HashMap<>();

        for(int i = 0; i < 64; i++) {
            emptyTileMap.put(i, new emptyTile(i));
        }

        // returns map that cannot be modified afterwards
        return ImmutableMap.copyOf(emptyTileMap);
    }

    public static Tile createTile(final int tileCoordinate, final Piece piece) {
        return piece != null ? new occupiedTile(tileCoordinate, piece) : EMPTY_TILES_CACHE.get(tileCoordinate);
    }

    // constructor
    // sets coordinate
    private Tile(int tileCoordinate) {
        this.tileCoordinate = tileCoordinate;
    }

    public abstract boolean isTileOccupied();
    public abstract Piece getPiece();

    public static final class emptyTile extends Tile {
        emptyTile(final int coordinate) {
            super(coordinate);
        }

        // an empty tile by definition should not return occupied or any piece
        @Override
        public boolean isTileOccupied() {
            return false;
        }

        @Override
        public Piece getPiece() {
            return null;
        }
    }

    public static final class occupiedTile extends Tile {
        private final Piece pieceOnTile;

        private occupiedTile(int coordinate, Piece pieceOntile) {
            super(coordinate);
            this.pieceOnTile = pieceOntile;
        }

        @Override
        public boolean isTileOccupied() {
            return true;
        }

        @Override
        public Piece getPiece() {
            return this.pieceOnTile;
        }
    }

}
