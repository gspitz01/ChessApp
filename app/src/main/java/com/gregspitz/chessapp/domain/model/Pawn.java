package com.gregspitz.chessapp.domain.model;

/**
 * A pawn
 * A pawn thinks it can always move either one or two squares straight forward
 * and one square diagonally forward. It is up to the board to figure out when
 * those are actually possible within the game.
 */
public class Pawn extends ChessPiece {

    public Pawn(int file, int rank, boolean isWhite) {
        super(file, rank, isWhite);
    }

    @Override
    public boolean canMove(int newFile, int newRank) {
        if (mIsWhite) {
            // White moves in the negative direction
            if (newFile - mCurrentFile == 0) {
                // Moving straight
                return (newRank - mCurrentRank >= -2 && newRank - mCurrentRank < 0);
            } else {
                return (newFile - mCurrentFile == 1 || newFile - mCurrentFile == -1) &&
                        (newRank - mCurrentRank == -1);
            }
        } else {
            // Black moves in the positive direction
            if (newFile - mCurrentFile == 0) {
                return (newRank - mCurrentRank <= 2 && newRank - mCurrentRank > 0);
            } else {
                return (newFile - mCurrentFile == 1 || newFile - mCurrentFile == -1) &&
                        (newRank - mCurrentRank == 1);
            }
        }
    }
}
