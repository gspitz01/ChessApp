package com.gregspitz.chessapp.domain.model;

import org.junit.Before;
import org.junit.Test;

import static com.gregspitz.chessapp.domain.model.TestGames.ARONIAN_KRAMNIK_CANDIDATES_2018;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests for the implementation of {@link ChessGame}
 */

public class ChessGameTest {

    private ChessGame mChessGame;

    @Before
    public void setup() {
        mChessGame = new ChessGame();
    }

    @Test
    public void chessGame_startsAsWhitesTurn() {
        assertTrue(mChessGame.isWhitesTurn());
    }

    @Test
    public void chessGame_canStartWith_e4e5() {
        assertTrue(mChessGame.move(4, 6, 4, 4));
        assertTrue(mChessGame.move(4, 1, 4, 3));
    }

    @Test
    public void chessGame_canStartWith_d4d5() {
        assertTrue(mChessGame.move(3, 6, 3, 4));
        assertTrue(mChessGame.move(3, 1, 3, 3));
    }

    @Test
    public void chessGame_spanishOpening() {
        assertTrue(mChessGame.move(4, 6, 4, 4));
        assertTrue(mChessGame.move(4, 1, 4, 3));
        assertTrue(mChessGame.move(6, 7, 5, 5));
        assertTrue(mChessGame.move(1, 0, 2, 2));
        assertTrue(mChessGame.move(5, 7, 1, 3));
    }

    @Test
    public void chessGae_AronianKramnikCandidates2018() {
        for (int[] move : ARONIAN_KRAMNIK_CANDIDATES_2018) {
            assertTrue(mChessGame.move(move[0], move[1], move[2], move[3]));
        }
    }

    @Test
    public void printBeforeAnyMoves_printsCorrectly() {
        assertEquals(TestGames.STARTING_POSITION_PRINT + "\nMove: White\n",
                mChessGame.toString());
    }

    @Test
    public void printAfter1E4_printsCorrectly() {
        assertTrue(mChessGame.move(4, 6, 4, 4));
        assertEquals(TestGames.AFTER_1E4_PRINT + "\nMove: Black\n",
                mChessGame.toString());
    }

    @Test
    public void kingInCheck_needsToGetOutOfCheck() {
        // TODO: finish this
    }

    @Test
    public void checkmate_endsGame() {
        // TODO: finish this
    }
}
