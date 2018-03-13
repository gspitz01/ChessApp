package com.gregspitz.chessapp.domain.model.pieces;

import com.gregspitz.chessapp.domain.model.pieces.Bishop;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for the implementation of {@link Bishop}
 */

public class BishopTest {

    private static final int STARTING_FILE = 2;
    private static final int STARTING_RANK = 3;

    private Bishop mWhiteBishop;
    private Bishop mBlackBishop;

    @Before
    public void setup() {
        mWhiteBishop = new Bishop(true);
        mBlackBishop = new Bishop(false);
    }

    @Test
    public void blackAndWhiteBishop_canMoveDiagonallyAnyNumberOfSquares() {
        for (int i = 1; i < 20; i++) {
            assertTrue(mWhiteBishop.canMove(STARTING_FILE, STARTING_RANK,
                    STARTING_FILE + i, STARTING_RANK + i));
            assertTrue(mWhiteBishop.canMove(STARTING_FILE, STARTING_RANK,
                    STARTING_FILE + i, STARTING_RANK - i));
            assertTrue(mWhiteBishop.canMove(STARTING_FILE, STARTING_RANK,
                    STARTING_FILE - i, STARTING_RANK + i));
            assertTrue(mWhiteBishop.canMove(STARTING_FILE, STARTING_RANK,
                    STARTING_FILE - i, STARTING_RANK - i));
            assertTrue(mBlackBishop.canMove(STARTING_FILE, STARTING_RANK,
                    STARTING_FILE + i, STARTING_RANK + i));
            assertTrue(mBlackBishop.canMove(STARTING_FILE, STARTING_RANK,
                    STARTING_FILE + i, STARTING_RANK - i));
            assertTrue(mBlackBishop.canMove(STARTING_FILE, STARTING_RANK,
                    STARTING_FILE - i, STARTING_RANK + i));
            assertTrue(mBlackBishop.canMove(STARTING_FILE, STARTING_RANK,
                    STARTING_FILE - i, STARTING_RANK - i));
        }
    }

    @Test
    public void blackAndWhiteBishop_noMoveDoesNotCount() {
        assertFalse(mWhiteBishop.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE, STARTING_RANK));
        assertFalse(mBlackBishop.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE, STARTING_RANK));
    }

    @Test
    public void blackAndWhiteBishop_cannotMoveStraight() {
        for (int i = 1; i < 20; i++) {
            assertFalse(mWhiteBishop.canMove(STARTING_FILE, STARTING_RANK,
                    STARTING_FILE, STARTING_RANK + i));
            assertFalse(mWhiteBishop.canMove(STARTING_FILE, STARTING_RANK,
                    STARTING_FILE, STARTING_RANK - i));
            assertFalse(mWhiteBishop.canMove(STARTING_FILE, STARTING_RANK,
                    STARTING_FILE + i, STARTING_RANK ));
            assertFalse(mWhiteBishop.canMove(STARTING_FILE, STARTING_RANK,
                    STARTING_FILE - i, STARTING_RANK ));
            assertFalse(mBlackBishop.canMove(STARTING_FILE, STARTING_RANK,
                    STARTING_FILE, STARTING_RANK + i));
            assertFalse(mBlackBishop.canMove(STARTING_FILE, STARTING_RANK,
                    STARTING_FILE, STARTING_RANK - i));
            assertFalse(mBlackBishop.canMove(STARTING_FILE, STARTING_RANK,
                    STARTING_FILE + i, STARTING_RANK ));
            assertFalse(mBlackBishop.canMove(STARTING_FILE, STARTING_RANK,
                    STARTING_FILE - i, STARTING_RANK ));
        }
    }

    @Test
    public void blackAndWhiteBishop_cannotMoveAnyOtherWay() {
        assertFalse(mWhiteBishop.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE, STARTING_RANK + 2));
        assertFalse(mWhiteBishop.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE + 2, STARTING_RANK));
        assertFalse(mWhiteBishop.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE + 1, STARTING_RANK + 2));
        assertFalse(mWhiteBishop.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE + 2, STARTING_RANK + 1));
        assertFalse(mWhiteBishop.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE, STARTING_RANK - 2));
        assertFalse(mWhiteBishop.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE - 2, STARTING_RANK));
        assertFalse(mWhiteBishop.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE - 1, STARTING_RANK - 2));
        assertFalse(mWhiteBishop.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE - 2, STARTING_RANK - 1));
        assertFalse(mWhiteBishop.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE - 1, STARTING_RANK + 2));
        assertFalse(mWhiteBishop.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE + 2, STARTING_RANK - 1));
        assertFalse(mWhiteBishop.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE + 1, STARTING_RANK - 2));
        assertFalse(mWhiteBishop.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE - 2, STARTING_RANK + 1));
        assertFalse(mBlackBishop.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE, STARTING_RANK + 2));
        assertFalse(mBlackBishop.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE + 2, STARTING_RANK));
        assertFalse(mBlackBishop.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE + 1, STARTING_RANK + 2));
        assertFalse(mBlackBishop.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE + 2, STARTING_RANK + 1));
        assertFalse(mBlackBishop.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE, STARTING_RANK - 2));
        assertFalse(mBlackBishop.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE - 2, STARTING_RANK));
        assertFalse(mBlackBishop.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE - 1, STARTING_RANK - 2));
        assertFalse(mBlackBishop.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE - 2, STARTING_RANK - 1));
        assertFalse(mBlackBishop.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE - 1, STARTING_RANK + 2));
        assertFalse(mBlackBishop.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE + 2, STARTING_RANK - 1));
        assertFalse(mBlackBishop.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE + 1, STARTING_RANK - 2));
        assertFalse(mBlackBishop.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE - 2, STARTING_RANK + 1));
    }
}
