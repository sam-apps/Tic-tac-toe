package com.example.tictactoe.game;

public class Square {
    private Player player = null;

    public void fill(Player player){
        this.player = player;
    }

    public Player getPlayer(){
        return player;
    }

    public boolean isFilled(){
        return player != null;
    }
}
