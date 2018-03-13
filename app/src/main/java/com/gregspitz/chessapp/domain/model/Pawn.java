package com.gregspitz.chessapp.domain.model;

/**
 * A pawn
 * A pawn thinks it can always move either one or two squares straight forward
 * and one square diagonally forward. It is up to the board to figure out when
 * those are actually possible within the game.
 */
public class Pawn extends ChessPiece {

    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(int startFile, int startRank, int endFile, int endRank) {
        if (mIsWhite) {
            // White moves in the negative direction
            if (endFile - startFile== 0) {
                // Moving straight
                return (endRank - startRank >= -2 && endRank - startRank < 0);
            } else {
                return (endFile - startFile == 1 || endFile - startFile == -1) &&
                        (endRank - startRank == -1);
            }
        } else {
            // Black moves in the positive direction
            if (endFile - startFile == 0) {
                return (endRank - startRank <= 2 && endRank - startRank > 0);
            } else {
                return (endFile - startFile == 1 || endFile - startFile == -1) &&
                        (endRank - startRank == 1);
            }
        }
    }
}
