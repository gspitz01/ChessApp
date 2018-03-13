package com.gregspitz.chessapp.domain.model;

/**
 * A King
 * can move in any direction one square
 */

public class King extends ChessPiece {

    public King(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(int startFile, int startRank, int endFile, int endRank) {
        return !(endFile - startFile == 0 && endRank - startRank == 0) &&
                (endFile - startFile >= -1 && endFile - startFile <= 1) &&
                (endRank - startRank >= -1 && endRank - startRank <= 1);
    }
}
