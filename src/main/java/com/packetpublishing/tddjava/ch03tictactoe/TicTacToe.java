package com.packetpublishing.tddjava.ch03tictactoe;

/**
 * @author mofei
 * @since 2020/12/7 11:16
 */
public class TicTacToe {
    private char[][] board = {{'\0', '\0', '\0'}, {'\0', '\0', '\0'}, {'\0', '\0', '\0'}};
    private char lastPlayer = '\0';
    private final int SIZE = 3;

    public String play(int x, int y) {
        checkAxis(x);
        checkAxis(y);
        lastPlayer = nextPlayer();
        setBox(x, y, lastPlayer);
        if (isWin()) {
            return lastPlayer + " is the Winner";
        } else if (isLaw()) {
            return "is Law";
        }
        return "No Winner";
    }

    private boolean isLaw() {
        for (int i = 0; i < SIZE; i++) {
            for (int y = 0; y < SIZE; y++) {
                if (board[i][y] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isWin() {
        int playTotal = lastPlayer * SIZE;
        for (int i = 0; i < SIZE; i++) {
            if (board[0][i] + board[1][i] + board[2][i] == playTotal) {
                return true;
            }
            if (board[i][1] + board[i][1] + board[i][2] == playTotal) {
                return true;
            }
        }
        if (board[0][0] + board[1][1] + board[2][2] == playTotal) {
            return true;
        }
        if (board[0][2] + board[1][1] + board[2][0] == playTotal) {
            return true;
        }
        return false;
    }

    private void setBox(int x, int y, char lastPlayer) {
        if (board[x - 1][y - 1] != '\0') {
            throw new RuntimeException("X is occurd board");
        } else {
            board[x - 1][y - 1] = lastPlayer;
        }
    }

    private void checkAxis(int x) {
        if (x < 1 || x > 3) {
            throw new RuntimeException("X is out board");
        }
    }

    public char nextPlayer() {
        if (lastPlayer == 'X') {

            return 'O';
        }
        return 'X';
    }
}
