package com.gregspitz.chessapp.domain.model;

/**
 * A bishop
 * can move diagonally any number of squares
 */

public class Bishop extends ChessPiece {

    public Bishop(int file, int rank, boolean isWhite) {
        super(file, rank, isWhite);
    }

    @Override
    public boolean canMove(int newFile, int newRank) {
        return !(newFile - mCurrentFile == 0 && newRank - mCurrentRank == 0) &&
                (Math.abs(newFile - mCurrentFile) == Math.abs(newRank - mCurrentRank));
    }
}
