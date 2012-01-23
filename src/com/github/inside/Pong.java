package com.github.inside;

import javax.swing.JFrame;
import java.awt.Color;
import com.github.inside.Board;
import com.github.inside.Config;
import com.github.inside.RepeatingReleasedEventsFixer;

class Pong extends JFrame
{
    public Pong()
    {
        new RepeatingReleasedEventsFixer().install();
        this.setLayout(null);
        this.getContentPane().setBackground(Color.decode("#f5f5f5"));
        this.add(new Board());
        this.setTitle("Pong");
        this.setBounds(0,
                       0,
                       Config.BOARD_WIDTH + Config.FRAME_LEFT_MARGIN + Config.FRAME_RIGHT_MARGIN,
                       Config.BOARD_HEIGHT + Config.FRAME_TOP_MARGIN + Config.FRAME_BOTTOM_MARGIN);
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
