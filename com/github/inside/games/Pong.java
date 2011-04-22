package com.github.inside.games;

import javax.swing.JFrame;
import com.github.inside.games.Board;

class Pong extends JFrame
{
    public Pong()
    {
        this.add(new Board());
        this.setTitle("Pong");
        this.setSize(500, 250);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        new Pong();
    }
}
