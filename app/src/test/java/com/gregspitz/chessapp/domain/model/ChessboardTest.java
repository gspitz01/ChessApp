package com.gregspitz.chessapp.domain.model;

import com.gregspitz.chessapp.domain.model.pieces.Bishop;
import com.gregspitz.chessapp.domain.model.pieces.King;
import com.gregspitz.chessapp.domain.model.pieces.Knight;
import com.gregspitz.chessapp.domain.model.pieces.Pawn;
import com.gregspitz.chessapp.domain.model.pieces.Queen;
import com.gregspitz.chessapp.domain.model.pieces.Rook;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Tests for the implementation of {@link Chessboard}
 */

public class ChessboardTest {

    private Chessboard mChessboard;

    @Before
    public void setup() {
        mChessboard = new Chessboard();
    }

    @Test
    public void chessboard_startsNullInAllSquares() {
        for (int i = 0; i < Chessboard.SIZE; i++) {
            for (int j = 0; j < Chessboard.SIZE; j++) {
                assertNull(mChessboard.getPiece(i, j));
            }
        }
    }

    @Test
    public void chessboard_setsInitialPosition() {
        mChessboard.setInitialPosition();

        // Black rooks
        assertTrue(mChessboard.getPiece(0, 0) instanceof Rook);
        assertFalse(mChessboard.getPiece(0, 0).isWhite());
        assertTrue(mChessboard.getPiece(7, 0) instanceof Rook);
        assertFalse(mChessboard.getPiece(7, 0).isWhite());

        // Black knights
        assertTrue(mChessboard.getPiece(1, 0) instanceof Knight);
        assertFalse(mChessboard.getPiece(1, 0).isWhite());
        assertTrue(mChessboard.getPiece(6, 0) instanceof Knight);
        assertFalse(mChessboard.getPiece(6, 0).isWhite());

        // Black bishops
        assertTrue(mChessboard.getPiece(2, 0) instanceof Bishop);
        assertFalse(mChessboard.getPiece(2, 0).isWhite());
        assertTrue(mChessboard.getPiece(5, 0) instanceof Bishop);
        assertFalse(mChessboard.getPiece(5, 0).isWhite());

        // Black Queen
        assertTrue(mChessboard.getPiece(3, 0) instanceof Queen);
        assertFalse(mChessboard.getPiece(3, 0).isWhite());

        // Black King
        assertTrue(mChessboard.getPiece(4, 0) instanceof King);
        assertFalse(mChessboard.getPiece(4, 0).isWhite());

        // Black pawns
        for (int i = 0; i < Chessboard.SIZE; i++) {
            assertTrue(mChessboard.getPiece(i, 1) instanceof Pawn);
            assertFalse(mChessboard.getPiece(i, 1).isWhite());
        }

        // White rooks
        assertTrue(mChessboard.getPiece(0, 7) instanceof Rook);
        assertTrue(mChessboard.getPiece(0, 7).isWhite());
        assertTrue(mChessboard.getPiece(7, 7) instanceof Rook);
        assertTrue(mChessboard.getPiece(7, 7).isWhite());

        // White knights
        assertTrue(mChessboard.getPiece(1, 7) instanceof Knight);
        assertTrue(mChessboard.getPiece(1, 7).isWhite());
        assertTrue(mChessboard.getPiece(6, 7) instanceof Knight);
        assertTrue(mChessboard.getPiece(6, 7).isWhite());

        // White bishops
        assertTrue(mChessboard.getPiece(2, 7) instanceof Bishop);
        assertTrue(mChessboard.getPiece(2, 7).isWhite());
        assertTrue(mChessboard.getPiece(5, 7) instanceof Bishop);
        assertTrue(mChessboard.getPiece(5, 7).isWhite());

        // White Queen
        assertTrue(mChessboard.getPiece(3, 7) instanceof Queen);
        assertTrue(mChessboard.getPiece(3, 7).isWhite());

        // White King
        assertTrue(mChessboard.getPiece(4, 7) instanceof King);
        assertTrue(mChessboard.getPiece(4, 7).isWhite());

        // White pawns
        for (int i = 0; i < Chessboard.SIZE; i++) {
            assertTrue(mChessboard.getPiece(i, 6) instanceof  Pawn);
            assertTrue(mChessboard.getPiece(i, 6).isWhite());
        }
    }

    @Test
    public void chessboard_canClearBoard() {
        mChessboard.setInitialPosition();
        mChessboard.clear();
        for (int i = 0; i < Chessboard.SIZE; i++) {
            for (int j = 0; j < Chessboard.SIZE; j++) {
                assertNull(mChessboard.getPiece(i, j));
            }
        }
    }

    @Test
    public void canMove_e2e4() {
        mChessboard.setInitialPosition();
        assertTrue(mChessboard.movePiece(4, 6, 4, 4));
        assertTrue(mChessboard.getPiece(4, 4) instanceof Pawn);
        assertTrue(mChessboard.getPiece(4, 4).isWhite());
        assertNull(mChessboard.getPiece(4, 6));
    }

    @Test
    public void canMove_e7e5() {
        mChessboard.setInitialPosition();
        assertTrue(mChessboard.movePiece(4, 1, 4, 3));
        assertTrue(mChessboard.getPiece(4, 3) instanceof Pawn);
        assertFalse(mChessboard.getPiece(4, 3).isWhite());
        assertNull(mChessboard.getPiece(4, 1));
    }

    @Test
    public void canMove_Ng1f3() {
        mChessboard.setInitialPosition();
        assertTrue(mChessboard.movePiece(6, 7, 5, 5));
        assertTrue(mChessboard.getPiece(5, 5) instanceof Knight);
        assertTrue(mChessboard.getPiece(5, 5).isWhite());
        assertNull(mChessboard.getPiece(6, 7));
    }

