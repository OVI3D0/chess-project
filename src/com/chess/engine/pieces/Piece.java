// piece class
// takes a position and alliance (team)
package com.chess.engine.pieces;
import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.Move;

import java.util.List;

public abstract class Piece {

    // every piece has a piece position (tile coordinate) that it occupies
    protected final int piecePosition;
    // piece can be either white or black
    // we'll call this an alliance rather than a team
    protected final Alliance pieceAlliance;

    // piece constructor
    Piece(final int piecePosition, final Alliance pieceAlliance) {
        this.piecePosition = piecePosition;
        this.pieceAlliance = pieceAlliance;
    }

    // calculate the legal moves for a specific piece
    // return collection of moves
    public abstract List<Move> calculateLegalMoves(final Board board);

}
