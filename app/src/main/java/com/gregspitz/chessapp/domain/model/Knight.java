package com.gregspitz.chessapp.domain.model;

/**
 * a Knight
 * can move in L shapes in any direction
 */

public class Knight extends ChessPiece {

    public Knight(int file, int rank, boolean isWhite) {
        super(file, rank, isWhite);
    }

    @Override
    public boolean canMove(int newFile, int newRank) {
        switch (newFile - mCurrentFile) {
            case 2:
                // Intentional fallthrough
            case -2:
                return (newRank - mCurrentRank == 1) || (newRank - mCurrentRank == -1);
            case 1:
                // Intentional fallthrough
            case -1:
                return (newRank - mCurrentRank == 2) || (newRank - mCurrentRank == -2);
            default:
                return false;
        }
    }
}
