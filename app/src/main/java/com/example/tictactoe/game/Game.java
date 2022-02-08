package com.example.tictactoe.game;

public class Game {

    private Square[][] field;

    private Player[] players;

    private int squareCount;

    private boolean isStarted;

    private Player activePlayer;

    private int filled;

    private WinnerCheckerInterface[] winnerCheckers;

    public Game() {
        field = new Square[3][3];

        for (int i = 0, l = field.length; i < l; i++) {
            for (int j = 0, l2 = field[i].length; j < l2; j++) {
                field[i][j] = new Square();
                squareCount++;
            }
        }

        players = new Player[2];
        isStarted = false;
        activePlayer = null;
        filled = 0;

        winnerCheckers = new WinnerCheckerInterface[4];
        winnerCheckers[0] = new WinnerCheckerHorizontal(this);
        winnerCheckers[1] = new WinnerCheckerVertical(this);
        winnerCheckers[2] = new WinnerCheckerDiagonalLeft(this);
        winnerCheckers[3] = new WinnerCheckerDiagonalRight(this);
    }

    private void resetPlayers() {
        players[0] = new Player("X");
        players[1] = new Player("O");
        setCurrentActivePlayer(players[0]);
    }

    private void setCurrentActivePlayer(Player player) {
        activePlayer = player;
    }

    public Player getCurrentActivePlayer() {
        return activePlayer;
    }

    private void switchPlayer() {
        activePlayer = (activePlayer == players[0]) ? players[1] : players[0];

//        if (activePlayer == players[0]){
//            activePlayer=players[1];
//        }else{
//            activePlayer = players[0];
//        }
    }

    public boolean makeTurn(int x, int y) {
        if (field[x][y].isFilled()) return false;

        field[x][y].fill(getCurrentActivePlayer());
        filled++;
        switchPlayer();
        return true;
    }

    public void start () {
        isStarted = true;
        resetPlayers();
    }

    public Square[][] getField () {
        return field;
    }

    public boolean isFieldFilled() {
        return squareCount == filled;
    }

    private void resetField() {
        for (int i = 0, l = field.length; i < l; i++) {
            for (int j = 0, l2 = field[i].length; j < l2; j++) {
                field[i][j].fill(null);
            }
        }
        filled = 0;
    }

    public void reset() {
        resetField();
        resetPlayers();
    }

    public Player checkWinner() {
//        for (int i=0;i< winnerCheckers.length;i++){
//            Player winner = winnerCheckers[i].checkWinner();
//            if (winner != null) {
//                return winner;
//            }
//        }
        for (WinnerCheckerInterface winChecker : winnerCheckers) {
            Player winner = winChecker.checkWinner();
            if (winner != null) {
                return winner;
            }
        }
        return null;
    }
}
