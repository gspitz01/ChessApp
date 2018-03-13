package com.gregspitz.chessapp.domain.model;

/**
 * A Rook
 * can move vertically or horizontally any number of moves
 */

public class Rook extends ChessPiece {

    public Rook(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(int startFile, int startRank, int endFile, int endRank) {
        return !(endFile - startFile == 0 && endRank - startRank== 0) &&
                (endFile == startFile || endRank == startRank);
    }
}
