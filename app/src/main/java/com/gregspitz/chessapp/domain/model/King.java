package com.gregspitz.chessapp.domain.model;

/**
 * A King
 * can move in any direction one square
 */

public class King extends ChessPiece {

    public King(int file, int rank, boolean isWhite) {
        super(file, rank, isWhite);
    }

    @Override
    public boolean canMove(int newFile, int newRank) {
        return !(newFile - mCurrentFile == 0 && newRank - mCurrentRank == 0) &&
                (newFile - mCurrentFile >= -1 && newFile - mCurrentFile <= 1) &&
                (newRank - mCurrentRank >= -1 && newRank - mCurrentRank <= 1);
    }
}
