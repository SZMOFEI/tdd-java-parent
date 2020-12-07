package com.packetpublishing.tddjava.ch03tictactoe;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author mofei
 * @see tdd-java-ch03-tic-tac-toe
 * @since 2020/12/7 11:17
 */
public class TicTacToeSpec {
    @Rule
    public ExpectedException exception=ExpectedException.none();

    private TicTacToe ticTacToe;

    @Before
    public final void before()   {
        ticTacToe= new TicTacToe();
    }

    /**
     * 1.X超过界限上
     * 1.X超过界限下
     * 2.Y超过界限上
     * 2.Y超过界限下
     * 2.棋盘被占用
     */
    @Test
    public void whenXOutsideBoardThenRuntimeException(){
        exception.expect(RuntimeException.class);
        ticTacToe.play(5,2);
    }
    @Test
    public void whenXOutsideBoard2ThenRuntimeException(){
        exception.expect(RuntimeException.class);
        ticTacToe.play(0,2);
    }

    @Test
    public void whenYOoutsideBoardThenRuntimeException() {
        exception.expect(RuntimeException.class);
        ticTacToe.play(2,5);
    }

    @Test
    public void whenPccupiedThenRuntimeException() {
        ticTacToe.play(2,1);
        exception.expect(RuntimeException.class);
        ticTacToe.play(2,1);
    }
}
