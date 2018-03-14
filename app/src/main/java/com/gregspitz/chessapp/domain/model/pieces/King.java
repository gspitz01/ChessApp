package com.gregspitz.chessapp.domain.model.pieces;

/**
 * A King
 * can move in any direction one square
 * king is unaware that it can castle, the board keeps that info
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
