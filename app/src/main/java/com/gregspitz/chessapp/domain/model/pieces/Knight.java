package com.gregspitz.chessapp.domain.model.pieces;

/**
 * a Knight
 * can move in L shapes in any direction
 */

public class Knight extends ChessPiece {

    public Knight(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(int startFile, int startRank, int endFile, int endRank) {
        switch (endFile - startFile) {
            case 2:
                // Intentional fallthrough
            case -2:
                return (endRank - startRank== 1) || (endRank - startRank == -1);
            case 1:
                // Intentional fallthrough
            case -1:
                return (endRank - startRank == 2) || (endRank - startRank == -2);
            default:
                return false;
        }
    }
}
