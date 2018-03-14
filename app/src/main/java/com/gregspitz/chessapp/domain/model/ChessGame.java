package com.gregspitz.chessapp.domain.model;

import com.gregspitz.chessapp.domain.model.pieces.ChessPiece;
import com.gregspitz.chessapp.domain.model.pieces.King;
import com.gregspitz.chessapp.domain.model.pieces.Knight;
import com.gregspitz.chessapp.domain.model.pieces.Pawn;

/**
 * A game of chess
 */

public class ChessGame {

    private boolean mIsWhitesTurn;
    private Chessboard mChessboard;
    private int mEnPassantFile;
    private int mEnPassantRank;

    public ChessGame() {
        mIsWhitesTurn = true;
        mChessboard = new Chessboard();
        mChessboard.setInitialPosition();
        mEnPassantFile = -1;
        mEnPassantRank = -1;
    }

    public boolean isWhitesTurn() {
        return mIsWhitesTurn;
    }

    public boolean move(String move) {
        int[] moveTranslated = translateStringMoveToInts(move);
        return (moveTranslated != null) &&
                move(moveTranslated[0], moveTranslated[1], moveTranslated[2], moveTranslated[3]);
    }

    public boolean move(int startFile, int startRank, int endFile, int endRank) {
        if (performMove(startFile, startRank, endFile, endRank)) {
            checkForEnPassant(startFile, startRank, endFile, endRank);
            mIsWhitesTurn = !mIsWhitesTurn;
            return true;
        } else {
            return false;
        }
    }

    private int[] translateStringMoveToInts(String move) {
        // TODO: finish this and test
        return null;
    }

    private boolean performMove(int startFile, int startRank, int endFile, int endRank) {
        // If it's the same square, do nothing
        if (startFile == endFile && startRank == endRank) {
            return false;
        }

        ChessPiece movingPiece = mChessboard.getPiece(startFile, startRank);
        ChessPiece endSquare = mChessboard.getPiece(endFile, endRank);

        // Check there is a piece there and it's the right color
        // And the end square doesn't have same color piece
        if (movingPiece == null || movingPiece.isWhite() != mIsWhitesTurn ||
                (endSquare != null && endSquare.isWhite() == mIsWhitesTurn)) {
            return false;
        }

        if (movingPiece instanceof Pawn) {
            if (startFile != endFile) {
                if (endSquare != null) {
                    // pawn capture
                    return mChessboard.movePiece(startFile, startRank, endFile, endRank);
                } else {
                    // En passant move
                    return (endFile == mEnPassantFile && endRank == mEnPassantRank) &&
                            mChessboard.movePiece(startFile, startRank, endFile, endRank);
                }
            } else {
                int moveSize = Math.abs(endRank - startRank);
                if (moveSize > 2) {
                    return false;
                } else if (moveSize == 2) {
                    // Two square move
                    if (mIsWhitesTurn) {
                        return (startRank == 6) &&
                                (mChessboard.getPiece(startFile, startRank - 1) == null) &&
                                mChessboard.movePiece(startFile, startRank, endFile, endRank);
                    } else {
                        return (startRank == 1) &&
                                (mChessboard.getPiece(startFile, startRank + 1) == null) &&
                                mChessboard.movePiece(startFile, startRank, endFile, endRank);
                    }
                } else {
                    // One square move
                    return mChessboard.movePiece(startFile, startRank, endFile, endRank);
                }
            }
        } else if (movingPiece instanceof Knight) {
            // if it's a knight it can jump over other pieces
            return mChessboard.movePiece(startFile, startRank, endFile, endRank);
        } else if (movingPiece instanceof King) {
            if (startRank == endRank && Math.abs(endFile - startFile) == 2) {
                // Castling
                if (endSquare != null) {
                    return false;
                } else if (endFile - startFile > 0) {
                    // castling king side
                    return (mChessboard.getPiece(startFile + 1, startRank) == null) &&
                            mChessboard.movePiece(startFile, startRank, endFile, endRank);
                } else {
                    // castling queen side
                   return (mChessboard.getPiece(startFile - 1, startRank) == null) &&
                           (mChessboard.getPiece(startFile - 3, startRank) == null) &&
                           mChessboard.movePiece(startFile, startRank, endFile, endRank);
                }
            } else {
                return mChessboard.movePiece(startFile, startRank, endFile, endRank);
            }
        } else {
            // Any other piece need to check the squares in between
            int horizontalMoveDirection = endFile - startFile;
            int verticalMoveDirection = endRank - startRank;
            int absoluteDistance = Math.abs(horizontalMoveDirection);
            if (horizontalMoveDirection > 0) {
                if (verticalMoveDirection > 0) {
                    // Positive horizontal, positive vertical
                    for (int i = 1; i < absoluteDistance; i++) {
                        if (mChessboard.getPiece(startFile + i, startRank + i) != null) {
                            return false;
                        }
                    }
                } else if (verticalMoveDirection == 0) {
                    // Strict positive horizontal move
                    for (int i = startFile + 1; i < endFile; i++) {
                        if (mChessboard.getPiece(i, startRank) != null) {
                            return false;
                        }
                    }
                } else {
                    // Positive horizontal, negative vertical
                    for (int i = 1; i < absoluteDistance; i++) {
                        if (mChessboard.getPiece(startFile + i, startRank - i) != null) {
                            return false;
                        }
                    }
                }
            } else if (horizontalMoveDirection == 0) {
                // Moving vertically
                if (verticalMoveDirection > 0) {
                    // strict positive vertical
                    for (int j = startRank + 1; j < endRank; j++) {
                        if (mChessboard.getPiece(startFile, j) != null) {
                            return false;
                        }
                    }
                } else {
                    // Checked for no move at the beginning so don't need to check again here
                    // strict negative vertical
                    for (int j = startRank - 1; j > endRank; j--) {
                        if (mChessboard.getPiece(startFile, j) != null) {
                            return false;
                        }
                    }
                }
            } else {
                if (verticalMoveDirection > 0) {
                    // Negative horizontal, positive vertical
                    for (int i = 1; i < absoluteDistance; i++) {
                        if (mChessboard.getPiece(startFile - i, startRank + i) != null) {
                            return false;
                        }
                    }
                } else if (verticalMoveDirection == 0) {
                    // Strict negative horizontal move
                    for (int i = startFile - 1; i > endFile; i--) {
                        if (mChessboard.getPiece(i, startRank) != null) {
                            return false;
                        }
                    }
                } else {
                    // Negative horizontal, negative vertical
                    for (int i = 1; i < absoluteDistance; i++) {
                        if (mChessboard.getPiece(startFile - i, startRank - i) != null) {
                            return false;
                        }
                    }
                }
            }
            return mChessboard.movePiece(startFile, startRank, endFile, endRank);
        }
    }

    private void checkForEnPassant(int startFile, int startRank, int endFile, int endRank) {
        if (mChessboard.getPiece(endFile, endRank) instanceof Pawn &&
                (Math.abs(endRank - startRank) == 2)) {
            // Need to set en passant square
            if (mIsWhitesTurn) {
                setEnPassantSquare(endFile, endRank + 1);
            } else {
                setEnPassantSquare(endFile, endRank - 1);
            }
        } else {
            setEnPassantSquare(-1, -1);
        }
    }

    private void setEnPassantSquare(int file, int rank) {
        mEnPassantFile = file;
        mEnPassantRank = rank;
    }

    @Override
    public String toString() {
        return mChessboard.toString() + "\nMove: " + (mIsWhitesTurn ? "White" : "Black") +
                "\n";
    }
}
