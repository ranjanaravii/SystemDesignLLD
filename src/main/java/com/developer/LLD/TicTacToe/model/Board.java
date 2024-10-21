package com.developer.LLD.TicTacToe.model;

public class Board {
    int size;
    public PlayingPiece[][] board;

    public Board(int size) {
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public boolean addPiece(int x, int y, PlayingPiece playingPiece) {
        if (x < 0 || x >= size || y < 0 || y >= size) {
            return false;
        }
        if (board[x][y] != null) {
            return false;
        }
        board[x][y] = playingPiece;
        return true;
    }

    public void printBoard() {
        for (PlayingPiece[] row : board) {
            for (PlayingPiece playingPiece : row) {
                if (playingPiece == null) {
                    System.out.print(' ');
                } else {
                    System.out.print(playingPiece.getPieceType());
                }
            }
            System.out.println();
        }
    }
}
