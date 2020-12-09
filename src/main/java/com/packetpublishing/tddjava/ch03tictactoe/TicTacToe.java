package com.packetpublishing.tddjava.ch03tictactoe;

/**
 * @author mofei
 * @see tdd-java-ch03-tic-tac-toe
 * @since 2020/12/7 11:16
 */
public class TicTacToe {
    private Character[][] board = {{'\0', '\0', '\0'}, {'\0', '\0', '\0'}, {'\0', '\0', '\0'}};
    private char lastPlayer = '\0';

    /**
     * 0 0 0
     * X 0 0
     * 0 0 0  为什么需要X-1因为数组的坐标是从0开始的
     *
     * @param x 横坐标
     * @param y 纵坐标
     */
    public void play(int x, int y) {
        checkAxis(x);
        checkAxis(y);
        setBox(x, y);
        //玩了一次以后切换玩家
        lastPlayer= nextPlayer();
    }

    private void setBox(int x, int y) {
        if (board[x - 1][y - 1] != '\0') {
            throw new RuntimeException("board is occupied");
        } else {
            board[x - 1][y - 1] = 'X';
        }
    }

    private void checkAxis(int axis) {
        if (axis < 1 || axis > 3) {
            throw new RuntimeException("Axis  is outside board");
        }
    }


    public char nextPlayer() {
        if (lastPlayer == 'X') {
            return 'O';
        }
        return 'X';
    }
}
