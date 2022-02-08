package com.example.tictactoe.game;

import android.view.View;
import android.widget.Button;

public class Listener implements View.OnClickListener {
    private int x = 0;
    private int y = 0;

    public Listener(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void onClick(View view) {
        Button button = (Button) view;
    }
}