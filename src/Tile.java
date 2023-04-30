// Tile class
// Needs a coordinate
public abstract class Tile {

    int tileCoordinate;
    // constructor
    // sets coordinate
    Tile(int tileCoordinate) {
        this.tileCoordinate = tileCoordinate;
    }

    public abstract boolean isTileOccupied();
    public abstract Piece getPiece();

    public static final class emptyTile extends Tile {
        emptyTile(int coordinate) {
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
        Piece pieceOntile;

        occupiedTile(int coordinate, Piece pieceOntile) {
            super(coordinate);
            this.pieceOntile = pieceOntile;
        }

        @Override
        public boolean isTileOccupied() {
            return true;
        }

        @Override
        public Piece getPiece() {
            return this.pieceOntile;
        }
    }

}
