package com.packetpublishing.tddjava.ch03tictactoe;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 * @author mofei
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


}
