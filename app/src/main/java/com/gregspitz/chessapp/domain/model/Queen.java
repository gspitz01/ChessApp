package com.gregspitz.chessapp.domain.model;

/**
 * Queen
 * can move horizontally, vertically or diagonally any number of squares
 */

public class Queen extends ChessPiece {

    public Queen(int file, int rank, boolean isWhite) {
        super(file, rank, isWhite);
    }

    @Override
    public boolean canMove(int newFile, int newRank) {
        return !(newFile - mCurrentFile == 0 && newRank - mCurrentRank == 0) &&
                (Math.abs(newFile - mCurrentFile) == Math.abs(newRank - mCurrentRank) ||
                        newFile == mCurrentFile || newRank == mCurrentRank);
    }
}
