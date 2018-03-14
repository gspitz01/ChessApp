package com.gregspitz.chessapp.domain.model;

import com.gregspitz.chessapp.domain.model.pieces.Bishop;
import com.gregspitz.chessapp.domain.model.pieces.ChessPiece;
import com.gregspitz.chessapp.domain.model.pieces.King;
import com.gregspitz.chessapp.domain.model.pieces.Knight;
import com.gregspitz.chessapp.domain.model.pieces.Pawn;
import com.gregspitz.chessapp.domain.model.pieces.Queen;
import com.gregspitz.chessapp.domain.model.pieces.Rook;

/**
 * An 8x8 chessboard
 * Knows its bounds
 * Can clear self
 * Can set initial position
 * Can move one piece to another square
 * Is aware of the pieces in its squares
 * Any piece can capture any other piece regardless of color
 * Doesn't keep track of pieces in between, i.e. thinks every piece can jump
 * 0th rank is black's 1st rank, i.e. the 8th rank of the physical board
 * i.e. file: 0, rank: 7 is square a1
 */

public class Chessboard {

    public static final int SIZE = 8;

    private ChessPiece[][] mSquares;

    public Chessboard() {
        mSquares = new ChessPiece[SIZE][SIZE];
    }

    public ChessPiece getPiece(int file, int rank) {
        return mSquares[file][rank];
    }

    public void setInitialPosition() {
        // Black rooks
        mSquares[0][0] = new Rook(false);
        mSquares[7][0] = new Rook(false);

        // Black knights
        mSquares[1][0] = new Knight(false);
        mSquares[6][0] = new Knight(false);

        // Black bishops
        mSquares[2][0] = new Bishop(false);
        mSquares[5][0] = new Bishop(false);

        // Black Queen
        mSquares[3][0] = new Queen(false);

        // Black King
        mSquares[4][0] = new King(false);

        // Black pawns
        for (int i = 0; i < SIZE; i++) {
            mSquares[i][1] = new Pawn(false);
        }

        // White rooks
        mSquares[0][7] = new Rook(true);
        mSquares[7][7] = new Rook(true);

        // White knights
        mSquares[1][7] = new Knight(true);
        mSquares[6][7] = new Knight(true);

        // White bishops
        mSquares[2][7] = new Bishop(true);
        mSquares[5][7] = new Bishop(true);

        // White queen
        mSquares[3][7] = new Queen(true);

        // White king
        mSquares[4][7] = new King(true);

        // White pawns
        for (int i = 0; i < SIZE; i++) {
            mSquares[i][6] = new Pawn(true);
        }
    }

    public boolean movePiece(int startFile, int startRank, int endFile, int endRank) {
        if (mSquares == null || mSquares[startFile][startRank] == null) {
            return false;
        }

        ChessPiece movingPiece = mSquares[startFile][startRank];

        if (movingPiece instanceof King && startRank == endRank &&
                Math.abs(endFile - startFile) == 2) {
            // Castling
            if (movingPiece.isWhite() && startRank == 7 && startFile == 4) {
                if (endFile - startFile > 0) {
                    ChessPiece castleRook = mSquares[7][7];
                    if (castleRook != null && castleRook instanceof  Rook) {
                        // White castling king side
                        mSquares[endFile][endRank] = movingPiece;
                        mSquares[startFile][startRank] = null;
                        mSquares[endFile - 1][endRank] = castleRook;
                        mSquares[7][7] = null;
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    ChessPiece castleRook = mSquares[0][7];
                    if (castleRook != null && castleRook instanceof Rook) {
                        // White castling queen side
                        mSquares[endFile][endRank] = movingPiece;
                        mSquares[startFile][startRank] = null;
                        mSquares[endFile + 1][endRank] = castleRook;
                        mSquares[0][7] = null;
                        return true;
                    } else {
                        return false;
                    }
                }
            } else if (startRank == 0 && startFile == 4) {
                if (endFile - startFile > 0) {
                    ChessPiece castleRook = mSquares[7][0];
                    if (castleRook != null && castleRook instanceof  Rook) {
                        // Black castling king side
                        mSquares[endFile][endRank] = movingPiece;
                        mSquares[startFile][startRank] = null;
                        mSquares[endFile - 1][endRank] = castleRook;
                        mSquares[7][0] = null;
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    ChessPiece castleRook = mSquares[0][0];
                    if (castleRook != null && castleRook instanceof Rook) {
                        // Black castling queen side
                        mSquares[endFile][endRank] = movingPiece;
                        mSquares[startFile][startRank] = null;
                        mSquares[endFile + 1][endRank] = castleRook;
                        mSquares[0][0] = null;
                        return true;
                    } else {
                        return false;
                    }
                }
            } else {
                return false;
            }
        } else if (movingPiece.canMove(startFile, startRank, endFile, endRank)) {
            mSquares[endFile][endRank] = movingPiece;
            mSquares[startFile][startRank] = null;
            return true;
        } else {
            return false;
        }
    }

    public void clear() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                mSquares[i][j] = null;
            }
        }
    }
}
