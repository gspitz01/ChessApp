package com.gregspitz.chessapp.domain.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for the implementation of {@link Queen}
 */

public class QueenTest {

    private static final int STARTING_FILE = 2;
    private static final int STARTING_RANK = 3;

    private Queen mWhiteQueen;
    private Queen mBlackQueen;

    @Before
    public void setup() {
        mWhiteQueen = new Queen(STARTING_FILE, STARTING_RANK, true);
        mBlackQueen = new Queen(STARTING_FILE, STARTING_RANK, false);
    }

    @Test
    public void blackAndWhiteQueen_canMoveVerticallyAnyNumberOfSquares() {
        for (int i = 1; i < 20; i++) {
            assertTrue(mWhiteQueen.canMove(STARTING_FILE, STARTING_RANK + i));
            assertTrue(mWhiteQueen.canMove(STARTING_FILE, STARTING_RANK - i));
            assertTrue(mBlackQueen.canMove(STARTING_FILE, STARTING_RANK - i));
            assertTrue(mBlackQueen.canMove(STARTING_FILE, STARTING_RANK + i));
        }
    }

    @Test
    public void blackAndWhiteQueen_canMoveHorizontallyAnyNumberOfSquares() {
        for (int i = 1; i < 20; i++) {
            assertTrue(mWhiteQueen.canMove(STARTING_FILE + i, STARTING_RANK));
            assertTrue(mWhiteQueen.canMove(STARTING_FILE - i, STARTING_RANK));
            assertTrue(mBlackQueen.canMove(STARTING_FILE + i, STARTING_RANK));
            assertTrue(mBlackQueen.canMove(STARTING_FILE - i, STARTING_RANK));
        }
    }

    @Test
    public void blackAndWhiteQueen_canMoveDiagonallyAnyNumberOfSquares() {
        for (int i = 1; i < 20; i++) {
            assertTrue(mWhiteQueen.canMove(STARTING_FILE + i, STARTING_RANK + i));
            assertTrue(mWhiteQueen.canMove(STARTING_FILE + i, STARTING_RANK - i));
            assertTrue(mWhiteQueen.canMove(STARTING_FILE - i, STARTING_RANK - i));
            assertTrue(mWhiteQueen.canMove(STARTING_FILE - i, STARTING_RANK + i));
            assertTrue(mBlackQueen.canMove(STARTING_FILE + i, STARTING_RANK + i));
            assertTrue(mBlackQueen.canMove(STARTING_FILE + i, STARTING_RANK - i));
            assertTrue(mBlackQueen.canMove(STARTING_FILE - i, STARTING_RANK - i));
            assertTrue(mBlackQueen.canMove(STARTING_FILE - i, STARTING_RANK + i));
        }
    }

    @Test
    public void blackAndWhiteQueen_noMoveDoesNotCount() {
        assertFalse(mWhiteQueen.canMove(STARTING_FILE, STARTING_RANK));
        assertFalse(mBlackQueen.canMove(STARTING_FILE, STARTING_RANK));
    }

    @Test
    public void blackAndWhiteQueen_cannotMoveAnyOtherWay() {
        assertFalse(mWhiteQueen.canMove(STARTING_FILE + 1, STARTING_RANK + 2));
        assertFalse(mWhiteQueen.canMove(STARTING_FILE + 2, STARTING_RANK + 1));
        assertFalse(mWhiteQueen.canMove(STARTING_FILE - 1, STARTING_RANK - 2));
        assertFalse(mWhiteQueen.canMove(STARTING_FILE - 2, STARTING_RANK - 1));
        assertFalse(mWhiteQueen.canMove(STARTING_FILE - 1, STARTING_RANK + 2));
        assertFalse(mWhiteQueen.canMove(STARTING_FILE + 2, STARTING_RANK - 1));
        assertFalse(mWhiteQueen.canMove(STARTING_FILE + 1, STARTING_RANK - 2));
        assertFalse(mWhiteQueen.canMove(STARTING_FILE - 2, STARTING_RANK + 1));
        assertFalse(mBlackQueen.canMove(STARTING_FILE + 1, STARTING_RANK + 2));
        assertFalse(mBlackQueen.canMove(STARTING_FILE + 2, STARTING_RANK + 1));
        assertFalse(mBlackQueen.canMove(STARTING_FILE - 1, STARTING_RANK - 2));
        assertFalse(mBlackQueen.canMove(STARTING_FILE - 2, STARTING_RANK - 1));
        assertFalse(mBlackQueen.canMove(STARTING_FILE - 1, STARTING_RANK + 2));
        assertFalse(mBlackQueen.canMove(STARTING_FILE + 2, STARTING_RANK - 1));
        assertFalse(mBlackQueen.canMove(STARTING_FILE + 1, STARTING_RANK - 2));
        assertFalse(mBlackQueen.canMove(STARTING_FILE - 2, STARTING_RANK + 1));
    }
}
