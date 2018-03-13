package com.gregspitz.chessapp.domain.model;

/**
 * A chess piece
 * Keeps track of its current position and whether or not it is white or black
 * White pieces move in the negative direction
 */

public abstract class ChessPiece {

    protected int mCurrentRank;
    protected int mCurrentFile;
    protected boolean mIsWhite;

    public ChessPiece(int file, int rank, boolean isWhite) {
        mCurrentFile = file;
        mCurrentRank = rank;
        mIsWhite = isWhite;
    }

    public abstract boolean canMove(int newFile, int newRank);

    public int getCurrentRank() {
        return mCurrentRank;
    }

    public int getCurrentFile() {
        return mCurrentFile;
    }

    public boolean isWhite() {
        return mIsWhite;
    }

    public void move(int newFile, int newRank) {
        mCurrentFile = newFile;
        mCurrentRank = newRank;
    }
}
