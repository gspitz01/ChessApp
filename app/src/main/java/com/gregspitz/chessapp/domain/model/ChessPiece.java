package com.gregspitz.chessapp.domain.model;

/**
 * A chess piece
 * White pieces move in the negative direction
 */

public abstract class ChessPiece {


    protected boolean mIsWhite;

    public ChessPiece(boolean isWhite) {
        mIsWhite = isWhite;
    }

    public abstract boolean canMove(int startFile, int startRank, int endFile, int endRank);

    public boolean isWhite() {
        return mIsWhite;
    }
}
