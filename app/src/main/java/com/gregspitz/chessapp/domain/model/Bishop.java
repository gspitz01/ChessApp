package com.gregspitz.chessapp.domain.model;

/**
 * A bishop
 * can move diagonally any number of squares
 */

public class Bishop extends ChessPiece {

    public Bishop(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(int startFile, int startRank, int endFile, int endRank) {
        return !(endFile - startFile == 0 && endRank - startRank == 0) &&
                (Math.abs(endFile - startFile) == Math.abs(endRank - startRank));
    }
}
