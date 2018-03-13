package com.gregspitz.chessapp.domain.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for the implementation of {@link Pawn}
 */

public class PawnTest {

    private static final int STARTING_FILE = 2;
    private static final int STARTING_RANK = 3;

    private Pawn mWhitePawn;

    private Pawn mBlackPawn;

    @Before
    public void setup() {
        mWhitePawn = new Pawn(true);
        mBlackPawn = new Pawn(false);
    }

    @Test
    public void whitePawn_canMoveNegativeRankDirectionProperDistance() {
        assertTrue(mWhitePawn.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE, STARTING_RANK - 1));
        assertTrue(mWhitePawn.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE, STARTING_RANK - 2));
        assertTrue(mWhitePawn.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE - 1, STARTING_RANK - 1));
        assertTrue(mWhitePawn.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE + 1, STARTING_RANK - 1));
    }

    @Test
    public void whitePawn_cannotMoveNegativeRankDirectionImproperDistance() {
        assertFalse(mWhitePawn.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE, STARTING_RANK - 3));
        assertFalse(mWhitePawn.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE, STARTING_RANK - 4));
        assertFalse(mWhitePawn.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE - 1, STARTING_RANK - 2));
        assertFalse(mWhitePawn.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE + 1, STARTING_RANK - 2));
    }

    @Test
    public void whitePawn_cannotMovePositiveRankDirection() {
        assertFalse(mWhitePawn.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE, STARTING_RANK + 1));
        assertFalse(mWhitePawn.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE, STARTING_RANK + 2));
        assertFalse(mWhitePawn.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE - 1, STARTING_RANK + 1));
        assertFalse(mWhitePawn.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE + 1, STARTING_RANK + 1));
    }

    @Test
    public void whiteAndBlackPawn_noMoveDoesNotCount() {
        assertFalse(mWhitePawn.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE, STARTING_RANK));
        assertFalse(mBlackPawn.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE, STARTING_RANK));
    }

    @Test
    public void blackPawn_canMovePositiveRankDirectionProperDistance() {
        assertTrue(mBlackPawn.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE, STARTING_RANK + 1));
        assertTrue(mBlackPawn.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE, STARTING_RANK + 2));
        assertTrue(mBlackPawn.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE - 1, STARTING_RANK + 1));
        assertTrue(mBlackPawn.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE + 1, STARTING_RANK + 1));
    }

    @Test
    public void blackPawn_cannotMovePositiveRankDirectionImproperDistance() {
        assertFalse(mBlackPawn.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE, STARTING_RANK + 3));
        assertFalse(mBlackPawn.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE, STARTING_RANK + 4));
        assertFalse(mBlackPawn.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE - 1, STARTING_RANK + 2));
        assertFalse(mBlackPawn.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE + 1, STARTING_RANK + 2));
    }

    @Test
    public void blackPawn_cannotMoveNegativeRankDirection() {
        assertFalse(mBlackPawn.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE, STARTING_RANK - 1));
        assertFalse(mBlackPawn.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE, STARTING_RANK - 2));
        assertFalse(mBlackPawn.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE - 1, STARTING_RANK - 1));
        assertFalse(mBlackPawn.canMove(STARTING_FILE, STARTING_RANK,
                STARTING_FILE + 1, STARTING_RANK - 1));
    }

}
