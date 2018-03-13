package com.gregspitz.chessapp.domain.model.pieces;

import com.gregspitz.chessapp.domain.model.pieces.King;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for the implementation of {@link King}
 */

public class KingTest {

    private static final int STARTING_FILE = 2;
    private static final int STARTING_RANK = 3;

    private King mWhiteKing;
    private King mBlackKing;

    @Before
    public void setup() {
        mWhiteKing = new King(true);
        mBlackKing = new King(false);
    }

    @Test
    public void blackAndWhiteKing_CanMoveOneSquareAnyDirection() {
        assertTrue(mWhiteKing.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE, STARTING_RANK + 1));
        assertTrue(mWhiteKing.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE, STARTING_RANK - 1));
        assertTrue(mWhiteKing.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE + 1, STARTING_RANK));
        assertTrue(mWhiteKing.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE - 1, STARTING_RANK));
        assertTrue(mWhiteKing.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE + 1, STARTING_RANK + 1));
        assertTrue(mWhiteKing.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE - 1, STARTING_RANK - 1));
        assertTrue(mBlackKing.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE, STARTING_RANK + 1));
        assertTrue(mBlackKing.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE, STARTING_RANK - 1));
        assertTrue(mBlackKing.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE + 1, STARTING_RANK));
        assertTrue(mBlackKing.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE - 1, STARTING_RANK));
        assertTrue(mBlackKing.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE + 1, STARTING_RANK + 1));
        assertTrue(mBlackKing.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE - 1, STARTING_RANK - 1));
    }

    @Test
    public void blackAndWhiteKing_noMoveDoesNotCount() {
        assertFalse(mWhiteKing.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE, STARTING_RANK));
        assertFalse(mBlackKing.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE, STARTING_RANK));
    }

    @Test
    public void blackAndWhiteKing_cannotMoveMoreThanOneSquareInAnyDirection() {
        assertFalse(mWhiteKing.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE, STARTING_RANK - 2));
        assertFalse(mWhiteKing.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE, STARTING_RANK + 2));
        assertFalse(mWhiteKing.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE + 2, STARTING_RANK));
        assertFalse(mWhiteKing.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE - 2, STARTING_RANK));
        assertFalse(mWhiteKing.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE + 2, STARTING_RANK + 2));
        assertFalse(mWhiteKing.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE - 2, STARTING_RANK - 2));
        assertFalse(mBlackKing.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE, STARTING_RANK - 2));
        assertFalse(mBlackKing.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE, STARTING_RANK + 2));
        assertFalse(mBlackKing.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE + 2, STARTING_RANK));
        assertFalse(mBlackKing.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE - 2, STARTING_RANK));
        assertFalse(mBlackKing.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE + 2, STARTING_RANK + 2));
        assertFalse(mBlackKing.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE - 2, STARTING_RANK - 2));

    }
}
