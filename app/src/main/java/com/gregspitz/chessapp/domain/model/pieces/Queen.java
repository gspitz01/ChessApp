package com.gregspitz.chessapp.domain.model.pieces;

/**
 * Queen
 * can move horizontally, vertically or diagonally any number of squares
 */

public class Queen extends ChessPiece {

    public Queen(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(int startFile, int startRank, int endFile, int endRank) {
        return !(endFile - startFile == 0 && endRank - startRank == 0) &&
                (Math.abs(endFile - startFile) == Math.abs(endRank - startRank) ||
                        endFile == startFile || endRank == startRank);
    }
}