    @Test
    public void canMove_Nb8c6() {
        mChessboard.setInitialPosition();
        assertTrue(mChessboard.movePiece(1, 0, 2, 2));
        assertTrue(mChessboard.getPiece(2, 2) instanceof Knight);
        assertFalse(mChessboard.getPiece(2, 2).isWhite());
        assertNull(mChessboard.getPiece(1, 0));
    }

    @Test
    public void canCapture_Bf1xe2() {
        // This should be avoided by the game, but chessboard will allow it
        mChessboard.setInitialPosition();
        assertTrue(mChessboard.movePiece(5, 7, 4, 6));
        assertTrue(mChessboard.getPiece(4, 6) instanceof Bishop);
        assertTrue(mChessboard.getPiece(4, 6).isWhite());
        assertNull(mChessboard.getPiece(5, 7));
    }

    @Test
    public void canMove_Rh8h2() {
        // This should be avoided by the game, but chessboard will allow it
        mChessboard.setInitialPosition();
        assertTrue(mChessboard.movePiece(7, 0, 7, 6));
        assertTrue(mChessboard.getPiece(7, 6) instanceof Rook);
        assertFalse(mChessboard.getPiece(7, 6).isWhite());
        assertNull(mChessboard.getPiece(7, 0));
    }

    @Test
    public void whiteKing_canCastleKingSize() {
        // The board allow this to happen with pieces in between
        mChessboard.setInitialPosition();
        assertTrue(mChessboard.movePiece(4, 7, 6, 7));
        assertTrue(mChessboard.getPiece(6, 7) instanceof  King);
        assertTrue(mChessboard.getPiece(6, 7).isWhite());
        assertTrue(mChessboard.getPiece(5, 7) instanceof Rook);
        assertTrue(mChessboard.getPiece(5, 7).isWhite());
        assertNull(mChessboard.getPiece(4, 7));
        assertNull(mChessboard.getPiece(7, 7));
    }

    @Test
    public void whiteKing_canCastleQueenSize() {
        // The board allow this to happen with pieces in between
        mChessboard.setInitialPosition();
        assertTrue(mChessboard.movePiece(4, 7, 2, 7));
        assertTrue(mChessboard.getPiece(2, 7) instanceof  King);
        assertTrue(mChessboard.getPiece(2, 7).isWhite());
        assertTrue(mChessboard.getPiece(3, 7) instanceof Rook);
        assertTrue(mChessboard.getPiece(3, 7).isWhite());
        assertNull(mChessboard.getPiece(4, 7));
        assertNull(mChessboard.getPiece(0, 7));
    }

    @Test
    public void blackKing_canCastleKingSize() {
        // The board allow this to happen with pieces in between
        mChessboard.setInitialPosition();
        assertTrue(mChessboard.movePiece(4, 0, 6, 0));
        assertTrue(mChessboard.getPiece(6, 0) instanceof  King);
        assertFalse(mChessboard.getPiece(6, 0).isWhite());
        assertTrue(mChessboard.getPiece(5, 0) instanceof Rook);
        assertFalse(mChessboard.getPiece(5, 0).isWhite());
        assertNull(mChessboard.getPiece(4, 0));
        assertNull(mChessboard.getPiece(7, 0));
    }

    @Test
    public void blackKing_canCastleQueenSize() {
        // The board allow this to happen with pieces in between
        mChessboard.setInitialPosition();
        assertTrue(mChessboard.movePiece(4, 0, 2, 0));
        assertTrue(mChessboard.getPiece(2, 0) instanceof  King);
        assertFalse(mChessboard.getPiece(2, 0).isWhite());
        assertTrue(mChessboard.getPiece(3, 0) instanceof Rook);
        assertFalse(mChessboard.getPiece(3, 0).isWhite());
        assertNull(mChessboard.getPiece(4, 0));
        assertNull(mChessboard.getPiece(0, 0));
    }

    @Test
    public void whiteKing_cannotCastleKingSideAfterHavingMoved() {
        mChessboard.setInitialPosition();
        assertTrue(mChessboard.movePiece(4, 7, 3, 7));
        assertFalse(mChessboard.movePiece(3, 7, 5, 7));
    }

    @Test
    public void whiteKing_cannotCastleQueenSideAfterHavingMoved() {
        mChessboard.setInitialPosition();
        assertTrue(mChessboard.movePiece(4, 7, 3, 7));
        assertFalse(mChessboard.movePiece(3, 7, 1, 7));
    }

    @Test
    public void blackKing_cannotCastleKingSideAfterHavingMoved() {
        mChessboard.setInitialPosition();
        assertTrue(mChessboard.movePiece(4, 0, 3, 0));
        assertFalse(mChessboard.movePiece(3, 0, 5, 0));
    }

    @Test
    public void blackKing_cannotCastleQueenSideAfterHavingMoved() {
        mChessboard.setInitialPosition();
        assertTrue(mChessboard.movePiece(4, 0, 3, 0));
        assertFalse(mChessboard.movePiece(3, 0, 1, 0));
    }

    @Test
    public void initialPositionToString_returnsCorrect() {
        mChessboard.setInitialPosition();
        assertEquals(TestGames.STARTING_POSITION_PRINT, mChessboard.toString());
    }

    @Test
    public void after1e4_toStringReturnsCorrect() {
        mChessboard.setInitialPosition();
        assertTrue(mChessboard.movePiece(4, 6, 4, 4));
        assertEquals(TestGames.AFTER_1E4_PRINT, mChessboard.toString());
    }
}
