package com.packetpublishing.tddjava.ch03tictactoe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author mofei
 * @since 2020/12/7 11:17
 */
public class TicTacToeSpec {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    private TicTacToe ticTacToe;

    @Before
    public final void before() {
        ticTacToe = new TicTacToe();
    }

    @Test
    public void 如果X轴越界则运行时异常() {
        exception.expect(RuntimeException.class);
        ticTacToe.play(5, 2);
    }

    @Test
    public void 如果Y轴越界则运行时异常() {
        exception.expect(RuntimeException.class);
        ticTacToe.play(2, 5);
    }

    @Test
    public void 如果重复下棋则运行时异常() {
        ticTacToe.play(1, 2);
        exception.expect(RuntimeException.class);
        ticTacToe.play(1, 2);
    }

    @Test
    public void testNextPlayer() {
        assertEquals('X', ticTacToe.nextPlayer());
    }

    @Test
    public void testNextPlayerIsO() {
        ticTacToe.play(1, 2);
        assertEquals('O', ticTacToe.nextPlayer());
    }

    @Test
    public void whenThirdTurnThenNextPlayerO() {
        ticTacToe.play(1, 2);
        ticTacToe.play(2, 1);
        assertEquals('X', ticTacToe.nextPlayer());
    }


    @Test
    public void 没有获胜者() {
        String actual = ticTacToe.play(3, 2);
        assertEquals("No Winner", actual);
    }

    /**
     * X X X
     * 0 0 0
     * 0 0 0
     */
    @Test
    public void 如果水平直线一排则胜利() {
        ticTacToe.play(1, 1);
        ticTacToe.play(2, 2);
        ticTacToe.play(1, 2);
        ticTacToe.play(2, 3);
        String actual = ticTacToe.play(1, 3);
        assertEquals("X is the Winner", actual);
    }

    /**
     * X 0 o
     * X o 0
     * X 0 0
     */
    @Test
    public void 如果垂直线是一排则胜利() {
        ticTacToe.play(1, 1);
        ticTacToe.play(2, 2);
        ticTacToe.play(2, 1);
        ticTacToe.play(1, 3);
        String actual = ticTacToe.play(3, 1);
        assertEquals("X is the Winner", actual);
    }

    /**
     * X 0 o
     * 0 X o
     * o 0 x
     */
    @Test
    public void 如果是斜对角线则是O获得胜利() {
        ticTacToe.play(1, 1); // X
        ticTacToe.play(1, 2); // O
        ticTacToe.play(2, 2); // X
        ticTacToe.play(1, 3); // O
        String actual = ticTacToe.play(3, 3); // O
        assertEquals("X is the Winner", actual);
    }
    /**
     * 0 0 X
     * 0 X o
     * X 0 o
     */
    @Test
    public void 如果是斜对角线2则获胜的是O() {
        ticTacToe.play(3,1);
        ticTacToe.play(2,1);
        ticTacToe.play(2,2);
        ticTacToe.play(1,2);
        String play = ticTacToe.play(1, 3);
        assertEquals("X is the Winner", play);
    }

    /**
     * X 0 o
     * o o X
     * X 0 X
     */
    @Test
    public void 如果棋局走完则平局() {
        ticTacToe.play(1,1); //X
        ticTacToe.play(2,1); //O
        ticTacToe.play(3,3); //X
        ticTacToe.play(2,2); //o
        ticTacToe.play(2,3); //x
        ticTacToe.play(1,3); //O
        ticTacToe.play(3,1); //X
        ticTacToe.play(3,2); //o
        String play = ticTacToe.play(1, 2); //x
        assertEquals("is Law",play);
    }

}