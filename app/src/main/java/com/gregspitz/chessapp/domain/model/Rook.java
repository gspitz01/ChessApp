package com.gregspitz.chessapp.domain.model;

/**
 * A Rook
 * can move vertically or horizontally any number of moves
 */

public class Rook extends ChessPiece {

    public Rook(int file, int rank, boolean isWhite) {
        super(file, rank, isWhite);
    }

    @Override
    public boolean canMove(int newFile, int newRank) {
        return !(newFile - mCurrentFile == 0 && newRank - mCurrentRank == 0) &&
                (newFile == mCurrentFile || newRank == mCurrentRank);
    }
}
