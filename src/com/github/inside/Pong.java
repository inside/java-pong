package com.github.inside;

import javax.swing.JFrame;
import com.github.inside.Board;
import com.github.inside.Config;

class Pong extends JFrame
{
    public Pong()
    {
        this.add(new Board());
        this.setTitle("Pong");
        this.setSize(Config.PONG_WIDTH , Config.PONG_HEIGHT);
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
