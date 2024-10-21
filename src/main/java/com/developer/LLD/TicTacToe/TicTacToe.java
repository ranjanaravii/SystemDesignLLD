package com.developer.LLD.TicTacToe;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

    public  void startTicTacToe() {
        char[][] board = new char[3][3];

        for (char[] chars : board) {
            Arrays.fill(chars, ' ');
        }

        char currentPlayer = 'X';
        boolean gameOver = false;
        int moves = 0;
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            printBoard(board);
            System.out.println("Player " + currentPlayer + ", enter your move (row[1-3] column[1-3]): ");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            if (row > 3 || col > 3 || row < 0 || col < 0) {
                System.out.println("Invalid move! Try again.");
                continue;
            }

            if (board[row][col] == ' ') {
                //place the move on the board
                board[row][col] = currentPlayer;
                gameOver = checkWin(board, currentPlayer);
                if (gameOver) {
                    System.out.println("Player " + currentPlayer + " wins!");
                }
                else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                    moves++;
                    if (moves == 9) {
                        System.out.println("It's a draw!");
                        gameOver = true;
                    }
                }
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }
        printBoard(board);
    }

    private static boolean checkWin(char[][] board, char currentPlayer) {
        //check rows
        for (char[] chars : board) {
            if (chars[0] == currentPlayer && chars[1] == currentPlayer
                    && chars[2] == currentPlayer) {
                return true;
            }
        }

        //check cols
        for (int col = 0; col < board.length; col++) {
            if (board[0][col] == currentPlayer && board[1][col] == currentPlayer
                    && board[2][col] == currentPlayer ){
                return true;
            }
        }

        //check diagonals
        if (board[0][0] == currentPlayer &&
                board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }

        if (board[2][0] == currentPlayer &&
                board[1][1] == currentPlayer && board[0][2] == currentPlayer) {
            return true;
        }
        return false;
    }

    private static void printBoard(char[][] board) {
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(aChar + " | ");
            }
            System.out.println();
        }
    }
}
