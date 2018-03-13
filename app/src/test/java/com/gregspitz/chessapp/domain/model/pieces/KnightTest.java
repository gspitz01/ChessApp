package com.gregspitz.chessapp.domain.model.pieces;

import com.gregspitz.chessapp.domain.model.pieces.Knight;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for the implementation of {@link Knight}
 */

public class KnightTest {

    private static final int STARTING_FILE = 2;
    private static final int STARTING_RANK = 3;

    private Knight mWhiteKnight;
    private Knight mBlackKnight;

    @Before
    public void setup() {
        mWhiteKnight = new Knight(true);
        mBlackKnight = new Knight(false);
    }

    @Test
    public void blackAndWhiteKnight_canMoveInLShapeAnyDirection() {
        assertTrue(mWhiteKnight.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE + 1, STARTING_RANK + 2));
        assertTrue(mWhiteKnight.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE - 1, STARTING_RANK + 2));
        assertTrue(mWhiteKnight.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE + 1, STARTING_RANK - 2));
        assertTrue(mWhiteKnight.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE - 1, STARTING_RANK - 2));
        assertTrue(mWhiteKnight.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE + 2, STARTING_RANK + 1));
        assertTrue(mWhiteKnight.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE - 2, STARTING_RANK + 1));
        assertTrue(mWhiteKnight.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE + 2, STARTING_RANK - 1));
        assertTrue(mWhiteKnight.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE - 2, STARTING_RANK - 1));
        assertTrue(mBlackKnight.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE + 1, STARTING_RANK + 2));
        assertTrue(mBlackKnight.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE - 1, STARTING_RANK + 2));
        assertTrue(mBlackKnight.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE + 1, STARTING_RANK - 2));
        assertTrue(mBlackKnight.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE - 1, STARTING_RANK - 2));
        assertTrue(mBlackKnight.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE + 2, STARTING_RANK + 1));
        assertTrue(mBlackKnight.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE - 2, STARTING_RANK + 1));
        assertTrue(mBlackKnight.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE + 2, STARTING_RANK - 1));
        assertTrue(mBlackKnight.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE - 2, STARTING_RANK - 1));
    }

    @Test
    public void blackAndWhiteKnight_noMoveDoesNotCount() {
        assertFalse(mWhiteKnight.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE, STARTING_RANK));
        assertFalse(mBlackKnight.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE, STARTING_RANK));
    }

    @Test
    public void blackAndWhiteKnight_cannotMoveInAnyOtherWay() {
        assertFalse(mWhiteKnight.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE, STARTING_RANK + 1));
        assertFalse(mWhiteKnight.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE, STARTING_RANK + 2));
        assertFalse(mWhiteKnight.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE, STARTING_RANK - 1));
        assertFalse(mWhiteKnight.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE, STARTING_RANK - 2));
        assertFalse(mWhiteKnight.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE + 1, STARTING_RANK));
        assertFalse(mWhiteKnight.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE + 2, STARTING_RANK));
        assertFalse(mWhiteKnight.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE - 1, STARTING_RANK));
        assertFalse(mWhiteKnight.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE - 2, STARTING_RANK));
        assertFalse(mWhiteKnight.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE + 1, STARTING_RANK + 1));
        assertFalse(mWhiteKnight.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE + 2, STARTING_RANK + 2));
        assertFalse(mWhiteKnight.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE - 1, STARTING_RANK - 1));
        assertFalse(mWhiteKnight.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE - 2, STARTING_RANK - 2));
        assertFalse(mBlackKnight.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE, STARTING_RANK + 1));
        assertFalse(mBlackKnight.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE, STARTING_RANK + 2));
        assertFalse(mBlackKnight.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE, STARTING_RANK - 1));
        assertFalse(mBlackKnight.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE, STARTING_RANK - 2));
        assertFalse(mBlackKnight.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE + 1, STARTING_RANK));
        assertFalse(mBlackKnight.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE + 2, STARTING_RANK));
        assertFalse(mBlackKnight.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE - 1, STARTING_RANK));
        assertFalse(mBlackKnight.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE - 2, STARTING_RANK));
        assertFalse(mBlackKnight.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE + 1, STARTING_RANK + 1));
        assertFalse(mBlackKnight.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE + 2, STARTING_RANK + 2));
        assertFalse(mBlackKnight.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE - 1, STARTING_RANK - 1));
        assertFalse(mBlackKnight.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE - 2, STARTING_RANK - 2));
    }
}
