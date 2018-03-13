package com.gregspitz.chessapp.domain.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for the implementation of {@link Rook}
 */

public class RookTest {

    private static final int STARTING_FILE = 2;
    private static final int STARTING_RANK = 3;

    private Rook mWhiteRook;
    private Rook mBlackRook;

    @Before
    public void setup() {
        mWhiteRook = new Rook(STARTING_FILE, STARTING_RANK, true);
        mBlackRook = new Rook(STARTING_FILE, STARTING_RANK, false);
    }

    @Test
    public void blackAndWhiteRook_canMoveVerticallyAnyNumberOfSquares() {
        // Able to move more than 7 squares at a time so that I can implement larger boards
        for (int i = 1; i < 20; i++) {
            assertTrue(mWhiteRook.canMove(STARTING_FILE, STARTING_RANK + i));
            assertTrue(mWhiteRook.canMove(STARTING_FILE, STARTING_RANK - i));
            assertTrue(mBlackRook.canMove(STARTING_FILE, STARTING_RANK + i));
            assertTrue(mBlackRook.canMove(STARTING_FILE, STARTING_RANK - i));
        }
    }

    @Test
    public void blackAndWhiteRook_canMoveHorizontallyAnyNumberOfSquares() {
        for (int i = 1; i < 20; i++) {
            assertTrue(mWhiteRook.canMove(STARTING_FILE + i, STARTING_RANK));
            assertTrue(mWhiteRook.canMove(STARTING_FILE - i, STARTING_RANK));
            assertTrue(mBlackRook.canMove(STARTING_FILE - i, STARTING_RANK));
            assertTrue(mBlackRook.canMove(STARTING_FILE + i, STARTING_RANK));
        }
    }

    @Test
    public void blackAndWhiteRook_noMoveDoesNotCount() {
        assertFalse(mWhiteRook.canMove(STARTING_FILE, STARTING_RANK));
        assertFalse(mBlackRook.canMove(STARTING_FILE, STARTING_RANK));
    }

    @Test
    public void blackAndWhiteRook_cannotMoveDiagonally() {
        for (int i = 1; i < 20; i++) {
            assertFalse(mWhiteRook.canMove(STARTING_FILE + i, STARTING_RANK + i));
            assertFalse(mWhiteRook.canMove(STARTING_FILE - i, STARTING_RANK - i));
            assertFalse(mWhiteRook.canMove(STARTING_FILE - i, STARTING_RANK + i));
            assertFalse(mWhiteRook.canMove(STARTING_FILE + i, STARTING_RANK - i));
            assertFalse(mBlackRook.canMove(STARTING_FILE + i, STARTING_RANK + i));
            assertFalse(mBlackRook.canMove(STARTING_FILE - i, STARTING_RANK - i));
            assertFalse(mBlackRook.canMove(STARTING_FILE - i, STARTING_RANK + i));
            assertFalse(mBlackRook.canMove(STARTING_FILE + i, STARTING_RANK - i));

        }
    }
}
