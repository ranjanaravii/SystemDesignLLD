package com.developer.LLD.TicTacToe;

import com.developer.LLD.TicTacToe.model.Board;
import com.developer.LLD.TicTacToe.model.Player;
import com.developer.LLD.TicTacToe.model.PlayingPieceO;
import com.developer.LLD.TicTacToe.model.PlayingPieceX;

import java.util.Deque;
import java.util.LinkedList;

public class GameController {
    Deque<Player> players;
    Board board;

    GameController(){
        initializeGame();
    }

    private void initializeGame() {
        //create 2 players
        players = new LinkedList<>();
        PlayingPieceX playingPieceX = new PlayingPieceX();
        Player player1 = new Player("Player1", playingPieceX);

        PlayingPieceO playingPieceO = new PlayingPieceO();
        Player player2 = new Player("Player2", playingPieceO);
        players.add(player1);
        players.add(player2);

        //initialize board;
        board = new Board(3);
    }

    public String startGame(){
        boolean gaveOver = false;
        int moves = 0;
        while (!gaveOver){
            Player playerTurn = players.removeFirst();
            board.printBoard();
        }
        return "";
    }
}
